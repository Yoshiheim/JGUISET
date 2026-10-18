package com.gui.style;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Style2Button {
    public static void set(JButton but) {
        but.setFocusPainted(false);
        but.setContentAreaFilled(false);
        but.setOpaque(true);
        but.setVisible(false);
        but.setBorder(new LineBorder(Color.red, 10));
        but.setBorder(new LineBorder(Color.blue, 2));
        but.setFont(new Font("Arial", Font.PLAIN, 10)); 
    }
}
