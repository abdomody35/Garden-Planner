import java.awt.BorderLayout;

import javax.swing.JTextArea;

import gui.AddPanel;
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
            new InputPanel("Enter Vegetable kind", 20),
            new InputPanel("Enter the color of the Vegetable", 20)
        );

        AddPanel fruitAddPanel = new AddPanel(
            new InputPanel("Enter Fruit name", 20),
            new InputPanel("Enter the color of the Fruit", 20)
        );

        String[] intensities = {"VeryStrong", "strong", "middle", "weak", "veryWeak"};
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String[] hours = generateHours();

        AddPanel flowerAddPanel = new AddPanel(
            new InputPanel("Enter Flower name", 20),
            new InputPanel("Enter the color of the Flower", 20),
            new SelectPanel("Smell intensity of the Flower", intensities),
            new MultipleSelectPanel("watering date/time", days, hours)
        );

        InputPanel durationPanel = new InputPanel("Duration", 10);

        flowerAddPanel.panels[flowerAddPanel.panels.length - 1].add(durationPanel);

        JTextArea textArea = new JTextArea(21, 35);
        textArea.setEditable(false);
        
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