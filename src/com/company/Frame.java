package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/* FrameDemo.java requires no other files. */
public class Frame {

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() throws FileNotFoundException {
        //Create and set up the window.
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Game of the YEAR");
        frame.setSize(1000, 1000);
        frame.setLocation(150, 10);
        frame.setMinimumSize(new Dimension(950, 950));
        frame.setMaximumSize(new Dimension(1000, 1000));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date d = new Date();
        System.out.println(df.format(d));
        JLabel timelabel = new JLabel();
        timelabel.setText(String.valueOf(d));
        frame.getContentPane().add(timelabel, BorderLayout.CENTER);
        timelabel.setFont(new Font("Courier New", Font.ITALIC, 36));
        timelabel.setSize(10, 20);

        JButton javaButton = new JButton("Start game");
        javaButton.isDefaultButton();
        frame.getContentPane().add(javaButton, BorderLayout.BEFORE_FIRST_LINE);
        javaButton.setPreferredSize(new Dimension(10, 10));
        javaButton.setVisible(true);

        javaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    java.awt.Desktop.getDesktop().browse(URI.create("http://store.steampowered.com/app/730/?snr=1_5_9__300"));
                } catch (java.io.IOException a) {
//                     openWebPage("http://www.mywebsite.com/forum/");
                    System.out.println("ne sudba");
                }
            }
        });


        JButton startButton = new JButton("Run");
        startButton.isDefaultButton();
        frame.getContentPane().add(startButton, BorderLayout.BEFORE_LINE_BEGINS);
        startButton.setPreferredSize(new Dimension(20, 1));
        startButton.setVisible(true);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)/Notepad++/notepad++.exe");
                    //C:\Program Files (x86)/Notepad++/notepad++.exe
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
//                Process process = Runtime.getRuntime().exec("cmd.exe /C start C:\\Program Files (x86)\Notepad++\\notepad++.exe" );
            }
        });

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(500, 500));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        JLabel secondLabel = new JLabel("");
        secondLabel.setPreferredSize(new Dimension(200, 200));
        frame.getContentPane().add(secondLabel, BorderLayout.AFTER_LAST_LINE);
        frame.setIconImage(new ImageIcon("./csgoicon.png").getImage());
        javaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secondLabel.setText("Game is started. Loading...");
                secondLabel.setHorizontalTextPosition(SwingConstants.CENTER);

            }
        });


        JButton ListButton = new JButton("Wiki");
        ListButton.isDefaultButton();
        frame.getContentPane().add(ListButton, BorderLayout.LINE_END);
        ListButton.setPreferredSize(new Dimension(20, 1));
        ListButton.setVisible(true);
        final JLabel ListLabel = new JLabel("");
        ListLabel.setFont(new Font("Serif", Font.ROMAN_BASELINE, 36));
        frame.getContentPane().add(ListLabel, BorderLayout.AFTER_LAST_LINE);

        final int[] r = {255, 255, 255, 0, 0, 255};
        final int[] g = {0, 128, 255, 255, 255, 0, 0};
        final int[] b = {0, 0, 0, 0, 255, 255, 255};
        final int[] max = {250};


        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

//
                    int i1=0;
                    while (i1 <= 5) {
                        ListLabel.setForeground(new Color(r[i1], g[i1], b[i1]));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        i1++;
                    }


                }
            }
        });

        //Color.HSBtoRGB(0.9f,1.0f,0.8f));

        int character;
        StringBuffer buffer = new StringBuffer("");
        FileInputStream inputStream = new FileInputStream(new File("E:\\Adrian/FrameTest/out/production/FrameTest/info.txt"));

        try {
            while ((character = inputStream.read()) != -1)
                buffer.append((char) character);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  System.out.println(buffer);


        ListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListLabel.setHorizontalTextPosition(SwingConstants.CENTER);


                myThread.start();
                ListLabel.setText(("<html>" + String.valueOf(buffer) + "||create at " + df.format(d) + "</html>"));


            }
        });
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.add(new JLabel(new ImageIcon("./giphy.gif")));
        //frame.add(new JLabel(new Button));
    }
    //Button add


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter out = new BufferedWriter(new FileWriter("E:\\Adrian/FrameTest/out/production/FrameTest/info.txt"));
        try {
            String inputLine = null;
            do {
                inputLine = in.readLine();
                out.write(inputLine);
                out.newLine();
            } while (!inputLine.equalsIgnoreCase("."));
            System.out.print("Write Successful");
        } catch (IOException e1) {
            System.out.println("Error during reading/writing");
        } finally {
            out.close();
            in.close();
        }

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });
    }
}