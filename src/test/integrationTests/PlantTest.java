package test.integrationTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.classes.DayHr;
import main.classes.Plant;

public class PlantTest extends Plant 
{

    @Before
    public void setUp() {
        this.watering = new ArrayList<DayHr>();
        this.color = null;
    }

    @Test
    public void SetColorAndGetColorIntegration() {
        this.setColor("blue");
        assertEquals("blue", this.getColor());
    }

    @Test
    public void SetColorAndSetWateredIntegration() {
        this.setColor("blue");
        this.setWatered("9 am", "Wednesday", "45 min");
        assertEquals("blue", this.getColor());
        ArrayList<DayHr> watering = this.getWatered();
        assertEquals(1, watering.size());
        assertEquals("9 am", watering.get(0).getTime());
        assertEquals("Wednesday", watering.get(0).getDay());
        assertEquals("45 min", watering.get(0).getDuration());
    }

    @Test
    public void SetColorAndSetWateredDayHrIntegration() {
        this.setColor("blue");
        this.setWatered(new DayHr("9 am", "Wednesday", "45 min"));
        assertEquals("blue", this.getColor());
        ArrayList<DayHr> watering = this.getWatered();
        assertEquals(1, watering.size());
        assertEquals("9 am", watering.get(0).getTime());
        assertEquals("Wednesday", watering.get(0).getDay());
        assertEquals("45 min", watering.get(0).getDuration());
    }

    @Test
    public void SetColorAndAddWateredIntegration() {
        this.setColor("blue");
        this.addWatered("7 am", "Tuesday", "20 min");
        assertEquals("blue", this.getColor());
        ArrayList<DayHr> watering = this.getWatered();
        assertEquals(1, watering.size());
        assertEquals("7 am", watering.get(0).getTime());
        assertEquals("Tuesday", watering.get(0).getDay());
        assertEquals("20 min", watering.get(0).getDuration());
    }

    @Test
    public void SetColorAndAddWateredDayHrIntegration() {
        this.setColor("blue");
        this.addWatered(new DayHr("7 am", "Tuesday", "20 min"));
        assertEquals("blue", this.getColor());
        ArrayList<DayHr> watering = this.getWatered();
        assertEquals(1, watering.size());
        assertEquals("7 am", watering.get(0).getTime());
        assertEquals("Tuesday", watering.get(0).getDay());
        assertEquals("20 min", watering.get(0).getDuration());
    }

    @Test
    public void SetWateredAndGetWateredIntegration() {
        this.setWatered("9 am", "Wednesday", "45 min");
        ArrayList<DayHr> watering = this.getWatered();
        assertEquals(1, watering.size());
        assertEquals("9 am", watering.get(0).getTime());
        assertEquals("Wednesday", watering.get(0).getDay());
        assertEquals("45 min", watering.get(0).getDuration());
    }

    @Test
    public void SetWateredDayHrAndGetWateredIntegration() {
        this.setWatered(new DayHr("9 am", "Wednesday", "45 min"));
        ArrayList<DayHr> watering = this.getWatered();
        assertEquals(1, watering.size());
        assertEquals("9 am", watering.get(0).getTime());
        assertEquals("Wednesday", watering.get(0).getDay());
        assertEquals("45 min", watering.get(0).getDuration());
    }

    @Test
    public void AddWateredAndGetWateredIntegration() {
        this.addWatered("7 am", "Tuesday", "20 min");
        ArrayList<DayHr> watering = this.getWatered();
        assertEquals(1, watering.size());
        assertEquals("7 am", watering.get(0).getTime());
        assertEquals("Tuesday", watering.get(0).getDay());
        assertEquals("20 min", watering.get(0).getDuration());
    }

    @Test
    public void AddWateredDayHrAndGetWateredIntegration() {
        this.addWatered(new DayHr("7 am", "Tuesday", "20 min"));
        ArrayList<DayHr> watering = this.getWatered();
        assertEquals(1, watering.size());
        assertEquals("7 am", watering.get(0).getTime());
        assertEquals("Tuesday", watering.get(0).getDay());
        assertEquals("20 min", watering.get(0).getDuration());
    }
}  
