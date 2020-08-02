public class Preference
{
	private int quietTime;
	private int music;
	private int reading;
	private int chatting;

	public Preference()
	{
		quietTime = 0;
		music = 0;
		reading = 0;
		chatting = 0;
	}

	public Preference(int qt, int mus, int read, int chat)
	{
		this.quietTime = qt;
		this.music = mus;
		this.reading = read;
		this.chatting = chat;
	}

	public int getQuietTime()
	{
		return quietTime;
	}

	public void setQuietTime(int quietTime)
	{
		this.quietTime = quietTime;
	}

	public int getMusic()
	{
		return music;
	}

	public void setMusic(int music)
	{
		this.music = music;
	}

	public int getReading()
	{
		return reading;
	}

	public void setReading(int reading)
	{
		this.reading = reading;
	}

	public int getChatting()
	{
		return chatting;
	}

	public void setChatting(int chatting)
	{
		this.chatting = chatting;
	}

	public int prefScore() {
		return this.quietTime + this.music + this.chatting + this.reading;
	}
	
	// need to fill up
	public int compare(Preference pref)
	{
		int myPrefScore = this.prefScore();
		int otherPrefScore = pref.prefScore();

		return Math.abs(myPrefScore - otherPrefScore);
	}

}
