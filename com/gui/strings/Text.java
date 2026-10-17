package com.gui.strings;

public class Text {
    public static String GenerateTUIText(int width, int heigth,int xx, int yy)  {
        String text = "";
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < heigth; x++) {
                if (xx+x < yy+y) {
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
