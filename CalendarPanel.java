import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class CalendarPanel extends JPanel
{
	static GregorianCalendar greg = new GregorianCalendar();
    static MonthContainer monthContainer = new MonthContainer();

	static JComponent btnHolder = (JComponent)monthContainer.getComponent(0);
	static JButton forw = (JButton)btnHolder.getComponent(1);
	static JComponent btnHolder2 = (JComponent)monthContainer.getComponent(0);
	static JButton prev = (JButton)btnHolder2.getComponent(0);

	static String monthLabel;
    static int yearLabel;
    static JLabel mlHolder;

	static JComponent month = (JComponent)monthContainer.getComponent(3);

	static JComponent week;
	static DayButton day = new DayButton();
    static int dia;
    static int count;
    static int lastd;

    static int one = 0;
    static Color green = new Color(0, 150, 0);
    static Color blue = new Color(0, 0, 255);

    static Color original = day.getBackground();

    public void setup()
    {
		this.setSize(650,700);
		this.add(monthContainer);
		forw.addActionListener(new frontListener());
        prev.addActionListener(new backListener());
	}

	public static void refresh()
	{
	    greg.add(Calendar.MONTH, one);

	    int maxdays = greg.getActualMaximum(Calendar.DATE);

        dia = 1;
        count = 1;

        monthLabel = CalendarStrings.months(greg.get(Calendar.MONTH));
        yearLabel = greg.get(Calendar.YEAR);
        mlHolder = (JLabel)monthContainer.getComponent(1);
        mlHolder.setText(monthLabel + "  " + yearLabel);


        greg.set(Calendar.DAY_OF_MONTH, 1);

		for(int w = 0; w < 6; w++)
		{
			if(w == 0)
			{
			   if(greg.get(Calendar.DAY_OF_WEEK) > 1)
			   {
				  int lastMonth = 1 - greg.get(Calendar.DAY_OF_WEEK);
				  greg.add(Calendar.DATE, lastMonth);
				  for(int d = 1; lastMonth < 0; d++)
				  {
					 week = (JComponent)month.getComponent(w);
					 day = (DayButton)week.getComponent(d -1);
					 day.setForeground(Color.red);
					 day.setText("" + greg.get(Calendar.DAY_OF_MONTH));
					 day.setDate(new GregorianCalendar(greg.get(Calendar.YEAR), greg.get(Calendar.MONTH), greg.get(Calendar.DAY_OF_MONTH)));
					 greg.add(Calendar.DATE, 1);
					 lastMonth++;
				   }
			   }
			   for(int d = greg.get(Calendar.DAY_OF_WEEK) - 1; d < 7; d++)
			   {

				  week = (JComponent)month.getComponent(w);
				  day = (DayButton)week.getComponent(d);
				  day.setForeground(Color.black);
				  day.setText("" + dia);
				  day.setDate(new GregorianCalendar(greg.get(Calendar.YEAR), greg.get(Calendar.MONTH), greg.get(Calendar.DAY_OF_MONTH)));
				  greg.add(Calendar.DATE, 1);
				  dia++;
			   }
			}
			   else
			   {
				  for(int d = 0; d < 7 && dia <= maxdays; d++)
				  {
					 week = (JComponent)month.getComponent(w);
					 day = (DayButton)week.getComponent(d);
					 day.setForeground(Color.black);
					 day.setText("" + dia);
					 day.setDate(new GregorianCalendar(greg.get(Calendar.YEAR), greg.get(Calendar.MONTH), greg.get(Calendar.DAY_OF_MONTH)));
					 greg.add(Calendar.DATE, 1);
					 dia++;
					 lastd = d;
				  }
				  if(dia > maxdays)
				  {
					  lastd++;
					  while(lastd < 7)
					  {
						 week = (JComponent)month.getComponent(w);
						 day = (DayButton)week.getComponent(lastd);
						 day.setForeground(green);
						 day.setText("" + count);
						 day.setDate(new GregorianCalendar(greg.get(Calendar.YEAR), greg.get(Calendar.MONTH), greg.get(Calendar.DAY_OF_MONTH)));
						 greg.add(Calendar.DATE, 1);
						 count++;
						 lastd++;
					  }
					  lastd = -1;
				  }

			  }

		   }
	   greg.add(Calendar.MONTH, -1);
	   loadBlues(greg);
	   loadJobs(greg);
	   loadHours(greg);
	}

	public static void loadBlues(GregorianCalendar calendar)
	{
		for(int w = 0;  w <6; w++)
		{
			for(int d = 0; d < 7; d++)
			{
				 week = (JComponent)month.getComponent(w);
				 day = (DayButton)week.getComponent(d);
				 day.setBackground(original);
			}
        }
		boolean[] blues = getBlues(calendar);
		int i = 0;
		for(int w = 0;  w <6; w++)
		{
			for(int d = 0; d < 7; d++)
			{
				 week = (JComponent)month.getComponent(w);
				 day = (DayButton)week.getComponent(d);
				 if(blues[i] == true)
				 {
					 day.setBackground(blue);
				 }
				 i++;
			}
		}
	}

	public static boolean[] getBlues(GregorianCalendar calendar)
	{
		boolean[] jobs = new boolean[42];
		JobList joblist = JobList.getJobInfo();
		JobList newlist = joblist.fitInMonth(calendar);

		for(Object job: newlist)
		{
			Job j = (Job)job;
			int i = j.getIndex(calendar);
			jobs[i] = true;
		}
		return jobs;
	}

	public static void loadJobs(GregorianCalendar calendar)
	{
		for(int w = 0;  w <6; w++)
		{
			for(int d = 0; d < 7; d++)
			{
				 week = (JComponent)month.getComponent(w);
				 day = (DayButton)week.getComponent(d);
				 Job[] dayJobs = new Job[4];
				 day.setDayJobs(dayJobs);
			}
		}

		Job[][] allJobs = getJobs(calendar);
		int i = 0;

		for(int w = 0;  w <6; w++)
		{
			for(int d = 0; d < 7; d++)
			{
				 week = (JComponent)month.getComponent(w);
				 day = (DayButton)week.getComponent(d);
				 day.setDayJobs(allJobs[i]);
				 i++;
			}
		}
	}

	public static Job[][] getJobs(GregorianCalendar calendar)
	{
		Job[][] allJobs = new Job[42][4];
		JobList joblist = JobList.getJobInfo();
		JobList newlist = joblist.fitInMonth(calendar);

		for(Object job: newlist)
		{
			Job j = (Job)job;
			int i = j.getIndex(calendar);
            int k = 0;
			while(allJobs[i][k] != null )
			{
				k++;
			}
			allJobs[i][k] = j;
		}
		return allJobs;

	}

	public static void loadHours(GregorianCalendar calendar)
	{
		for(int w = 0;  w <6; w++)
		{
			double totalHours = 0;
			for(int d = 0; d < 7; d++)
			{
				 week = (JComponent)month.getComponent(w);
				 day = (DayButton)week.getComponent(d);
				 for(int i = 0; i <= 3; i++)
				 {
				    if(day.dayJobs[i] != null)
				    {
                       totalHours += day.dayJobs[i].getHours();
				    }
				 }
                 if(d == 6)
                 {
					 int number = day.getNumber();
					 String check = Job.getCheckTotal(totalHours);
					 day.setText("<html><body>" + number + "<br>" + totalHours + "<br>" + check + "</body></html>");
				 }
			}
		}
	}

	private static class backListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			one = -1;
			refresh();
		}
	}

	private static class frontListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			one = 1;
			refresh();
		}
	}
}