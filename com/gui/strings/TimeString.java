package com.gui.strings;

public class TimeString {
    public static String Use(String s){
        char[] buf = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            buf[i/2] = s.charAt((i/2)%s.length());
        }
        return buf.toString();
    }
}
