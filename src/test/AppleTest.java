package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.classes.Apple;

public class AppleTest extends Apple
{
    
    public AppleTest() {
        super(null);
        // nothing to do.
    }

    @Before
    public void setUp() 
    {
        this.aname = null;
    }

    @Test
    public void sePricetSetsTheGivenPrice()
    {
        this.setName("test");
        assertEquals("test", this.aname);
    }

    @Test
    public void getPriceReturnsThePrice()
    {
        this.aname = "test";
        assertEquals("test", this.getName());
    }

}