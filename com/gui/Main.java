package com.gui;

import javax.swing.*;

import com.gui.UI.ButtonBox;
import com.gui.UI.Printer;
import com.gui.UI.Text2GUI;
import com.gui.strings.*;

import java.awt.Point;
import java.util.*;
import java.util.Timer;

public class Main extends JFrame{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                new Text2GUI(frame, new Point(100, 100), Text.GenerateTUIText(10, 10, 0, 0).split("\n"));
                new ButtonBox(frame, new Point(4, 4), new ArrayList<>(List.of("rep","firefox https://youtube.com", "firefox", "alacritty")));
                /*
                we dont need that yet.
                frame.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override 
                    public void mouseDragged(MouseEvent ev) {
                        System.out.println(ev.getLocationOnScreen());
                    }
                    @Override
                    public void mouseMoved(MouseEvent ev) {
                    }
                });
                */

                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    private int i = 0;
                    @Override 
                    public void run(){
                        frame.setTitle(RevertString.Revert("JGUIApplocation :33333", i));
                        i++;
                    }
                };
                new Printer(frame);
                timer.scheduleAtFixedRate(task, 0, 100);

                frame.setLayout(null);
                frame.setVisible(true);
                frame.setSize(600, 600);
            }
        });
    }
}
