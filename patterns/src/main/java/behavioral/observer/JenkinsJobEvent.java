package behavioral.observer;

import java.time.LocalDateTime;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class JenkinsJobEvent implements Event<LocalDateTime> {

	public JenkinsJobEvent(LocalDateTime finishTime) {
		this.finishTime = finishTime;
	}

	private final LocalDateTime finishTime;

	@Override
	public LocalDateTime getSource() {
		return finishTime;
	}
}
