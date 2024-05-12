public class Apple extends Fruit
{
    String aname;
    
    Apple(String name)
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