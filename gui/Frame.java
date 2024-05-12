package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Frame extends JFrame
{
    public Frame(String title)
    {
        super(title);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);
    }
}