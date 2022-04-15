import java.io.IOException;
import java.util.ArrayList;

public class Sec24_171_MainClass {

	public static void main(String[] args) throws IOException {
		Sec24_171_dataDriven d= new Sec24_171_dataDriven();
		ArrayList<String> data =d.getData("Add Profile");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));

	}
}
