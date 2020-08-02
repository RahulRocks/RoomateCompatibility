public class Date
{
	private int year;
	private int month;
	private int day;

	public Date()
	{
		this.year = 0;
		this.month = 0;
		this.day = 0;
	}

	public Date(int m, int d, int y)
	{
		this.year = y;
		this.month = m;
		this.day = d;
	}
	
	public int dayOfYear() 
	{
        int totalDays = 0;
        switch (month) 
        {
           case 12: totalDays += 30;
           case 11: totalDays += 31;
           case 10: totalDays += 30;
           case 9 : totalDays += 31;
           case 8 : totalDays += 31;
           case 7 : totalDays += 30;
           case 6 : totalDays += 31;
           case 5 : totalDays += 30;
           case 4 : totalDays += 31;
           case 3 : totalDays += 28;
           case 2 : totalDays += 31;
        }
        totalDays += day;
        return totalDays;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public int getMonth()
	{
		return month;
	}

	public void setMonth(int month)
	{
		this.month = month;
	}

	public int getDay()
	{
		return day;
	}

	public void setDay(int day)
	{
		this.day = day;
	}

	public int compare(Date dt)
	{
		int yearsDifferenceInDays = Math.abs(this.year - dt.getYear()) * 365;
		int daysDifference = Math.abs(this.dayOfYear() - dt.dayOfYear());
		int totalDifferenceInMonths = (yearsDifferenceInDays + daysDifference) / 30;
		return (totalDifferenceInMonths > 60) ? 60 : totalDifferenceInMonths;
	}
	
}
