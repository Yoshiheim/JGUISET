package com.gui;

import javax.swing.*;

import com.gui.UI.ButtonBox;
import com.gui.UI.Text2GUI;
import com.gui.strings.*;

import java.awt.Point;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

public class Main extends JFrame{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                new ButtonBox(frame, new Point(4, 4), new ArrayList<>(List.of("rep","firefox https://youtube.com", "firefox", "alacritty")));
                for(int i = 0; i < 20; i++){
                    new Text2GUI(frame, new Point(10*i, 10*i), Text.GenerateTUIText(10, 10, 1, 10).split("\n"));
                    new Text2GUI(frame, new Point(30, 30*i), Text.GenerateTUIText(20, 30, i, i).split("\n"));
                }
                frame.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override 
                    public void mouseDragged(MouseEvent ev) {
                        System.out.println(ev.getLocationOnScreen());
                        JLabel l = new JLabel("x");
                        l.setSize(10, 10);
                        l.setLocation(ev.getLocationOnScreen());
                        frame.add(l);
                    }
                    // @Override
                    // public void mouseMoved(MouseEvent ev) {
                    // }
                });
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    private int i = 0;
                    @Override 
                    public void run(){
                        frame.setTitle(RevertString.Revert("JGUIApplocation :33333", i));
                        i++;
                    }
                };
                timer.scheduleAtFixedRate(task, 0, 100);

                frame.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override 
                    public void mouseDragged(MouseEvent ev) {
                    }
                    @Override
                    public void mouseMoved(MouseEvent ev) {
                    }
                });

                frame.setLayout(null);
                frame.setVisible(true);
                frame.setSize(600, 600);
            }
        });
    }
}
