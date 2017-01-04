public class StringSwitchDemo
{
	public static int getWeekDayNumber(String weekday)
	{
		int dayNumber = 0;
		if (weekday == null) return dayNumber;

		switch(weekday)
		{
			case "Monday": case "monday":
				dayNumber = 1;
				break;
			case "Tuesday": case "tuesday":
				dayNumber = 2;
				break;
			default:
				dayNumber = 0;
		}

		return dayNumber;
	}

		public static void main(String[] args)
		{
			String weekday = "monday";
			int dayNumber = getWeekDayNumber(weekday);
			System.out.println(dayNumber);
		}
}

