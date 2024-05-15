package main.actions;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import main.classes.DayHr;
import main.classes.Flower;
import main.classes.Fruit;
import main.classes.Vegetable;
import main.gui.Frame;
import main.gui.MainPanel;

public class SearchAction implements ActionListener
{
    Frame frame;
    MainPanel mainPanel;
    JPanel[] panels;
    ArrayList<Vegetable> vegetableList;
    ArrayList<Fruit> fruitList ;
    ArrayList<Flower> flowerList;

    public SearchAction(JPanel[] panels,ArrayList<Vegetable> vegetableList, ArrayList<Fruit> fruitList, ArrayList<Flower> flowerList)
    {
        this.panels = panels;
        this.vegetableList = vegetableList;
        this.fruitList= fruitList;
        this.flowerList = flowerList;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.mainPanel = (MainPanel)(((JButton)e.getSource()).getParent()).getParent();
        this.frame = (Frame)mainPanel.getParent().getParent().getParent().getParent();
        int index = mainPanel.getList().getSelectedIndex();
        int length = panels.length - 1;
        JTextArea textArea = ((JTextArea)panels[length].getComponent(0));
        textArea.setText(null);
        if (index == 0)
        {
            for (Vegetable vegetable : this.vegetableList)
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
        else if (index == 1)
        {

            for (Fruit fruit : this.fruitList)
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
            for (Flower flower : this.flowerList)
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
        for (int i = 0; i < length; i++)
        {
            frame.remove(panels[i]);
        }
        frame.add(panels[length]);
        frame.revalidate();
        frame.repaint();
    }
}