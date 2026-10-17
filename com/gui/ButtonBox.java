package com.gui;

import java.io.IOException;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ButtonBox {
        public JButton b = new JButton("open");
        public ArrayList<JButton> buttons = new ArrayList<>();
        public ArrayList<String> opinions;
        AtomicBoolean isOpen = new AtomicBoolean(false);

        public ButtonBox(JFrame frame, Point location, ArrayList<String> opinions) {
            b.setBounds(50 * location.y, 50 * location.y, 50, 50);
            this.opinions = opinions;
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int j = 0;
            for (String o : opinions) {
                JButton but = new JButton(o);
                but.setBounds((50 * location.x) + b.getSize().width, (50 * location.y) + (j * 50), 100, 50);
                but.addActionListener(ee -> {
                    switch (o) {
                        case "createlabel":
                            JLabel lab = new JLabel("CREATED");
                            lab.setBounds(new Random().nextInt(50) * 10, new Random().nextInt(50) * 10, 100, 100);
                            frame.add(lab);
                            frame.repaint();
                        case "->":
                            if (frame.getX() < screenSize.width) {
                                frame.setLocation(frame.getX() + 50, frame.getY());
                            } else {
                                frame.setLocation(frame.getX() - 50, frame.getY());
                            }
                            break;
                        case "<-":
                            if (frame.getX() > screenSize.width) {
                                frame.setLocation(frame.getX() + 50, frame.getY());
                            } else {
                                frame.setLocation(frame.getX() - 50, frame.getY());
                            }
                            break;
                        case "rep":
                            new ButtonBox(frame, new Point(new Random().nextInt(10), new Random().nextInt(10)),
                                    new ArrayList<>(List.of("idk")));
                            frame.repaint();
                            break;
                        default:
                            try {
                                new ProcessBuilder(o).start();
                            } catch (IOException err) {
                                err.printStackTrace();
                            }
                    }
                });
                but.setVisible(false);
                buttons.add(but);
                frame.add(but);
                System.out.println(j);
                j++;
            }

            b.addActionListener(e -> {
                isOpen.set(!isOpen.get());
                if (isOpen.get()) {
                    for (JButton bs : buttons) {
                        bs.setVisible(true);
                    }
                    frame.repaint();
                } else {
                    for (JButton bs : buttons) {
                        bs.setVisible(false);
                    }
                }
            });
            frame.add(b);
        }
    }
