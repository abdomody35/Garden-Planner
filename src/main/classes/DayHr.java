package main.classes;

public class DayHr
{
    private String time, day, duration;

    public DayHr()
    {
        this.time = "10 AM";
        this.day = "Monday";
        this.duration = "1 hr";
    }

    public DayHr(String time, String day, String duration)
    {
        this.time = time;
        this.day = day;
        this.duration = duration;
    }
    
    public String getTime()
    {
        return this.time;
    }

    public String getDay()
    {
        return this.day;
    }

    public String getDuration()
    {
        return this.duration;
    }

    public String get()
    {
        return this.day + ", " + this.time + ", " + this.duration;
    }
}