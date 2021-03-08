package com.budaev.reactive.reactor;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Launcher {

	private static final List<Consumer<String>> consumers = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		listFluxDemo();
		emitterDemo();
	}

	private static void listFluxDemo() throws InterruptedException {
		final ExecutorService executor = Executors.newFixedThreadPool(5);
		final Flux<List<String>> listFlux = Flux.fromIterable(Stream.generate(() -> {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return LocalDateTime.now();
		}).limit(10).collect(Collectors.toList()))
				.map(time -> time + "  " + Thread.currentThread().getName())
				.flatMap(Mono::just)
				.bufferTimeout(3, Duration.ofSeconds(1))
				.subscribeOn(Schedulers.fromExecutor(executor))
				.doAfterTerminate(() -> System.out.println("Terminated"));
		listFlux.subscribe(System.out::println);

		listFlux.subscribe(it -> {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			System.out.println("Sleeping" + it);
		});

		executor.shutdown();
		executor.awaitTermination(5, TimeUnit.SECONDS);

	}

	private static void emitterDemo() {
		final ExecutorService executorService = Executors.newFixedThreadPool(2);
		final Flux<String> bridge = Flux.create(sink -> consumers.add(sink::next));

		final Scheduler scheduler = Schedulers.fromExecutor(executorService);
		bridge.publishOn(scheduler).subscribe(x -> {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " " + x);
		});

		IntStream.range(0, 5).forEach(i -> consumers.forEach(c -> c.accept("Emitter by Create")));

		final EmitterProcessor<String> stringEmitterProcessor = EmitterProcessor.create();
		stringEmitterProcessor.publishOn(scheduler).subscribe(s -> System.out.println(Thread.currentThread().getName() + " " + s));

		final FluxSink<String> sink = stringEmitterProcessor.sink();
		sink.next("Emitter processor");
		sink.next("Emitter processor");
		sink.next("Emitter processor");
		sink.next("Emitter processor");

		executorService.shutdown();
	}
}
