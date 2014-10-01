import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Job
{
	private String jobNumber;
	private double hours;
	private GregorianCalendar day;
	private double tip;
	private String info;

    public Job (GregorianCalendar day, String jobNumber,  Double hours)
	{
		this.day = day;
		this.jobNumber = jobNumber;
		this.hours = hours;
	}

	public GregorianCalendar getDay()
	{
		return this.day;
	}

    public String getJobNumber()
    {
		return this.jobNumber;
	}


	public double getHours()
	{
		return this.hours;
	}

	public double getPay()
	{
		double PAYRATE = 10;
		double pay = PAYRATE * this.hours;
		return pay;
	}

	public static String getCheckTotal(double totalHours)
	{
		double PAYRATE = 10;
		double pay = PAYRATE * totalHours;
		return ("$" + pay);
	}


	public String toString()
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String days = format.format(this.day.getTime());
		String infor = days + "|" + this.jobNumber + "|" + this.hours;

		return infor;
	}

	public int getIndex(GregorianCalendar day)
	{
		day.set(Calendar.DAY_OF_MONTH, 1);
		int lastmonth = 1 - day.get(Calendar.DAY_OF_WEEK);
		day.add(Calendar.DATE, lastmonth);

		GregorianCalendar[] month42 = new GregorianCalendar[42];
		for(int i = 0; i <= month42.length - 1; i++)
		{
			month42[i] = (GregorianCalendar)day.clone();
			day.add(Calendar.DATE, 1);
		}
		day.add(Calendar.DATE, -15);

		for(int i = 0; i <= month42.length - 1; i++)
		{   /*
			if(this.getDay().equals(month42[i]))
			{
				return i;
			}
            */
			if(this.getDay().get(Calendar.DATE) == month42[i].get(Calendar.DATE))
			{

			   if(this.getDay().get(Calendar.MONTH) == month42[i].get(Calendar.MONTH))
			   {
				   if(this.getDay().get(Calendar.YEAR) == month42[i].get(Calendar.YEAR))
				   {
					   return i;

				   }
			   }
		    }
		}
		return -999;
	}

	public boolean isWithinRange(GregorianCalendar calendar)
	{

		Boolean b;

		GregorianCalendar first = (GregorianCalendar)calendar.clone();
		first.set(Calendar.DAY_OF_MONTH, 1);
		int lastmonth = 1 - first.get(Calendar.DAY_OF_WEEK);
		first.add(Calendar.DATE, lastmonth);
		GregorianCalendar last = (GregorianCalendar) first.clone();

		for(int i = 0; i <= 40; i++)
		{
			last.add(Calendar.DATE, 1);
		}

		boolean firstEquals = false;
		boolean firstOver = false;
		boolean lastLess = false;
		boolean lastEquals = false;

		if(this.getDay().get(Calendar.DATE) == first.get(Calendar.DATE))
		{

		   if(this.getDay().get(Calendar.MONTH) == first.get(Calendar.MONTH))
		   {
			   if(this.getDay().get(Calendar.YEAR) == first.get(Calendar.YEAR))
			   {
				 firstEquals = true;
			   }
		   }
		}

		if(this.getDay().after(first))
		{
			firstOver = true;
		}

		if(this.getDay().before(last))
		{
			lastLess = true;
		}


		if(this.getDay().get(Calendar.DATE) == last.get(Calendar.DATE))
		{

		   if(this.getDay().get(Calendar.MONTH) == last.get(Calendar.MONTH))
		   {
			   if(this.getDay().get(Calendar.YEAR) == last.get(Calendar.YEAR))
			   {
				 lastEquals = true;
			   }
		   }
		}

		if((firstEquals || firstOver) && (lastLess || lastEquals))
		{
		   b = true;
	    }
	    else
	    {
	       b = false;
	    }
	    return b;
	}

	public Job copy()
	{
		Job job;
		GregorianCalendar date = this.day;
		String jnum = this.jobNumber;
		double h = this.hours;
		job = new Job(date, jnum, h);
		return job;
	}
}