package main.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AddPanel extends JPanel
{
    String name;
    SubmitPanel submitPanel = new SubmitPanel() ;
    JPanel panels[];

    public AddPanel(String name, JPanel... panels)
    {
        super(new GridLayout(0,1));
        this.name = name;
        this.panels = new JPanel[panels.length];
        for (int i = 0; i < panels.length; i++)
        {
            this.panels[i] = panels[i];
            this.add(this.panels[i]);
        }
        this.add(submitPanel);
    }

    public JPanel[] getPanels()
    {
        return this.panels;
    }

    public String getName()
    {
        return this.name;
    }

    public JButton getSubmitButton()
    {
        return this.submitPanel.getSubmitButton();
    }
}