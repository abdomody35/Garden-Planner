package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.classes.Tomato;

public class TomatoTest extends Tomato
{
    
    public TomatoTest() {
        super(null);
        // nothing to do.
    }

    @Before
    public void setUp() 
    {
        this.kind = null;
    }

    @Test
    public void sePricetSetsTheGivenPrice()
    {
        this.setKind("test");
        assertEquals("test", this.kind);
    }

    @Test
    public void getPriceReturnsThePrice()
    {
        this.kind = "test";
        assertEquals("test", this.getKind());
    }

}