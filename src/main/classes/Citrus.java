package main.classes;

public class Citrus extends Fruit
{
    String cname;
    
    Citrus(String name)
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