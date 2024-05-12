package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SubmitPanel extends JPanel
{
    JButton submitButton = new JButton("Submit");

    SubmitPanel()
    {
        super(new FlowLayout(FlowLayout.LEFT));
        this.add(submitButton);
    }
}