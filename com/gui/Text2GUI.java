package com.gui;

import javax.swing.*;

    public class Text2GUI {
        public Text2GUI(JFrame frame, String[] strs) {
            int i = 0;
            for (String s : strs) {
                String text;
                if (s.length() > 30) {
                    text = s.substring(0, 30);
                } else {
                    text = s;
                }

                JLabel label = new JLabel(text);
                label.setLocation(19, 10 + (i * 14));
                label.setSize(200, 30);
                frame.add(label);
                i++;
            }
        }
    }