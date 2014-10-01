import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataTransfer
{
	public static GregorianCalendar dateTransfer;
	public static Job[] jobsTransfer;

	public static GregorianCalendar setDateTransfer(GregorianCalendar day)
	{
		day.add(Calendar.MONTH, -1);
		dateTransfer = day;
		return day;
	}

	public static String getJobAdderLabel()
	{
		SimpleDateFormat format = new SimpleDateFormat("MMM, dd, yyyy");
		String label = format.format(dateTransfer.getTime());
		return label;
	}
}

