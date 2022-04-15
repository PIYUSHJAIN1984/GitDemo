import java.text.SimpleDateFormat;
import java.util.Date;

public class Sec33_276_DemoDateClass {

	public static void main(String[] args) {
		// Current Date and Current Time
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy hh:mm:ss");

		System.out.println(d.toString());

		// Get format in mm//dd//yyyy HH:MM:SS --> For this use SimpleDateFormat class
		System.out.println(sdf.format(d));

	}

}
