package Sec32_263_Inheritance;

public class Sec32_265_2_ChildDemo extends Sec32_265_1_ParentDemo {

	String name = "QAClickAcademy";

	public Sec32_265_2_ChildDemo() {
		super();// this should be always be at first line
		System.out.println("child class construtor");
	}

	public void getStringdata() {
		System.out.println(name);
		System.out.println(super.name);
	}

	public void getData() {
		super.getData();
		System.out.println("I am in child class");
	}

	public static void main(String[] args) {
		Sec32_265_2_ChildDemo cd = new Sec32_265_2_ChildDemo();
		cd.getStringdata();
		cd.getData();
	}

}