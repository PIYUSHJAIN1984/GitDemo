import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sec25_176_MainClass {

	public static void main(String[] args) throws IOException {
		Sec25_176_dataDriven d = new Sec25_176_dataDriven();
		ArrayList<String> data = d.getData("Tags");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		System.out.println(data.get(4));

		ArrayList<String> data1 = d.getData("PL");
		System.out.println(data1.get(0));
		System.out.println(data1.get(1));
		System.out.println(data1.get(2));

		ArrayList<String> list = new ArrayList<String>();

		for (String s : data) {
			String[] dateSplit = s.split(";");
			String s3 = null;
			for (String d1 : dateSplit) {
				String t1 = d1.replaceAll("\\s", "");

				for (String s2 : data1) {
					if (t1.equalsIgnoreCase(s2)) {
						if (s3 == null) {
							s3 = t1;
						} else {
							s3 = s3.concat(",").concat(t1);
						}
						break;
					}
				}
			}
			list.add(s3);
		}
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		
		
	}
}
