package com.company;

import javax.swing.*;
import java.awt.*;


/* FrameDemo.java requires no other files. */
public class Frame {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Game of the YEAR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(1280, 1240));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        frame.setIconImage(new ImageIcon("E:\\Adrian/icon.png").getImage());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.add(new JLabel(new ImageIcon("E:\\Adrian/csgo.jpg")));
        //frame.add(new JLabel(new Button));
    }
        //Button add


    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }

        });
    }
}