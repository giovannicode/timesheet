import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class WeekPanel extends JPanel
{
   DayButton[] days = new DayButton[7];


   WeekPanel()
   {
	   this.setPreferredSize(new Dimension(565,85));
	   for(int count = 0; count < 7; count++)
	   {
		   days[count] = new DayButton();
	   }
	   for(DayButton day : days)
	      this.add(day);
	   //load();

   }

  /* private void load()
   {
	   b1.setPreferredSize(new Dimension(100, 100));
	           b2.setPreferredSize(new Dimension(100, 100));
	           b3.setPreferredSize(new Dimension(100, 100));
	           b4.setPreferredSize(new Dimension(100, 100));
	           b5.setPreferredSize(new Dimension(100, 100));
	           b6.setPreferredSize(new Dimension(100, 100));
        b7.setPreferredSize(new Dimension(100, 100));
	   this.add(b1);
	   this.add(b2);
	   this.add(b3);
	   this.add(b4);
	   this.add(b5);
	   this.add(b6);
	   this.add(b7);

   }*/
}