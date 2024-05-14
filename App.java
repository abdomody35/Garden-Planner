import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import actions.AddAction;
import actions.SearchAction;
import actions.SubmitAction;
import classes.Flower;
import classes.Fruit;
import classes.Vegetable;
import gui.AddPanel;
import gui.ComplexPanel;
import gui.Frame;
import gui.InputPanel;
import gui.MainPanel;
import gui.MultipleSelectPanel;
import gui.SelectPanel;

public class App
{
    public static void main(String[] args) throws Exception
    {
        Frame frame = new Frame("Garden Planner");
        String[] options = {"Vegetable", "Fruit", "Flower"};
        MainPanel mainPanel = new MainPanel("Select Plant", options);

        frame.add(mainPanel, BorderLayout.WEST);
        
        AddPanel vegetableAddPanel = new AddPanel(
            options[0],
            new InputPanel("Enter Vegetable kind", 20),
            new InputPanel("Enter the color of the Vegetable", 20)
        );

        AddPanel fruitAddPanel = new AddPanel(
            options[1],
            new InputPanel("Enter Fruit name", 20),
            new InputPanel("Enter the color of the Fruit", 20)
        );

        String[] intensities = {"veryStrong", "strong", "middle", "weak", "veryWeak"};
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String[] hours = generateHours();

        AddPanel flowerAddPanel = new AddPanel(
            options[2],
            new InputPanel("Enter Flower name", 20),
            new InputPanel("Enter the color of the Flower", 20),
            new SelectPanel("Smell intensity of the Flower", intensities),
            new ComplexPanel(
            new MultipleSelectPanel("watering date/time", days, hours),
            new InputPanel("Duration", 10)
            )
        );

        JTextArea textArea = new JTextArea(21, 35);
        textArea.setEditable(false);

        JPanel textAreaPanel = new JPanel();
        textAreaPanel.add(textArea);
        
        JPanel[] panels = {vegetableAddPanel, fruitAddPanel, flowerAddPanel, textAreaPanel};

        ArrayList<Flower> flowerList = new ArrayList<>();
        ArrayList<Fruit> fruitList = new ArrayList<>();
        ArrayList<Vegetable> vegetableList = new ArrayList<>();

        mainPanel.getAddButton().addActionListener(new AddAction(panels));
        mainPanel.getSearchButton().addActionListener(new SearchAction(panels, vegetableList, fruitList, flowerList));
        vegetableAddPanel.getSubmitButton().addActionListener(new SubmitAction(vegetableList, 0));
        fruitAddPanel.getSubmitButton().addActionListener(new SubmitAction(fruitList, 0));
        flowerAddPanel.getSubmitButton().addActionListener(new SubmitAction(flowerList, 0));

        frame.setVisible(true);
    }

    static String[] generateHours()
    {
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
        return hours;
    }
}