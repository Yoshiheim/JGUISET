package com.gui.strings;

public class ReverseString {
    public static String Reverse(String s){
        char[] result = new char[s.length()];
        int start = 0;
        int end = s.length()-1;
        for(; start>end; start=end-1){
            end = start+1;
            result[end] = s.charAt(start);
            result[start] = s.charAt(end);
            System.out.printf("%d %d\n", start,end);
        }
        return result.toString();
    }
}
