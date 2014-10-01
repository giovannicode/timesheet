import javax.swing.*;
import java.awt.*;

public class LabelTextbox extends JPanel
{
	JLabel label;
	JTextField textbox = new JTextField(8);

	LabelTextbox()
	{
	}

	LabelTextbox(String labelText)
	{
		this.setPreferredSize(new Dimension(300, 25));
		this.label = new JLabel(labelText);
		this.add(label);
		this.add(textbox);
	}

	public String getText()
	{
		String text = this.textbox.getText();
		return text;
	}

	public void setText(String text)
	{
	   this.textbox.setText(text);
   }

}