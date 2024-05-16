package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.classes.DayHr;

public class DayHrTest extends DayHr
{
    @Before
    public void setUp()
    {
        this.time = null;
        this.day = null;
        this.duration = null;
    }

    @Test
    public void getTimeReturnsTheTime()
    {
        this.time = "12:00";
        assertEquals(this.time, this.getTime());
    }

    @Test
    public void getDayReturnsTheDay()
    {
        this.day = "Monday";
        assertEquals(this.day, this.getDay());
    }

    @Test
    public void getDurationReturnsTheDuration()
    {
        this.duration = "1 hr";
        assertEquals(this.duration, this.getDuration());
    }

    @Test
    public void getReturnsDayHrStringRepresentation()
    {
        this.time = "12:00";
        this.day = "Monday";
        this.duration = "1 hr";
        assertEquals("Monday, 12:00, 1 hr", this.get());
    }
}