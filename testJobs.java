import java.util.GregorianCalendar;

public class testJobs
{
	public static void main (String[]args)
	{
		JobList jobs = JobList.getJobInfo();
		JobList newList = jobs.fitInMonth(new GregorianCalendar());

		Job[][] alljobs = CalendarPanel.getJobs(new GregorianCalendar());

		for(int i = 0; i <= alljobs.length - 1; i++)
		{
		   for(int k = 0; k <= alljobs[i].length - 1; k++)
		   {
			   if(alljobs[i][k] != null)
			   {
				   System.out.println(k + "   " + alljobs[i][k].toString());
			   }
		   }
		   System.out.println(i);
	   }
	}
}