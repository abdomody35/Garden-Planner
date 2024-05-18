package test.unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.classes.Citrus;

public class CitrusTest extends Citrus
{
    
    public CitrusTest() {
        super(null);
        // nothing to do.
    }

    @Before
    public void setUp() 
    {
        this.cname = null;
    }

    @Test
    public void sePricetSetsTheGivenPrice()
    {
        this.setName("test");
        assertEquals("test", this.cname);
    }

    @Test
    public void getPriceReturnsThePrice()
    {
        this.cname = "test";
        assertEquals("test", this.getName());
    }

}