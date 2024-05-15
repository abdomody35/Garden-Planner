package main.gui;

import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InputPanel extends JPanel
{
    JLabel label;
    JTextField textField;

    public InputPanel(String label, int width)
    {
        super(new FlowLayout(FlowLayout.LEFT));
        this.label = new JLabel(label);
        this.add(this.label);
        this.textField = new JTextField(width);
        this.add(this.textField);
    }

    public Object getText()
    {
        return this.textField.getText();
    }

    public void setText(String text)
    {
        this.textField.setText(text);
    }
}