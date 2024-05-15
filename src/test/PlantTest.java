package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.classes.DayHr;
import main.classes.Plant;

public class PlantTest extends Plant{

    @Before
    public void setUp()
    {
        this.watering = new ArrayList<DayHr>();
        this.color = null;
    }

    @Test
    public void setColorSetsTheGivenColor() 
    {
        this.setColor("red");
        assertEquals("red", this.color);
    }

    @Test
    public void setColorSetsTheColorToNullWhenGivenNull() 
    {
        this.setColor(null);
        assertNull(this.color);
    }

    @Test
    public void getColorReturnsTheColor() 
    {
        this.color = "red";
        assertEquals("red", this.getColor());
        this.color = null;
        assertNull(this.getColor());
    }

    @Test
    public void getColorReturnsNullWhenTheColorIsNull() 
    {
        this.color = "red";
        assertEquals("red", this.getColor());
        this.color = null;
        assertNull(this.getColor());
    }

    @Test
    public void setWateredSetsTheListToTheGivenWatering()
    {
        this.setWatered("1 pm", "Tue",  "30 min");
        assertEquals("1 pm", this.watering.get(0).getTime());
        assertEquals("Tue", this.watering.get(0).getDay());
        assertEquals("30 min", this.watering.get(0).getDuration());
    }

    @Test
    public void setWateredSetsTheListToTheDefaultWateringWhenGivenNull()
    {
        this.setWatered(null, null, null);
        assertEquals("10 AM", this.watering.get(0).getTime());
        assertEquals("Monday", this.watering.get(0).getDay());
        assertEquals("1 hr", this.watering.get(0).getDuration());
    }

    @Test
    public void setWateredDeletesPreviousWaterings()
    {
        this.watering = new ArrayList<DayHr>();
        this.watering.add(new DayHr(null, null,  null));
        this.setWatered(null, null, null);
        assertEquals(1, this.watering.size());
    }

    @Test
    public void setWateredDayHrSetsTheListToTheGivenWatering()
    {
        this.setWatered(new DayHr("1 pm", "Tue",  "30 min"));
        assertEquals("1 pm", this.watering.get(0).getTime());
        assertEquals("Tue", this.watering.get(0).getDay());
        assertEquals("30 min", this.watering.get(0).getDuration());
    }

    @Test
    public void setWateredDayHrSetsTheListToTheDefaultWateringWhenGivenNull()
    {
        this.setWatered(null);
        assertEquals("10 AM", this.watering.get(0).getTime());
        assertEquals("Monday", this.watering.get(0).getDay());
        assertEquals("1 hr", this.watering.get(0).getDuration());
    }

    @Test
    public void setWateredDayHrDeletesPreviousWaterings()
    {
        this.watering = new ArrayList<DayHr>();
        this.watering.add(new DayHr(null, null, null));
        this.setWatered(new DayHr(null, null, null));
        assertEquals(1, this.watering.size());
    }

    @Test
    public void addWateredAddsTheGivenWatering()
    {
        this.setWatered("1 pm", "Tue",  "30 min");
        assertEquals("1 pm", this.watering.get(0).getTime());
        assertEquals("Tue", this.watering.get(0).getDay());
        assertEquals("30 min", this.watering.get(0).getDuration());
    }

    @Test
    public void addWateredAddsTheDefaultWateringWhenGivenNull()
    {
        this.setWatered(null, null, null);
        assertEquals("10 AM", this.watering.get(0).getTime());
        assertEquals("Monday", this.watering.get(0).getDay());
        assertEquals("1 hr", this.watering.get(0).getDuration());
    }

    @Test
    public void addWateredDoesNotDeletePreviousWaterings()
    {
        this.watering = new ArrayList<DayHr>();
        this.watering.add(new DayHr(null, null,  null));
        this.setWatered(null, null, null);
        assertEquals(1, this.watering.size());
    }

    @Test
    public void addWateredDayHrAddsTheGivenWatering()
    {
        this.setWatered(new DayHr("1 pm", "Tue",  "30 min"));
        assertEquals("1 pm", this.watering.get(0).getTime());
        assertEquals("Tue", this.watering.get(0).getDay());
        assertEquals("30 min", this.watering.get(0).getDuration());
    }

    @Test
    public void addWateredDayHrAddsTheDefaultWateringWhenGivenNull()
    {
        this.setWatered(null);
        assertEquals("10 AM", this.watering.get(0).getTime());
        assertEquals("Monday", this.watering.get(0).getDay());
        assertEquals("1 hr", this.watering.get(0).getDuration());
    }

    @Test
    public void addWateredDayHrDoesNotDeletePreviousWaterings()
    {
        this.watering = new ArrayList<DayHr>();
        this.watering.add(new DayHr(null, null, null));
        this.setWatered(new DayHr(null, null, null));
        assertEquals(1, this.watering.size());
    }

    @Test
    public void getWateredReturnsTheDefaultWateringWhenWateringIsNull()
    {
        var test = new ArrayList<DayHr>();
        test.add(new DayHr("10 AM", "Monday", "1 hr"));
        assertEquals(0, this.watering.size());
        assertEquals(test.size(), this.getWatered().size());
        assertEquals(test.get(0).get(), this.getWatered().get(0).get());
    }

    @Test
    public void getWateredReturnsTheWateringList()
    {
        this.watering = new ArrayList<DayHr>();
        this.watering.add(new DayHr("10 AM", "Monday", "1 hr"));
        assertTrue(this.watering.equals(this.getWatered()));        
    }

}
