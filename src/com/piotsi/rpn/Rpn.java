package com.piotsi.rpn;

import java.util.Scanner;
import java.util.Stack;

public class Rpn{

    static boolean isNumeric(String s){
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException nfe){
            return false;
        }
    }

    public static void main(String[] args){
        Stack<String> e = new Stack<String>();
        double n1, n2;

        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        if (expression.isEmpty()){
            expression = "15 7 1 1 + - ÷ 3 x 2 1 1 + + -";
        }

        for (String val: expression.split(" ")){
            switch (val){
                case "+":
                    n1 = Double.parseDouble(e.pop());
                    n2 = Double.parseDouble(e.pop());
                    e.push(Double.toString(n2 + n1));
                    break;
                case "-":
                    n1 = Double.parseDouble(e.pop());
                    n2 = Double.parseDouble(e.pop());
                    e.push(Double.toString(n2 - n1));
                    break;
                case "*":
                case "x":
                    n1 = Double.parseDouble(e.pop());
                    n2 = Double.parseDouble(e.pop());
                    e.push(Double.toString(n2 * n1));
                    break;
                case "/":
                case "÷":
                    n1 = Double.parseDouble(e.pop());
                    n2 = Double.parseDouble(e.pop());
                    e.push(Double.toString(n2 / n1));
                    break;
                case "^":
                case "**":
                    n1 = Double.parseDouble(e.pop());
                    n2 = Double.parseDouble(e.pop());
                    e.push(Double.toString(Math.pow(n2, n1)));
                    break;
                default:
                    if (isNumeric(val)){
                        e.push(val);
                    } else {
                        System.out.println("Illegal character" + val);
                        return;
                    }
            }
        }
        System.out.println(expression + " = " + e.pop());
    }
}
