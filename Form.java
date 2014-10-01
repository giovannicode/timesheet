import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Form extends JPanel
{
	LabelTextbox jobnumber = new LabelTextbox("Job Number: ");
	LabelTextbox hours = new LabelTextbox("Number of Hours: ");

	JPanel buttonsPanel = new JPanel();
	JButton btnEnter = new JButton("Enter");
	JButton btnClear = new JButton("Clear");

	Form()
	{
		this.setPreferredSize(new Dimension(310, 40));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(jobnumber);
		this.add(hours);
		this.buttonsPanel.add(btnEnter);
		this.buttonsPanel.add(btnClear);
		this.add(buttonsPanel);

		btnEnter.addActionListener(new enterListener());
		btnClear.addActionListener(new clearListener());
	}

	private class enterListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		   JobList joblist  = JobList.getJobInfo();

		   GregorianCalendar day = DataTransfer.dateTransfer;
		   String jobNum = jobnumber.getText();
		   double hourNum = Double.parseDouble(hours.getText());

		   Job job = new Job(day, jobNum, hourNum);
		   JobList.saveJobInfo(job);
		}
	}

	private class clearListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			jobnumber.setText("");
			hours.setText("");
		}
    }
}