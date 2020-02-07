package com.piotsi.rpn;

import java.util.Stack;

public class Rpn {

    static boolean isNumeric(String s){
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static void main(String[] args) {
        String expression = "15 7 1 1 + − ÷ 3 × 2 1 1 + + −";
        Stack<String> e = new Stack<String>();

        for (String val: expression.split(" ")){
            e.push(val);
        }
        System.out.println(e.size());
        for (Object val: e){
            System.out.println(val);
        }


    }
}
