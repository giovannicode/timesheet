
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class GUICalendarTest3
{

	static JFrame frame;
    static MonthContainer monthContainer;
	static GregorianCalendar greg;

	        /*JComponent holder = (JComponent)monthContainer.getComponent(1);
	        JLabel hold = (JLabel)holder.getComponent(0);
	        hold.setText("sunday");*/

	static JComponent month;

	static JComponent week;
	static JButton day;
    static int dia = 1;
    static JButton forw;
    static JButton prev;
    static int one = 0;
    static int lastd;
    static int count = 1;

	public static void main (String[]args)
	{

		frame = new JFrame("Calendar Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(750, 700);

	    monthContainer = new MonthContainer();
	    month = (JComponent)monthContainer.getComponent(3);
	    greg = new GregorianCalendar();


        dia = 1;

        JComponent btnHolder = (JComponent)monthContainer.getComponent(0);
        forw = (JButton)btnHolder.getComponent(1);
        forw.addActionListener(new frontListener());

        JComponent btnHolder2 = (JComponent)monthContainer.getComponent(0);
		prev = (JButton)btnHolder2.getComponent(0);
        prev.addActionListener(new backListener());

        String monthLabel = CalendarStrings.months(greg.get(Calendar.MONTH));
        int yearLabel = greg.get(Calendar.YEAR);
        JLabel mlHolder = (JLabel)monthContainer.getComponent(1);
        mlHolder.setText(monthLabel + "  " + yearLabel);


        greg.set(Calendar.DAY_OF_MONTH, greg.getActualMinimum(Calendar.DAY_OF_MONTH));

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
				      day.setForeground(Color.gray);
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
			   for(int d = 0; d < 7 && dia <= greg.getActualMaximum(Calendar.DAY_OF_MONTH); d++)
			   {

				  week = (JComponent)month.getComponent(w);
				  day = (JButton)week.getComponent(d);
			      day.setText("" + dia);
				  dia++;
		       }
		   }
		}

        frame.add(monthContainer);

		frame.setVisible(true);
	}

	public static void refresh()
	{
	    monthContainer = new MonthContainer();
	    month = (JComponent)monthContainer.getComponent(3);
	    greg.add(Calendar.MONTH, one);

        dia = 1;
        count = 1;

        JComponent btnHolder = (JComponent)monthContainer.getComponent(0);
        forw = (JButton)btnHolder.getComponent(1);
        forw.addActionListener(new frontListener());

        JComponent btnHolder2 = (JComponent)monthContainer.getComponent(0);
		prev = (JButton)btnHolder2.getComponent(0);
        prev.addActionListener(new backListener());

        String monthLabel = CalendarStrings.months(greg.get(Calendar.MONTH));
        int yearLabel = greg.get(Calendar.YEAR);
        JLabel mlHolder = (JLabel)monthContainer.getComponent(1);
        mlHolder.setText(monthLabel + "  " + yearLabel);


        greg.set(Calendar.DAY_OF_MONTH, greg.getActualMinimum(Calendar.DAY_OF_MONTH));

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
							 day.setForeground(Color.gray);
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