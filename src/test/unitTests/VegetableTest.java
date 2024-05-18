package test.unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.classes.Vegetable;

public class VegetableTest extends Vegetable
{
    
    @Before
    public void setUp() 
    {
        this.Weight = 0;
    }

    @Test
    public void setWeightSetsTheGivenWeight()
    {
        this.setWeight(10);
        assertEquals(10, this.Weight, 0);
    }

    @Test
    public void getWeightReturnsTheWeight()
    {
        this.Weight = 10;
        assertEquals(10, this.getWeight());
    }

    @Test
    public void chopReturnsTheCorrectVersion()
    {
        assertEquals("chop the vegetable dont byte it", this.chop());
    }

    @Test
    public void eatReturnsTheCorrectVersion()
    {
        assertEquals("you should eat vegetables cooked", this.eat());
    }

    @Override
    public String getKind() {
        // function to be implemented by subclasses of vegetable
        throw new UnsupportedOperationException("Unimplemented method 'getKind'");
    }

    @Override
    public void setKind(String name) {
        // function to be implemented by subclasses of vegetable
        throw new UnsupportedOperationException("Unimplemented method 'setKind'");
    }

}