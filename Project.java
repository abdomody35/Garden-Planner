import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Project {
    
    // DayHr class implementation which holds a watering time
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
            return this.day + ", " + this.time + ", " + this.duration;
        }
    }

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
            watering = new ArrayList<DayHr>();
            if (schedule == null)
            {
                schedule = new DayHr();
            }
            watering.add(schedule);
        }

        public void setWatered(String time, String day, String duration)
        {
            watering = new ArrayList<DayHr>();
            this.addWatered(time, day, duration);
        }

        public void addWatered(DayHr schedule)
        {
            if (schedule == null)
            {
                schedule = new DayHr();
            }
            watering.add(schedule);
        }

        public void addWatered(String time , String day, String duration)
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

    // Eatable interface implementation
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

    // Vegetable class implementation
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
        // Create an instance of project class since all the other classes are inner classes of the project class
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


        // GUI Starts here


        // 1) Initial GUI
        // Create JFrame with border layout
        JFrame frame = new JFrame("Garden Planner");
        frame.setLayout(new BorderLayout());

        // Create JPanel p1 with flow layout
        JPanel p1 = new JPanel(new FlowLayout());

        // Create a JLabel "Select Plant" and add it to p1
        JLabel selectLabel = new JLabel("Select Plant");
        p1.add(selectLabel);

        // Create a JComboBox with all Plant values and add it to p1
        String[] plants = {"Vegetable", "Fruit", "Flower"};
        JComboBox<String> plantList = new JComboBox<>(plants);
        p1.add(plantList);

        // Create JPanel p2 with flow layout
        JPanel p2 = new JPanel(new FlowLayout());

        // Create JButton "Add" and add it to p2
        JButton addButton = new JButton("Add");
        p2.add(addButton);

        // Create JButton "Search" and add it to p2
        JButton searchButton = new JButton("Search");
        p2.add(searchButton);

        // Create JPanel p3 with border layout and add p1 (north) and p2 (south) to it
        JPanel p3 = new JPanel(new BorderLayout());
        p3.add(p1, BorderLayout.NORTH);
        p3.add(p2, BorderLayout.SOUTH);
        p2.setBorder(new EmptyBorder(0, 50, 75, 100));

        // Add p3 (west) to the frame
        frame.add(p3, BorderLayout.WEST);


        // 2) When Flower is selected and add button is pressed
        // Create JPanel p4 with flow layout (left)
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create a JLabel "Enter Flower name" and  add it to p4
        JLabel enterNameLabel = new JLabel("Enter Flower name");
        p4.add(enterNameLabel);
        
        // Create a JTextField for flower name input and add it to p4
        final JTextField nameTextField = new JTextField(20);
        p4.add(nameTextField);

        // Create JPanel p5 with flow layout (left)
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create a JLabel "Enter the color of the Flower" and  add it to p5
        JLabel enterColorLabel = new JLabel("Enter the color of the Flower");
        p5.add(enterColorLabel);
        
        // Create a JTextField for flower color input and add it to p5
        final JTextField colorTextField = new JTextField(20);
        p5.add(colorTextField);

        // Create JPanel p6 with flow layout (left)
        JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create a JLabel "Smell intensity of the Flower" and  add it to p5
        JLabel smellLabel = new JLabel("Smell intensity of the Flower");
        p6.add(smellLabel);

        // Create a JComboBox with intensity values and add it to p6
        String[] intensities = {"VeryStrong", "strong", "middle", "weak", "veryWeak"};
        JComboBox<String> intensitiesList = new JComboBox<>(intensities);
        p6.add(intensitiesList);

        // Create JPanel p7 with flow layout (left)
        JPanel p7 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create a JLabel "watering date/time" and add it to p7
        JLabel waterDateLabel = new JLabel("watering date/time");
        p7.add(waterDateLabel);

        // Create a calender to pick the day from and add it to p7
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        JComboBox<String> daysList = new JComboBox<>(days);
        p7.add(daysList);

        // Create a JList with all 24 hours values and add it to p7
        String[] hours = new String[48];
        for (int i = 0; i < 24; i++)
        {
            if (i % 2 == 0)
            {
                hours[i] = String.valueOf(i / 2) + ":00 AM";
            }
            else
            {
                hours[i] = String.valueOf(i / 2) + ":30 AM";
            }
        }
        for (int i = 24; i < 48; i++)
        {
            if (i / 2 - 12 == 0)
            {
                hours[i++] = "12:00 PM";
                hours[i] = "12:30 PM";
                continue;
            }
            else if (i % 2 == 0)
            {
                if (i / 2 - 12 != 0)
                {
                    hours[i] = String.valueOf(i / 2 - 12) + ":00 PM";
                }
            }
            else
            {
                hours[i] = String.valueOf(i / 2 - 12) + ":30 PM";
            }
        }
        JComboBox<String> hourList = new JComboBox<>(hours);
        p7.add(hourList);

        // Create a JLabel "Duration" and add it to p7
        JLabel durationLabel = new JLabel("Duration");
        p7.add(durationLabel);

        // Create a JTextField for Duration and add it to p7
        JTextField durationField = new JTextField(10);
        p7.add(durationField);

        // Create JPanel p8 with flow layout (left)
        JPanel p8 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create a JButton "Submit" and add it to p8
        JButton submitBtn = new JButton("Submit");
        p8.add(submitBtn);
        
        // Create JPanel p8 with grid layout (1 cloumn) and add p4, p5, p6, p7 and p8 to it
        JPanel p9 = new JPanel(new GridLayout(0,1));
        p9.add(p4);
        p9.add(p5);
        p9.add(p6);
        p9.add(p7);
        p9.add(p8);

        // Add p9 (east) to the frame (for testing)
        // frame.add(p9, BorderLayout.EAST);


        // 3) When Flower is selected and search button is pressed
        // Create JPanel p10 of flow layout
        JPanel p10 = new JPanel();
        p10.setBorder(new EmptyBorder(0, 0, 10, 10));

        // Creata a JTextArea and add it to p10
        JTextArea textArea = new JTextArea(21, 35);
        textArea.setEditable(false);
        p10.add(textArea);

        // Add p10 (east) to the frame (for testing)
        // frame.add(p10, BorderLayout.EAST);


        // 4) When “add” button is presses for fruit
        // Create JPanel p11 with flow layout (left)
        JPanel p11 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create a JLabel "Enter Fruit name" and  add it to p11
        JLabel EnterNameLabel = new JLabel("Enter Fruit name");
        p11.add(EnterNameLabel);
        
        // Create a JTextField for fruit name input and add it to p11
        final JTextField NameTextField = new JTextField(20);
        p11.add(NameTextField);

        // Create JPanel p12 with flow layout (left)
        JPanel p12 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create a JLabel "Enter the color of the Fruit" and  add it to p12
        JLabel EnterColorLabel = new JLabel("Enter the color of the Fruit");
        p12.add(EnterColorLabel);
        
        // Create a JTextField for fruit color input and add it to p12
        final JTextField ColorTextField = new JTextField(20);
        p12.add(ColorTextField);
        
        // Create JPanel p13 with flow layout (left)
        JPanel p13 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create a JButton "Submit" and add it to p13
        JButton SubmitBtn = new JButton("Submit");
        p13.add(SubmitBtn);

        // Create JPanel p14 with grid layout (1 cloumn) and add p11, p12 and p13 to it
        JPanel p14 = new JPanel(new GridLayout(0,1));
        p14.add(p11);
        p14.add(p12);
        p14.add(p13);

        // Add p14 (east) to the frame (for testing)
        // frame.add(p14, BorderLayout.EAST);


        // 5) When “add” button is presses for vegetable
        // Create JPanel p15 with flow layout (left)
        JPanel p15 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create a JLabel "Enter Vegetable kind" and  add it to p15
        JLabel enterKindLabel = new JLabel("Enter Vegetable kind");
        p15.add(enterKindLabel);
        
        // Create a JTextField for vegetable kind input and add it to p15
        JTextField enterKindField = new JTextField(20);
        p15.add(enterKindField);

        // Create JPanel p16 with flow layout (left)
        JPanel p16 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create a JLabel "Enter the color of the Vegetable" and  add it to p16
        JLabel ColorLabel = new JLabel("Enter the color of the Vegetable");
        p16.add(ColorLabel);
        
        // Create a JTextField for vegetable color input and add it to p16
        final JTextField ColorField = new JTextField(20);
        p16.add(ColorField);
        
        // Create JPanel p17 with flow layout (left)
        JPanel p17 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create a JButton "Submit" and add it to p17
        JButton submitButton = new JButton("Submit");
        p17.add(submitButton);

        // Create JPanel p18 with grid layout (1 cloumn) and add p15, p16 and p17 to it
        JPanel p18 = new JPanel(new GridLayout(0,1));
        p18.add(p15);
        p18.add(p16);
        p18.add(p17);

        // Add p18 (east) to the frame (for testing)
        // frame.add(p18, BorderLayout.EAST);


        // Set frame properties and make it visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setVisible(true);


        // Actions start here
        // Create an Action for addButton to show the respective panel
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (plantList.getSelectedItem() == "Flower") 
                {
                    frame.remove(p14);
                    frame.remove(p10);
                    frame.remove(p18);
                    frame.add(p9);
                }
                else if (plantList.getSelectedItem() == "Fruit")
                {
                    frame.remove(p9);
                    frame.remove(p10);
                    frame.remove(p18);
                    frame.add(p14);
                }
                else
                {
                    frame.remove(p9);
                    frame.remove(p10);
                    frame.remove(p14);
                    frame.add(p18);
                }
                frame.revalidate();
                frame.repaint();
            }
        });

        // Create a flowerList to save all created flowers
        ArrayList<Flower> flowerList = new ArrayList<Flower>();

        // Create an action for submitBtn to create flower and add it to flowerList
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flowerList.add(
                    test.new Flower(nameTextField.getText(),
                    intensity.valueOf(String.valueOf(intensitiesList.getSelectedItem())))
                );
                Flower currentFlower = flowerList.get(flowerList.size() - 1);
                currentFlower.setColor(colorTextField.getText());
                currentFlower.setWatered(
                        String.valueOf(daysList.getSelectedItem()),
                        String.valueOf(hourList.getSelectedItem()),
                        durationField.getText()
                    );
                frame.remove(p9);
                frame.remove(p10);
                frame.remove(p14);
                frame.remove(p18);
                frame.revalidate();
                frame.repaint();
                nameTextField.setText(null);
                colorTextField.setText(null);
                durationField.setText(null);
            }
        });

        // Create a fruitList to save all created fruits
        ArrayList<Fruit> fruitList = new ArrayList<Fruit>();

        // Create an action for SubmitBtn to create fruit and add it to fruitList
        SubmitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fruitList.add(test.new Apple(NameTextField.getText()));
                Fruit currentFruit = fruitList.get(fruitList.size() - 1);
                currentFruit.setColor(ColorTextField.getText());
                frame.remove(p9);
                frame.remove(p10);
                frame.remove(p14);
                frame.remove(p18);
                frame.revalidate();
                frame.repaint();
                NameTextField.setText(null);
                ColorTextField.setText(null);
            }
        });

        // Create a vegetableList to save all created vegetables
        ArrayList<Vegetable> vegetableList = new ArrayList<Vegetable>();

        // Create an action for submitbutton to create vegetable and add it to vegetableList
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vegetableList.add(test.new Tomato(enterKindField.getText()));
                Vegetable currentVegetable = vegetableList.get(vegetableList.size() - 1);
                currentVegetable.setColor(ColorField.getText());
                frame.remove(p9);
                frame.remove(p10);
                frame.remove(p14);
                frame.remove(p18);
                frame.revalidate();
                frame.repaint();
                enterKindField.setText(null);
                ColorField.setText(null);
            }
        });

        // Create an action for searchButton to show the respective panel
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (plantList.getSelectedItem() == "Flower") 
                {
                    textArea.setText(null);
                    for (Flower flower : flowerList)
                    {
                        textArea.append(
                            flower.getName() + ", " +
                            flower.getColor() + ", " +
                            flower.getIntensity() + ", "
                        );
                        for (DayHr schedule : flower.getWatered())
                        {
                            textArea.append(schedule.get() + "\n");
                        }
                    }
                }
                else if (plantList.getSelectedItem() == "Fruit")
                {
                    textArea.setText(null);
                    for (Fruit fruit : fruitList)
                    {
                        textArea.append(
                            fruit.getName() + ", " +
                            fruit.getColor() + ", "
                        );
                        for (DayHr schedule : fruit.getWatered())
                        {
                            textArea.append(schedule.get() + "\n");
                        }
                    }
                }
                else
                {
                    textArea.setText(null);
                    for (Vegetable vegetable : vegetableList)
                    {
                        textArea.append(
                            vegetable.getKind() + ", " +
                            vegetable.getColor() + ", "
                        );
                        for (DayHr schedule : vegetable.getWatered())
                        {
                            textArea.append(schedule.get() + "\n");
                        }
                    }
                }
                frame.remove(p14);
                frame.remove(p9);
                frame.remove(p18);
                frame.add(p10);
                frame.revalidate();
                frame.repaint();
            }
        });
    }
}
