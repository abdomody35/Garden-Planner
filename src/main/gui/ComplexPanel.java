package main.gui;
import javax.swing.JPanel;

public class ComplexPanel extends JPanel {
    JPanel panels[];

    public ComplexPanel(JPanel... panels) 
    {
        this.panels = new JPanel[panels.length];
        for (int i = 0; i < panels.length; i++)
        {
            this.panels[i] = panels[i];
            this.add(this.panels[i]);
        }
    }

    public JPanel[] getPanels()
    {
        return this.panels;
    }
}
