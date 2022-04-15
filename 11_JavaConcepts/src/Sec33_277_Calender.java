import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Sec33_277_Calender {

	public static void main(String[] args) {

		// Create calender object
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy hh:mm:ss");
		System.out.println(sdf.format(cal.getTime()));

		// Get day of month : Calender has unique features which Date class does not have
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));

	}

}
