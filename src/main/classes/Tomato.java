package main.classes;

public class Tomato extends Vegetable
{
    String kind;
    
    public Tomato(String kind)
    {
        this.kind = kind;
    }

    public void setKind(String kind)
    {
        this.kind = kind;
    }

    public String getKind()
    {
        return this.kind;
    }
}