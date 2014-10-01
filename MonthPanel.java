import javax.swing.*;
import java.awt.*;

public class MonthPanel extends JPanel
{
	WeekPanel[] weeks = new WeekPanel[6];

	MonthPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		for(int count = 0; count < 6; count++)
		{
			weeks[count] = new WeekPanel();
		}
		for(WeekPanel week : weeks)
		   this.add(week);

	}
}