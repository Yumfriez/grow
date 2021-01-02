package behavioral.chain.entity;

import java.util.List;

import static java.util.Optional.ofNullable;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Robot {

	private Head head;
	private Body body;
	private List<Arm> arms;
	private List<Leg> legs;

	public Robot() {
	}

	public void walk() {
		ofNullable(legs).filter(a -> !a.isEmpty())
				.ifPresentOrElse(a -> System.out.println("I'm walking..."), () -> System.out.println("I don't have legs!"));
	}

	public void punch() {
		ofNullable(arms).filter(a -> !a.isEmpty())
				.ifPresentOrElse(a -> System.out.println("I'm punching..."), () -> System.out.println("I don't have arms!"));
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public List<Arm> getArms() {
		return arms;
	}

	public void setArms(List<Arm> arms) {
		this.arms = arms;
	}

	public List<Leg> getLegs() {
		return legs;
	}

	public void setLegs(List<Leg> legs) {
		this.legs = legs;
	}
}
