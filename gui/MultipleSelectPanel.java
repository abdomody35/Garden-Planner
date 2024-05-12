package gui;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MultipleSelectPanel extends JPanel
{
    JLabel label;
    JComboBox<Object> list[];
    
    public MultipleSelectPanel(String label, Object[]... values)
    {
        super(new FlowLayout(FlowLayout.LEFT));
        this.label = new JLabel(label);
        this.add(this.label);
        this.list = new JComboBox[values.length];
        for (int i = 0; i < values.length; i++)
        {
            this.list[i] = new JComboBox<>(values[i]);
            this.add(this.list[i]);
        }
    }

    public JComboBox<Object>[] getList()
    {
        return this.list;
    }
}