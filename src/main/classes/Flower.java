package main.classes;

import main.enums.Intensity;

public class Flower extends Plant
{
    protected String name;
    protected Intensity smell;

    public Flower(String name, Intensity smell)
    {
        this.name = name;
        this.smell = smell;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setIntensity(String smell)
    {
        this.smell = Intensity.valueOf(smell);
    }

    public String getIntensity()
    {
        return this.smell.toString();
    }
}