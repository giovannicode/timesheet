import javax.swing.*;
import java.awt.*;

public class temp
{
	static CalendarPanel calendarPanel = new CalendarPanel();
	static JobAdder jobAdder = new JobAdder();
	static JFrame frame;

	public static void main (String[] args)
	{
		frame = new JFrame();
		frame.setSize(650, 700);

		calendarPanel.setup();
		calendarPanel.refresh();

		frame.add(calendarPanel);
		frame.setVisible(true);
    }
}