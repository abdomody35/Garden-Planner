import java.util.ArrayList;

public class Project {
    
    // DayHr class implementation which holds a watering time for a week
    public class DayHr
    {
        private String time, day, duration;

        public DayHr()
        {
            this.time = "10 AM";
            this.day = "Monday";
            this.duration = "1 hr";
        }

        public DayHr(String time, String day, String duration)
        {
            this.time = time;
            this.day = day;
            this.duration = duration;
        }
        
        public String getTime()
        {
            return this.time;
        }

        public String getDay()
        {
            return this.day;
        }

        public String getDuration()
        {
            return this.duration;
        }

        public String get()
        {
            return this.time + ", " + this.day + ", " + this.duration;
        }
    }
    
    /* 
    // DayHr class implementation which holds a list of watering time for a week
    public class DayHr
    {
        private ArrayList<String> times, days, durations;

        public DayHr()
        {
            this.times = new ArrayList<>();
            this.times.add("10 AM");
            this.days = new ArrayList<>();
            this.days.add("Monday");
            this.durations = new ArrayList<>();
            this.durations.add("1 hr");
        }

        public DayHr(ArrayList<String> times, ArrayList<String> days, ArrayList<String> duration, ArrayList<String> durations)
        {
            this.times = times;
            this.days = days;
            this.durations = durations;
        }

        public void add(String time, String day, String duration)
        {
            times.add(time);
            days.add(day);
            durations.add(duration);
        }
        
        public ArrayList<String> getTimes()
        {
            return this.times;
        }

        public ArrayList<String> getDays()
        {
            return this.days;
        }

        public ArrayList<String> getDurations()
        {
            return this.durations;
        }
    }
    */

    // Plant class implementation
    public abstract class Plant 
    {
        String color;
        ArrayList<DayHr> watering = new ArrayList<DayHr>();

        public String getColor() 
        {
            return this.color;
        }
        
        public void setColor(String color) 
        {
            this.color = color;
        }

        public void setWatered(DayHr schedule)
        {
            if (schedule == null)
            {
                schedule = new DayHr();
            }
            watering.add(schedule);
        }

        public void setWatered(String time, String day, String duration)
        {
            if (time == null)
            {
                time = "10 AM";
            }
            if (day == null)
            {
                day = "Monday";
            }
            if (duration == null)
            {
                duration = "1 hr";
            }
            watering.add(new DayHr(time, day, duration));
        }

        public ArrayList<DayHr> getWatered() 
        {
            if (watering.size() == 0)
            {
                ArrayList<DayHr> temp = new ArrayList<DayHr>();
                temp.add(new DayHr());
                return temp;
            }
            return watering;
        }
    }

    // Eatable ınterface implementation
    public interface Eatable 
    {
        public String chop();
        public String eat();
    }

    // intensity enum implementation
    public enum intensity
    {
        veryStrong,
        strong,
        middle,
        weak,
        veryWeak
    }

    // Flower class implementation
    public class Flower extends Plant
    {
        private String name;
        private intensity smell;

        Flower(String name, intensity smell)
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
            this.smell = intensity.valueOf(smell);
        }

        public String getIntensity()
        {
            return this.smell.toString();
        }
    }

    // Fruit class implementation 
    public abstract class Fruit extends Plant implements Eatable
    {
        int price;

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

    // Vegetable class implementation
    public abstract class Vegetable  extends Plant implements Eatable
    {
        private int Weight;

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
    
    // Citrus class implementation
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

    // Apple class implementation
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

    // Tomato class implementation
    public class Tomato extends Vegetable
    {
        String kind;
        
        Tomato(String kind)
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

    // Main function for testing purposes
    public static void main(String[] args) throws Exception 
    {
        // Create an instance of project class since all the other classes are inner classeds of the project class
        Project test = new Project();

        // Test Citrus class with all its methods
        Citrus citrus = test.new Citrus("lemon");
        System.out.println("\n\nTesting Citrus class :\n");
        citrus.setColor("yellow");
        System.out.println("Citrus fruit has name : " + citrus.getName());
        System.out.println("Citrus fruit has color : " + citrus.getColor());
        System.out.println("Citrus fruit has watering schedule (default, no adding) : " + citrus.getWatered().get(0).get());
        citrus.setWatered(null, null, null);
        System.out.println("Citrus fruit has watering schedule (after default adding) : " + citrus.getWatered().get(0).get());
        citrus.setWatered("1 PM", "Saturday", "30 min");
        System.out.println("Citrus fruit has watering schedule (after adding) : ");
        for (DayHr x : citrus.getWatered())
        {
            System.out.println(x.get());
        }
        citrus.setPrice(10);
        System.out.println("The price of the lemon is : $" + citrus.getPrice());
        System.out.println("Should I chop Citrus Fruit ? " + citrus.chop());
        System.out.println("How should I eat Citrus Fruit ? " + citrus.eat());

        // Test Tomato class with all its methods
        Tomato tomato = test.new Tomato("cherry");
        System.out.println("\n\nTesting Tomato class :\n");
        tomato.setColor("red");
        System.out.println("Toamto vegetable has kind : " + tomato.getKind());
        System.out.println("Toamto vegetable has color : " + tomato.getColor());
        System.out.println("Toamto vegetable has watering schedule (default, no adding) : " + tomato.getWatered().get(0).get());
        tomato.setWatered(null, null, null);
        System.out.println("Toamto vegetable has watering schedule (after default adding) : " + tomato.getWatered().get(0).get());
        tomato.setWatered("1 PM", "Saturday", "30 min");
        System.out.println("Toamto vegetable has watering schedule (after adding) : ");
        for (DayHr x : tomato.getWatered())
        {
            System.out.println(x.get());
        }
        tomato.setWeight(25);
        System.out.println("The weight of the cherry tomato is : " + tomato.getWeight() + " grams");
        System.out.println("Should I chop Toamto Vegetable ? " + tomato.chop());
        System.out.println("How should I eat Toamto Vegetable ? " + tomato.eat());

        // Test Flower class with all its methods
        Flower flower = test.new Flower("orange flower", intensity.weak);
        System.out.println("\n\nTesting Flower class :\n");
        System.out.println("Flower has intensity (before changing) : " + flower.getIntensity());
        flower.setIntensity("strong");
        System.out.println("Flower has intensity (after changing) : " + flower.getIntensity());
        flower.setColor("orange");
        System.out.println("Flower has name : " + flower.getName());
        System.out.println("Flower has color : " + flower.getColor());
        System.out.println("Flower has watering schedule (default, no adding) : " + flower.getWatered().get(0).get());
        flower.setWatered(null, null, null);
        System.out.println("Flower has watering schedule (after default adding) : " + flower.getWatered().get(0).get());
        flower.setWatered("1 PM", "Saturday", "30 min");
        System.out.println("Flower has watering schedule (after adding) : ");
        for (DayHr x : flower.getWatered())
        {
            System.out.println(x.get());
        }

        // Test Apple class with all its methods
        Apple apple = test.new Apple("green apple");
        System.out.println("\n\nTesting Apple class :\n");
        apple.setColor("green");
        System.out.println("Apple fruit has name : " + apple.getName());
        System.out.println("Apple fruit has color : " + apple.getColor());
        System.out.println("Apple fruit has watering schedule (default, no adding) : " + apple.getWatered().get(0).get());
        apple.setWatered(null, null, null);
        System.out.println("Apple fruit has watering schedule (after default adding) : " + apple.getWatered().get(0).get());
        apple.setWatered("1 PM", "Saturday", "30 min");
        System.out.println("Apple fruit has watering schedule (after adding) : ");
        for (DayHr x : apple.getWatered())
        {
            System.out.println(x.get());
        }
        apple.setPrice(10);
        System.out.println("The price of the green apple is : $" + apple.getPrice());
        System.out.println("Should I chop Apple Fruit ? " + apple.chop());
        System.out.println("How should I eat Apple Fruit ? " + apple.eat());

    }
}
