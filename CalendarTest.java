import java.util.GregorianCalendar;
import java.util.Calendar;

public class CalendarTest
{
	public static void main(String[]args)
	{
		GregorianCalendar greg = new GregorianCalendar();
		/*System.out.println("" + ds(greg.get(Calendar.DAY_OF_WEEK)));
		greg.add(Calendar.DATE, 1);
		System.out.println("" + ds(greg.get(Calendar.DAY_OF_WEEK)));
		greg.add(Calendar.DATE, -2);
		System.out.println("" + ds(greg.get(Calendar.DAY_OF_WEEK)));

		System.out.println(greg.get(GregorianCalendar.MONTH));*/

		/*sentence(greg);
		greg.add(Calendar.DATE,1);

		sentence(greg);
		greg.add(Calendar.DATE,1);

		sentence(greg);
		greg.add(Calendar.DATE,1);

		sentence(greg);
		greg.add(Calendar.DATE,1);

		sentence(greg);
		greg.add(Calendar.DATE,1);

		sentence(greg);
		greg.add(Calendar.DATE,1);

		sentence(greg);
		greg.add(Calendar.DATE,1);*/



		int count = 0;
		int week = 1;

		greg.set(Calendar.DAY_OF_MONTH, greg.getActualMinimum(Calendar.DAY_OF_MONTH));


		//int day = greg.get(Calendar.DAY_OF_WEEK);
		for(int  day = greg.get(Calendar.DAY_OF_MONTH);greg.get(Calendar.DAY_OF_MONTH) <= greg.getActualMaximum(Calendar.DATE); day ++)
		{


	 		if(day == greg.getActualMinimum(Calendar.DATE))
			{
			   System.out.println();
			   System.out.println();
			   System.out.println(ms(greg.get(Calendar.MONTH)) + " " + greg.get(Calendar.YEAR));
			   System.out.println("----------------------");
			   week = 1;
		    }

		    if(greg.get(Calendar.DAY_OF_MONTH) == 1)
			            {
			               if(greg.get(Calendar.DAY_OF_WEEK) > 1)
			               {
							   int lastMonth = 1 - greg.get(Calendar.DAY_OF_WEEK) ;
							   greg.add(Calendar.DATE, lastMonth);
							   while(lastMonth < 0)
							   {
								   //System.out.print("\t");
								   sentence(greg);
								   greg.add(Calendar.DATE, 1);
								   lastMonth++;
							   }
						   }
		    }

		    sentence(greg);

		                if(day == greg.getActualMaximum(Calendar.DATE))
					    {
						   int nextMonth = 7 - greg.get(Calendar.DAY_OF_WEEK);
						   int today = 1;
						   while(today <= nextMonth)
						   {
						      greg.add(Calendar.DATE, 1);
						      sentence(greg);
						      today++;
						  }
						  System.out.println();
						  week++;
						  int counter = 1;
						  if(week == 6)
						  {
						     while(counter <= 7)
						     {
						        greg.add(Calendar.DATE, 1);
						        sentence(greg);
						        counter++;
						    }
						     greg.add(Calendar.DATE, -nextMonth - 7);
						 }
						 else
						 {
							 greg.add(Calendar.DATE, -nextMonth);
						 }
						 week = 1;
						 day = 0;
			}


			greg.add(Calendar.DATE, 1);
			if(greg.get(Calendar.DAY_OF_WEEK)-1 % 7 == 0)
		    {
				System.out.println();
				week++;
			}
			count++;
			if(count == 700)
			break;

		 }
    }

	private static void sentence(GregorianCalendar greg)
	{
		System.out.print(ds(greg.get(Calendar.DAY_OF_WEEK)));
		System.out.print(" " + greg.get(Calendar.DAY_OF_MONTH) + "\t");
	}

	private static String ds(int d)
	{
		String day = "";
		switch(d)
		{
		  case 1:
		  day = "Sun";
		  break;

		  case 2:
		  day = "Mon";
		  break;

		  case 3:
		  day = "Tue";
		  break;

		  case 4:
		  day = "Wen";
		  break;

		  case 5:
		  day = "Thu";
		  break;

		  case 6:
		  day = "Fri";
		  break;

		  case 7:
		  day = "Sat";
		  break;
		}

	  return day;
    }

    private static String ms(int month)
    {
		String m = "";
		switch(month)
		{
			case 0:
			m = "Jan";
			break;

			case 1:
			m = "Feb";
			break;

			case 2:
			m = "Mar";
			break;

			case 3:
			m = "Apr";
			break;

			case 4:
			m = "May";
			break;

			case 5:
			m = "Jun";
			break;

			case 6:
			m = "Jul";
			break;

			case 7:
			m = "Aug";
			break;

			case 8:
			m = "Sep";
			break;

			case 9:
			m = "Oct";
			break;

			case 10:
			m = "Nov";
			break;

			case 11:
			m = "Dec";
			break;
		}
		return m;
	}
}