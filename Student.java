public class Student
{
	private String name;
	private char gender;
	private boolean matched;
	private Date birthdate = new Date();
	private Preference pref = new Preference();

	/*
	 * public Student() { this.name = null; this.gender = '\0'; this.matched =
	 * false; this.birthdate = null; this.pref = null; }
	 */
	public Student(String n, char g, boolean m, Preference p, Date bd)
	{
		this.name = n;
		this.gender = g;
		this.matched = m;
		this.birthdate = bd;
		this.pref = p;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public char getGender()
	{
		return this.gender;
	}

	public void setGender(char gender)
	{
		this.gender = gender;
	}

	public boolean isMatched()
	{
		return this.matched;
	}

	public void setMatched(boolean matched)
	{
		this.matched = matched;
	}

	public Date getBirthdate()
	{
		return this.birthdate;
	}

	public void setBirtdate(Date birtdate)
	{
		this.birthdate = birtdate;
	}

	public Preference getPref()
	{
		return this.pref;
	}

	public void setPref(Preference pref)
	{
		this.pref = pref;
	}

	public int compare(Student st)
	{
		/*
		 * Highest score is 100 and lowest is 0 
		 * • Different genders get a score 0 (only match same gender students as roommates) 
		 * • The formula for computing the compatibility score is: (40 – Preferences) + (60 – AgeDifference), where 
		 * 		o Preferences is the absolute differences in each of the 4 activities added together 
		 * 		o AgeDifference is the number of months between two birthdates with the maximum being 5 years (60 months)
		 * 
		 */
		int score = 0;
		if (this.gender != st.getGender())
		{
			return score;
		}

		int prefCompatibility = Math.abs(this.getPref().prefScore() - st.getPref().prefScore());
		int ageCompatibility = Math.abs(this.birthdate.compare(st.getBirthdate()));
		
		score =  (40 - prefCompatibility) + (60 - ageCompatibility);
		return score;
	}

}
