
public class Sec33_282_2_ChildSuper extends Sec33_282_1_ParentSuper {
	String name = "Child";

	public Sec33_282_2_ChildSuper() {
		// Using super we can invoke parent constructor
		// It has to be in first line of child constructor
		super();
		System.out.println("Child constructor");
	}

	public void getStringData() {
		System.out.println(super.name);
		System.out.println(name);
	}

	public void getData() {
		super.getData();
		System.out.println("I am in child class");
	}

	public static void main(String[] args) {
		Sec33_282_2_ChildSuper c = new Sec33_282_2_ChildSuper();
		c.getStringData();
		c.getData();
	}
}