package main.classes;

import java.util.ArrayList;

public abstract class Plant 
{
    protected String color;
    protected ArrayList<DayHr> watering = new ArrayList<DayHr>();

    public String getColor() 
    {
        return this.color;
    }
    
    public void setColor(String color) 
    {
        this.color = color;
    }

    public void setWatered(DayHr schedule)
    {
        watering = new ArrayList<DayHr>();
        this.addWatered(schedule);
    }

    public void setWatered(String time, String day, String duration)
    {
        watering = new ArrayList<DayHr>();
        this.addWatered(time, day, duration);
    }

    public void addWatered(DayHr schedule)
    {
        if (schedule == null)
        {
            schedule = new DayHr();
        }
        watering.add(schedule);
    }

    public void addWatered(String time , String day, String duration)
    {
        if (time == null || time.length() <= 0)
        {
            time = "10 AM";
        }
        if (day == null || day.length() <= 0)
        {
            day = "Monday";
        }
        if (duration == null || duration.length() <= 0)
        {
            duration = "1 hr";
        }
        watering.add(new DayHr(time, day, duration));
    }

    public ArrayList<DayHr> getWatered() 
    {
        if (watering.size() == 0)
        {
            ArrayList<DayHr> temp = new ArrayList<DayHr>();
            temp.add(new DayHr());
            return temp;
        }
        return watering;
    }
}