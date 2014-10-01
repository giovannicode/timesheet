import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JobLabel extends JPanel
{
	JLabel jobinfo;
	JButton btnDelete;
	Job job;

	JobLabel()
	{
		this.jobinfo = new JLabel();
		this.btnDelete = new JButton("Delete");

		this.add(jobinfo);
		this.add(btnDelete);

		this.btnDelete.addActionListener(new deleteListener());
	}

	public void setText(String text)
	{
		this.jobinfo.setText(text);
	}

	private class deleteListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String jobNumber = JobLabel.this.job.getJobNumber();
			JobList joblist = JobList.getJobInfo();

			int i = 0;
			int index = -999;
			for(Object job: joblist)
			{

				Job j = (Job) job;
				if(j.getJobNumber().equals(jobNumber))
				{
				   index = i;
			    }
			    i++;
			}

			JobList.deleteAndSave(index);
		}
	}
}