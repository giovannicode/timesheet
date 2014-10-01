import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class GuiCalendarTest2
{

	static JFrame frame;
    static MonthContainer monthContainer = new MonthContainer();
	static GregorianCalendar greg = new GregorianCalendar();;




	        /*JComponent holder = (JComponent)monthContainer.getComponent(1);
	        JLabel hold = (JLabel)holder.getComponent(0);
	        hold.setText("sunday");*/

	static JComponent month = (JComponent)monthContainer.getComponent(3);

	static JComponent btnHolder = (JComponent)monthContainer.getComponent(0);
	static JButton forw = (JButton)btnHolder.getComponent(1);

	static JComponent btnHolder2 = (JComponent)monthContainer.getComponent(0);
	static JButton prev = (JButton)btnHolder2.getComponent(0);

	static JComponent week;
	static JButton day;
    static int dia = 1;

    static int one = 0;
    static int lastd;
    static int count = 1;

    static String monthLabel;
    static int yearLabel;
    static JLabel mlHolder;

    static Color green = new Color(0, 150, 0);

	public static void main (String[]args)
	{

		frame = new JFrame("Calendar Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	    frame.setSize(750, 700);

        dia = 1;
        count = 1;

        forw.addActionListener(new frontListener());
        prev.addActionListener(new backListener());

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
					   day = (JButton)week.getComponent(d -1);
					   day.setForeground(Color.red);
					   day.setText("" + greg.get(Calendar.DAY_OF_MONTH));
					   greg.add(Calendar.DATE, 1);
					   lastMonth++;
				    }
			     }
				 for(int d = greg.get(Calendar.DAY_OF_WEEK) - 1; d < 7; d++)
				 {

				   week = (JComponent)month.getComponent(w);
				   day = (JButton)week.getComponent(d);
				   day.setText("" + dia);
				   dia++;
				 }
			}
		    else
			{
			   for(int d = 0; d < 7 && dia <= greg.getActualMaximum(Calendar.DATE); d++)
			   {

			     week = (JComponent)month.getComponent(w);
			     day = (JButton)week.getComponent(d);
		         day.setText("" + dia);
		         dia++;
		         lastd = d;
			   }
			   if(dia > greg.getActualMaximum(Calendar.DATE))
			   {
			      lastd++;
				  while(lastd < 7)
				  {
				     week = (JComponent)month.getComponent(w);
			         day = (JButton)week.getComponent(lastd);
					 day.setForeground(Color.green);
					 day.setText("" + count);
					 count++;
					 lastd++;
				  }
				  lastd = -1;
			   }

			}

		 }
		frame.add(monthContainer);
		frame.setVisible(true);
	}

	public static void refresh()
	{

	    greg.add(Calendar.MONTH, one);

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
					 day = (JButton)week.getComponent(d -1);
					 day.setForeground(Color.red);
					 day.setText("" + greg.get(Calendar.DAY_OF_MONTH));
					 greg.add(Calendar.DATE, 1);
					 lastMonth++;
				   }
			   }
			   for(int d = greg.get(Calendar.DAY_OF_WEEK) - 1; d < 7; d++)
			   {

				  week = (JComponent)month.getComponent(w);
				  day = (JButton)week.getComponent(d);
				  day.setForeground(Color.black);
				  day.setText("" + dia);
				  dia++;
			   }
			}
			   else
			   {
				  for(int d = 0; d < 7 && dia <= greg.getActualMaximum(Calendar.DATE); d++)
				  {

					 week = (JComponent)month.getComponent(w);
					 day = (JButton)week.getComponent(d);
					 day.setForeground(Color.black);
					 day.setText("" + dia);
					 dia++;
					 lastd = d;
				  }
				  if(dia > greg.getActualMaximum(Calendar.DATE))
				  {
					  lastd++;
					  while(lastd < 7)
					  {
						 week = (JComponent)month.getComponent(w);
						 day = (JButton)week.getComponent(lastd);
						 day.setForeground(green);
						 day.setText("" + count);
						 count++;
						 lastd++;
					  }
					  lastd = -1;
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