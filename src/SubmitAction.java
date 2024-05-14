// package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import gui.AddPanel;
import gui.ComplexPanel;
import gui.InputPanel;
import gui.SelectPanel;
import gui.MultipleSelectPanel;

public class SubmitAction implements ActionListener
{
    AddPanel panel;
    
    ArrayList<Vegetable> vegetablelist;
    ArrayList<Flower> flowerlist;
    ArrayList<Fruit> fruitlist;

    public SubmitAction(ArrayList<Vegetable> vegetablelist, int i) 
    {
        this.vegetablelist = vegetablelist;
    }

    public SubmitAction(ArrayList<Fruit> flowerlist, float i)  
    {
        this.fruitlist = flowerlist;
    }

    public SubmitAction(ArrayList<Flower> fruitlist, double i) 
    {
        this.flowerlist = fruitlist;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.panel = (AddPanel)(((JButton)e.getSource()).getParent()).getParent();
        JPanel[] panels = this.panel.getPanels();
        ArrayList<String> inputs = getInput(panels);
        
        if (this.panel.getName() == "Vegetable")
        {
            this.vegetablelist.add(new Tomato(inputs.get(0)));
            Vegetable currentVegetable = this.vegetablelist.get(this.vegetablelist.size() - 1);
            currentVegetable.setColor(inputs.get(1));
        }
        else if (this.panel.getName() == "Fruit")
        {
            this.fruitlist.add(new Apple(inputs.get(0)));
            Fruit currentFruit = this.fruitlist.get(this.fruitlist.size() - 1);
            currentFruit.setColor(inputs.get(1));
        }
        else
        {
            this.flowerlist.add(new Flower(inputs.get(0), Intensity.valueOf(inputs.get(2))));
            Flower currentFlower = this.flowerlist.get(this.flowerlist.size() - 1);
            currentFlower.setColor(inputs.get(1));
            currentFlower.setWatered(inputs.get(3), inputs.get(4), inputs.get(5));
        }
        
    }

    private ArrayList<String> getInput(JPanel[] panels) {
        ArrayList<String> inputs = new ArrayList<>();
        for (int i=0; i < panels.length; i++)
        {
            if (panels[i] instanceof InputPanel)
            {
                inputs.add((String)((InputPanel)(panels[i])).getText());
                ((InputPanel)(panels[i])).setText(null);
            }
            else if (panels[i] instanceof SelectPanel)
            {
                inputs.add((String)((SelectPanel)(panels[i])).getList().getSelectedItem());
            }
            else if (panels[i] instanceof MultipleSelectPanel)
            {
                for (JComboBox<Object> list : ((MultipleSelectPanel)(panels[i])).getList())
                {
                    inputs.add((String)list.getSelectedItem());
                }
            }
            else 
            {
                inputs.addAll(getInput(((ComplexPanel)panels[i]).getPanels()));
            }
        }
        return inputs;
    }
}
