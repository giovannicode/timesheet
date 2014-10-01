import java.util.GregorianCalendar;

public class testblue
{
	public static void main(String[] args)
	{
		JobList joblist = Form.getJobInfo();
		for(Object job: joblist)
		{
			Job j = (Job) job;
			System.out.println(j.toString());
		}

		System.out.println("-------------------------------");

		GregorianCalendar cal = new GregorianCalendar(2011, 11, 1);

		JobList newlist = joblist.fitInMonth(cal);
		for(Object job: newlist)
		{
			Job j = (Job) job;
			System.out.println(j.toString());
		}



        GregorianCalendar c = new GregorianCalendar();
		boolean[] days = CalendarPanel.getJobs(c);
		for(int i = 0; i <= days.length -1; i++)
		{
			System.out.println(days[i]);
		}
	}
}