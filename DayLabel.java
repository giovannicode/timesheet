import javax.swing.*;
import java.awt.*;


public class DayLabel extends JLabel
{
	DayLabel()
	{
		this.setPreferredSize(new Dimension(75, 25));
		this.setText("Mon");
	}

	public static void main(String[]args)
	{
		JFrame frame = new JFrame();
		DayLabel label = new DayLabel();
		frame.setVisible(true);
		frame.add(label);
	}
}
