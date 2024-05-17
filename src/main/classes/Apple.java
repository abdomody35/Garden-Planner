package main.classes;

public class Apple extends Fruit
{
    protected String aname;
    
    public Apple(String name)
    {
        this.aname = name;
    }

    public void setName(String name)
    {
        this.aname = name;
    }

    public String getName()
    {
        return this.aname;
    }
}