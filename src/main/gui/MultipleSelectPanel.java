package main.gui;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.ArrayList;

public class MultipleSelectPanel extends JPanel
{
    JLabel label;
    ArrayList<JComboBox<Object>> list;
    
    public MultipleSelectPanel(String label, Object[]... values)
    {
        super(new FlowLayout(FlowLayout.LEFT));
        this.label = new JLabel(label);
        this.add(this.label);
        this.list = new ArrayList<JComboBox<Object>>();
        for (int i = 0; i < values.length; i++)
        {
            this.list.add(new JComboBox<>(values[i]));
            this.add(this.list.get(i));
        }
    }

    public ArrayList<JComboBox<Object>> getList()
    {
        return this.list;
    }
}