import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class arrowsPanel extends JPanel
{
	JButton btnBack;
	JButton btnFront;

	arrowsPanel()
	{
		this.load();
	}

	public void load()
	{
		btnBack = new JButton("<");
		btnFront = new JButton(">");
		this.add(btnBack);
		this.add(btnFront);
	}
}