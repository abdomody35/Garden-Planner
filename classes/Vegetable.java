package classes;

public abstract class Vegetable  extends Plant implements Eatable
{
    private int Weight;

    abstract public String getKind();
    abstract public void setKind(String name);

    public void setWeight(int weight)
    {
        this.Weight = weight;
    }

    public int getWeight()
    {
        return this.Weight;
    }

    public String chop()
    {
        return "chop the vegetable dont byte it";
    }

    public String eat()
    {
        return "you should eat vegetables cooked";
    }
}