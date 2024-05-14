package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainPanel extends JPanel
{
    SelectPanel selectPanel;
    JButton addButton = new JButton("Add");
    JButton searchButton = new JButton("Search");

    public MainPanel(SelectPanel selectPanel) 
    {
        super(new BorderLayout());
        this.selectPanel = selectPanel;
        this.add(selectPanel, BorderLayout.NORTH);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(addButton);
        buttonsPanel.add(searchButton);
        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.setBorder(new EmptyBorder(0, 50, 75, 100));
    }

    public MainPanel(String label, Object[] options) 
    {
        super(new BorderLayout());
        this.selectPanel = new SelectPanel(label, options);
        this.add(selectPanel, BorderLayout.NORTH);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(addButton);
        buttonsPanel.add(searchButton);
        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.setBorder(new EmptyBorder(0, 50, 75, 100));
    }

    public JComboBox<Object> getList()
    {
        return this.selectPanel.getList();
    }

    public JButton getAddButton()
    {
        return this.addButton;
    }

    public JButton getSearchButton()
    {
        return this.searchButton;
    }
}