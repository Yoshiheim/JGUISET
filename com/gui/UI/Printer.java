package com.gui.UI;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.TimerTask;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Printer {
    //private ArrayList<String> Germs = new ArrayList<>(); 


    private ArrayList<ArrayList<String>> sprites = new ArrayList<>(List.of(
        new ArrayList<>(List.of(
            "new",
            "max",
            "txt"
        ))
    )); 

    public Printer(JFrame frame){
        Text2GUI t2g = new Text2GUI(frame, new Point(0, 0), sprites.get(0).toArray(String[]::new));
        TimerTask task = new TimerTask(){
            public int i = 0;
            public void run(){
                for(JLabel l : t2g.labels){
                    l.setLocation(new Point(10, i*10));
                }
                i++;
                frame.repaint();
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}