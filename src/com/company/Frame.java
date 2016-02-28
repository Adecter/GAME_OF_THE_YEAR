package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;


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

        JButton javaButton = new JButton("Start game");
        javaButton.isDefaultButton();
        frame.getContentPane().add(javaButton, BorderLayout.BEFORE_FIRST_LINE);
        javaButton.setPreferredSize(new Dimension(10, 100));
        javaButton.setVisible(true);

        JButton startButton = new JButton("Run exe");
        startButton.isDefaultButton();
        frame.getContentPane().add(startButton, BorderLayout.BEFORE_LINE_BEGINS);
        startButton.setPreferredSize(new Dimension(100, 1));
        startButton.setVisible(true);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)/Notepad++/notepad++.exe");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
//                Process process = Runtime.getRuntime().exec("cmd.exe /C start C:\\Program Files (x86)\Notepad++\\notepad++.exe" );
            }
        });

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(1280, 1240));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        JLabel secondLabel = new JLabel("");
        secondLabel.setPreferredSize(new Dimension(200, 200));
        frame.getContentPane().add(secondLabel, BorderLayout.AFTER_LAST_LINE);
        frame.setIconImage(new ImageIcon("E:\\Adrian/icon.png").getImage());
        javaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secondLabel.setText("Game is started. Loading...");
                secondLabel.setHorizontalTextPosition(SwingConstants.LEFT);
            }
        });
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