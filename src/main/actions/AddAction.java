package main.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.gui.Frame;
import main.gui.MainPanel;

public class AddAction implements ActionListener
{
    Frame frame;
    MainPanel mainPanel;
    JPanel[] panels;
    
    public AddAction(JPanel... panels)
    {
        this.panels = new JPanel[panels.length];
        for (int i = 0; i < panels.length; i++)
        {
            this.panels[i] = panels[i];
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.mainPanel = (MainPanel)(((JButton)e.getSource()).getParent()).getParent();
        this.frame = (Frame)mainPanel.getParent().getParent().getParent().getParent();
        int index = mainPanel.getList().getSelectedIndex();
        for (int i = 0; i < panels.length; i++)
        {
            if (i == index)
            {
                frame.add(panels[i]);
            }
            else
            {
                frame.remove(panels[i]);
            }
        }
        frame.revalidate();
        frame.repaint();
    }
}