package com.gui;

import javax.swing.*;

import com.gui.strings.*;

import java.awt.Point;
import java.util.*;

public class Main extends JFrame{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                new ButtonBox(frame, new Point(4, 4), new ArrayList<>(List.of("s", "fuck", "rep")));
                new Text2GUI(frame, Text.GenerateTUIText().split("\n"));
                frame.setLayout(null);
                frame.setVisible(true);
                frame.setSize(600, 600);
            }
        });
    }
}
