public class CalendarStrings
{
	CalendarStrings()
	{
	}

		public static String weekdays(int d)
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

    public static String months(int month)
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