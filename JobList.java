import java.util.ArrayList;
import java.util.Iterator;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.*;

public class JobList extends ArrayList
{

	JobList()
	{

    }

	public static JobList getJobInfo()
	{
		JobList joblist = new JobList();
		String[] jobHolder;
		try
		{
		   FileReader reader = new FileReader("jobinfo.txt");
		   BufferedReader eyes = new BufferedReader(reader);
		   String line;
		   while((line = eyes.readLine()) != null && line.length() > 5)
		   {
			  jobHolder = line.split("\\|");

			  String[] calendarHolder = jobHolder[0].split("\\-");
			  int year = Integer.parseInt(calendarHolder[0]);
			  int month = Integer.parseInt(calendarHolder[1]) - 1;
			  int day = Integer.parseInt(calendarHolder[2]);

			  GregorianCalendar calendar = new GregorianCalendar(year, month, day);
			  String jobNumber = jobHolder[1];
			  Double hours = Double.parseDouble(jobHolder[2]);
			  Job job = new Job(calendar, jobNumber, hours);
			  joblist.add(job);
		   }
		   eyes.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
			ex.printStackTrace();
		}
		return joblist;
	}

	public static void saveJobInfo(Job job)
	{
		JobList joblist = getJobInfo();
		try
		{
		   FileWriter writer = new FileWriter("jobinfo.txt");
		   BufferedWriter pen = new BufferedWriter(writer);

		   if(joblist.size() == 0)
		   {
			   pen.write(job.toString());
			   pen.newLine();
		   }
		   else
		   {
			 for(Object tra: joblist)
			 {
				 pen.write(tra.toString());
				 pen.newLine();
			 }
			/* for(int i = 0; i == 0 || previous[i] != null; i++)
			 {
				String jo = previous[i];
				pen.write(jo);
				pen.newLine();
			 }*/
			 pen.write(job.toString());
			 pen.newLine();
		   }
	   pen.close();
		}
		catch(Exception ex)
		{
			System.out.println("error");
			System.out.println(ex.toString());
			System.out.println();
			ex.printStackTrace();
        }
	}

	public static void deleteAndSave(int i)
	{
		int index = i;
		JobList joblist = JobList.getJobInfo();
		try
		{
		   FileWriter writer = new FileWriter("jobinfo.txt");
		   BufferedWriter pen = new BufferedWriter(writer);

		   joblist.remove(index);


		   for(Object tra: joblist)
		   {
		      pen.write(tra.toString());
			  pen.newLine();
		   }
	    pen.close();
		}
		catch(Exception ex)
		{
			System.out.println("error");
			System.out.println(ex.toString());
			System.out.println();
			ex.printStackTrace();
        }

	}

    public JobList fitInMonth(GregorianCalendar calendar)
    {
		JobList joblist = new JobList();
		for(Object job: this)
		{
			Job j = (Job) job;
			if(j.isWithinRange(calendar))
			{
				joblist.add(j);
			}
		}
		return joblist;
	}
}