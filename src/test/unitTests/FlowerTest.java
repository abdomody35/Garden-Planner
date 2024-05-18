package test.unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.classes.Flower;
import main.enums.Intensity;

public class FlowerTest extends Flower
{
    public FlowerTest() {
        super(null, null);
        // Nothing to do.
    }
    
    @Before
    public void setUp() 
    {
        this.name = null;
        this.smell = null;
    }

    @Test
    public void setNameSetsTheGivenName()
    {
        this.setName("test");
        assertEquals("test", this.name);
    }

    @Test
    public void getNameReturnsTheName()
    {
        this.name = "test";
        assertEquals("test", this.getName());
    }

    @Test
    public void setIntensitySetsTheGivenSmell()
    {
        this.setIntensity("veryStrong");
        assertEquals(Intensity.valueOf("veryStrong"), this.smell);
    }

    @Test
    public void getIntensityReturnsTheSmell()
    {
        this.smell = Intensity.veryStrong;
        assertEquals(this.smell, Intensity.valueOf(this.getIntensity()));
    }
}