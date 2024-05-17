package main.classes;

public class Citrus extends Fruit
{
    protected String cname;
    
    public Citrus(String name)
    {
        this.cname = name;
    }

    public void setName(String name)
    {
        this.cname = name;
    }

    public String getName()
    {
        return this.cname;
    }
}