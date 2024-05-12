package gui;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectPanel extends JPanel
{
    JLabel label;
    JComboBox<Object> list;
    
    public SelectPanel(String label, Object[] values)
    {
        super(new FlowLayout(FlowLayout.LEFT));
        this.label = new JLabel(label);
        this.add(this.label);
        this.list = new JComboBox<>(values);
        this.add(this.list);
    }
}