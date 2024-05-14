package classes;

import interfaces.Eatable;

public abstract class Fruit extends Plant implements Eatable
{
    int price;

    abstract public String getName();
    abstract public void setName(String name);

    public void setPrice(int price)
    {
        this.price = price;
    }

    public int getPrice()
    {
        return this.price;
    }

    public String chop()
    {
        return "don't chop the fruit byte it";
    }

    public String eat()
    {
        return "you should eat fruits raw";
    }
}