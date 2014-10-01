import javax.swing.*;
import java.awt.*;

public class WeekDaysPanel extends JPanel
{
	DayLabel[] days = new DayLabel[7];

	WeekDaysPanel()
	{
		this.load();
	}

	private void load()
	{
		for(int count = 0; count < 7; count++)
		{
			days[count] = new DayLabel();
			days[count].setText(CalendarStrings.weekdays(count+1));
			days[count].setHorizontalAlignment(SwingConstants.CENTER);
		}


		for(DayLabel day: days)
			this.add(day);
   }


	public static void main(String[]args)
	{

	}
}