package com.budaev.core.reflection.entity;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Phone {

	private SimCard simCard;

	public void call() {
		connectToStation();
		sendSignal();
	}

	public void receiveCall() {
		System.out.println("Call received.");
	}

	protected void connectToStation() {
		System.out.println("Connecting to station using sim: " + simCard.getId());
	}

	private void sendSignal() {
		System.out.println("Sending signal using sim: " + simCard.getId());
	}

	public SimCard getSimCard() {
		return simCard;
	}

	public void setSimCard(SimCard simCard) {
		this.simCard = simCard;
	}
}
