import javax.swing.*;
import java.awt.*;

public class JobsHolder extends JPanel
{
	/*static JobLabel job0 = new JobLabel();
	static JobLabel job1 = new JobLabel();
	static JobLabel job2 = new JobLabel();
	static JobLabel job3 = new JobLabel();*/
	static JobLabel[] jobs = new JobLabel[4];

	JobsHolder()
	{

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		for(int i = 0; i <= 3; i++)
		{
			jobs[i] = new JobLabel();
		}

		for(JobLabel jobLabel: jobs)
		{
			this.add(jobLabel);
		}
		/*this.add(job0);
		this.add(job1);
		this.add(job2);
		this.add(job3);*/
	}

	public void loadLabels(Job[] job)
	{
		for(int i = 0; i <= 3; i++)
		{
			    jobs[i].job = null;
				jobs[i].setText("");
		}
		for(int i = 0; i <= 3; i++)
		{
			if(job[i] != null)
			{
				jobs[i].job = job[i].copy();
				jobs[i].setText(job[i].toString());
			}
		}
	}
}