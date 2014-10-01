import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JobAdder extends JPanel
{
	static JLabel label = new JLabel();
	static JobsHolder jobsHolder = new JobsHolder();
	Form form = new Form();
	JButton btnBack = new JButton("back");

	public JobAdder()
	{
	    this.add(label);

	    this.add(jobsHolder);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(form);

		btnBack.addActionListener(new backListener());
		this.add(btnBack);
	}

	private class backListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			   temp.frame.remove(temp.jobAdder);
			   temp.calendarPanel.setVisible(true);
			   CalendarPanel.loadBlues(CalendarPanel.greg);
			   CalendarPanel.loadJobs(CalendarPanel.greg);
			   CalendarPanel.loadHours(CalendarPanel.greg);
	    }
	}
}