package com.gui.strings;

public class Text {
    public static String GenerateTUIText() {
        String text = "";
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 30; x++) {
                if (x < y) {
                    text += "f";
                } else {
                    text += "9";
                }
            }
            text += "\n";
        }
        return text;
    }
}
