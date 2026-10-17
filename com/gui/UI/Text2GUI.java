package com.gui.UI;


import javax.swing.*;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Text2GUI {
    public Point location;
    public String[] strs;
    public ArrayList<JLabel> labels = new ArrayList<>();

    public Text2GUI(JFrame frame, Point location, String[] strs) {
        int i = 0;
        for (String s : strs) {
            String text;
            if (s.length() > 30) {
                text = s.substring(0, 30);
            } else {
                text = s;
            }

            JLabel label = new JLabel(text);
            label.setLocation(location.x, location.y + (i * 14));
            label.setSize(200, 30);
            labels.add(label);
            frame.add(label);
            i++;
        }
    }

}