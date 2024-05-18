package test.unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.classes.Fruit;

public class FruitTest extends Fruit
{
    
    @Before
    public void setUp() 
    {
        this.price = 0;
    }

    @Test
    public void sePricetSetsTheGivenPrice()
    {
        this.setPrice(10);
        assertEquals(10, this.price, 0);
    }

    @Test
    public void getPriceReturnsThePrice()
    {
        this.price = 10;
        assertEquals(10, this.getPrice());
    }

    @Test
    public void chopReturnsTheCorrectVersion()
    {
        assertEquals("don't chop the fruit byte it", this.chop());
    }

    @Test
    public void eatReturnsTheCorrectVersion()
    {
        assertEquals("you should eat fruits raw", this.eat());
    }

    @Override
    public String getName() {
        // function to be implemented by subclasses of vegetable
        throw new UnsupportedOperationException("Unimplemented method 'getKind'");
    }

    @Override
    public void setName(String name) {
        // function to be implemented by subclasses of vegetable
        throw new UnsupportedOperationException("Unimplemented method 'setKind'");
    }

}