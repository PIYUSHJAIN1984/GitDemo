package Sec32_263_Inheritance;

public class Sec32_263_2_ChildInh extends Sec32_263_1_ParentInheritance {

	public static void main(String[] args) {
		Sec32_263_2_ChildInh a = new Sec32_263_2_ChildInh();
		a.color();
		a.brakes();
		a.audioSystem();  //function overriding : both method have same name and same signature and same parameters
	}

	public void color() {
		System.out.println(color);
	}

	public void newEng() {
		System.out.println("new engine");
	}
	
	public void audioSystem() {
		System.out.println("new audio system");
	}

}
