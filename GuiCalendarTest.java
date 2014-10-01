import javax.swing.*;
import java.awt.*;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class GuiCalendarTest
{

	public static void main (String[]args)
	{
		JFrame frame = new JFrame("Calendar Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 700);

        MonthContainer monthContainer = new MonthContainer();

        GregorianCalendar greg = new GregorianCalendar();

        //JPanel panel = new JPanel();
        /*MonthTest month = new MonthTest();



        JButton button = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");


        button.setPreferredSize(new Dimension(100, 100));
        button2.setPreferredSize(new Dimension(100, 100));
        button3.setPreferredSize(new Dimension(100, 100));
        button4.setPreferredSize(new Dimension(100, 100));
        button5.setPreferredSize(new Dimension(100, 100));
        button6.setPreferredSize(new Dimension(100, 100));
        button7.setPreferredSize(new Dimension(100, 100));

        panel.add(button);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);

        WeekPanel panell = new WeekPanel();
        WeekPanel panel2 = new WeekPanel();
        WeekPanel panel3 = new WeekPanel();
        WeekPanel panel4 = new WeekPanel();
        WeekPanel panel5 = new WeekPanel();
        WeekPanel panel6 = new WeekPanel();
        WeekPanel panel7 = new WeekPanel();




        month.setLayout(new BoxLayout (month, BoxLayout.Y_AXIS));

        month.add(panell);
        month.add(panel2);
        month.add(panel3);
        month.add(panel4);
        month.add(panel5);
        month.add(panel6);

        WeekPanel test = (WeekPanel)month.getComponent(1);

        month.add(test);*/

        /*MonthPanel jan = new MonthPanel();
        WeekDaysPanel week = new WeekDaysPanel();
        MonthLabel label = new MonthLabel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(label);
        panel.add(week);
        panel.add(jan);*/

        //panel.add(jan);
        JComponent holder = (JComponent)monthContainer.getComponent(1);
        JLabel hold = (JLabel)holder.getComponent(0);
        hold.setText("sunday");

        JComponent month = (JComponent)monthContainer.getComponent(2);

        JComponent week;
        JButton day;
        int count = 1;

        for(int w = 0; w < 6; w++)
        {
			for(int d = 0; d < 7; d++)
			{
			   week = (JComponent)month.getComponent(w);
			   day = (JButton)week.getComponent(d);
			   day.setText("" + count);
			   count++;
		   }
		}

        		/*int count = 0;

				greg.set(Calendar.DAY_OF_MONTH, greg.getActualMinimum(Calendar.DAY_OF_MONTH));


				//int day = greg.get(Calendar.DAY_OF_WEEK);
				for(int  day = greg.get(Calendar.DAY_OF_MONTH);greg.get(Calendar.DAY_OF_MONTH) <= greg.getActualMaximum(Calendar.DATE); day ++)
				{




		            if(day == greg.getActualMaximum(Calendar.DATE))
							    {
									day = 0;
					}

			 		if(day == greg.getActualMinimum(Calendar.DATE))
					{
					   System.out.println();
					   System.out.println();
					   System.out.println(ms(greg.get(Calendar.MONTH)) + " " + greg.get(Calendar.YEAR));
					   System.out.println("----------------------");
				    }

				    if(greg.get(Calendar.DAY_OF_MONTH) == 1)
					            {
					               if(greg.get(Calendar.DAY_OF_WEEK) > 1)
					               {
									   for(int t = 1; t < greg.get(Calendar.DAY_OF_WEEK); t++)
									   {
										   System.out.print("\t");
									   }
								   }
				    }

				    sentence(greg);


					greg.add(Calendar.DATE, 1);
					if(greg.get(Calendar.DAY_OF_WEEK)-1 % 7 == 0)
				    {
						System.out.println();
					}
					count++;
					if(count == 365)
					break;

				 }*/

        frame.add(monthContainer);


		frame.setVisible(true);


	}
}