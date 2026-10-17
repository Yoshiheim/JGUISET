package com.gui.strings;

public class RevertString{
    public static String Revert(String s, int n){
        String result = "";
        for(int i = 0; i < s.length(); i++){
            result += s.charAt((n+i)%s.length());
        }
        return result;
    }
}