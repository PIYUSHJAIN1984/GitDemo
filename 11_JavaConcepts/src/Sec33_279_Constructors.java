
public class Sec33_279_Constructors {

	// Default constructor
	public Sec33_279_Constructors() {
		System.out.println("I am in default constructor");
	}

	// Parameterized constructor
	public Sec33_279_Constructors(int a, int b) {
		System.out.println("I am in parameterized  constructor");
	}

	public Sec33_279_Constructors(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		Sec33_279_Constructors a = new Sec33_279_Constructors();
		Sec33_279_Constructors a1 = new Sec33_279_Constructors(4, 5);
		Sec33_279_Constructors a2 = new Sec33_279_Constructors("abcdddd");

	}

}
