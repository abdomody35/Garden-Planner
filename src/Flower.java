public class Flower extends Plant
{
    private String name;
    private Intensity smell;

    Flower(String name, Intensity smell)
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