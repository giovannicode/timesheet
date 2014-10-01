import javax.swing.*;
import java.awt.*;

public class MonthContainer extends JPanel
{
	MonthPanel monthPanel = new MonthPanel();
	WeekDaysPanel weekdaysPanel = new WeekDaysPanel();
	MonthLabel monthLabel = new MonthLabel();
	arrowsPanel arrows = new arrowsPanel();

	MonthContainer()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(arrows);
		this.add(monthLabel);
		this.add(weekdaysPanel);
		this.add(monthPanel);

	}
}