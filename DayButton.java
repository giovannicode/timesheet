import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import java.util.Calendar;


public class DayButton extends JButton
{
	private GregorianCalendar date;
	public Job[] dayJobs = new Job[4];

	DayButton()
	{
		this.setPreferredSize(new Dimension(75, 75));
		this.addActionListener(new pressListener());
	}

	public int getNumber()
	{
		int number = this.date.get(Calendar.DAY_OF_MONTH);
		return number;
	}

	public void setDate(GregorianCalendar date)
	{
		this.date = date;
	}

	public void setDayJobs(Job[] dayJobs)
	{
		this.dayJobs = dayJobs;
	}

	private class pressListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			DataTransfer.dateTransfer = DayButton.this.date;
			DataTransfer.jobsTransfer = DayButton.this.dayJobs;
			temp.calendarPanel.setVisible(false);
			temp.jobAdder.setVisible(true);
			temp.frame.add(temp.jobAdder);
			temp.jobAdder.label.setText(DataTransfer.getJobAdderLabel());
			temp.jobAdder.jobsHolder.loadLabels(DayButton.this.dayJobs);
		}
	}
}