
public class Sec33_283_ThisDemo {

	int a = 2;

	public void getData() {
		int a = 3;
		System.out.println(a);

		// this refers to current object and object scope lies in class level
		System.out.println(this.a);

		int c = a + this.a;
		System.out.println(c);
	}

	public static void main(String[] args) {
		Sec33_283_ThisDemo d = new Sec33_283_ThisDemo();
		d.getData();
	}
}
