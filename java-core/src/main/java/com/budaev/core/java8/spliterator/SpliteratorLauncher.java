package com.budaev.core.java8.spliterator;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class SpliteratorLauncher {

	public static void main(String[] args) {

		final List<String> words = Stream.generate(() -> "word").limit(20).collect(Collectors.toList());

		System.out.println("Concurrent " + Spliterator.CONCURRENT);
		System.out.println("Distinct " + Spliterator.DISTINCT);
		System.out.println("Immutable " + Spliterator.IMMUTABLE);
		System.out.println("Nonnull " + Spliterator.NONNULL);
		System.out.println("Ordered " + Spliterator.ORDERED);
		System.out.println("Sorted " + Spliterator.SORTED);
		System.out.println("Subsized " + Spliterator.SUBSIZED);
		System.out.println("Sized " + Spliterator.SIZED);

		final Spliterator<String> spliterator = words.spliterator();
		System.out.println(spliterator.characteristics());

		final Spliterator<String> subSpliterator = spliterator.trySplit();

		StringBuilder stringBuilder = new StringBuilder();
		while (spliterator.tryAdvance(stringBuilder::append)) {
			stringBuilder.append(' ');
		}

		StringBuilder subStringBuilder = new StringBuilder();
		while (subSpliterator.tryAdvance(subStringBuilder::append)) {
			subStringBuilder.append(' ');
		}

		System.out.println("First: " + stringBuilder.toString());
		System.out.println("Second: " + subStringBuilder.toString());

	}
}
