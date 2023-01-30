package com.company;

public class Calculator {

    public static int calc(String str) {
        String[] arr = str.split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);
        String c = arr[1];
        switch (c){
            case "-":
                return a - b;
            case "+":
                return a + b;
            case "*":
                return a * b;
            default:
                System.out.println("Что-то не так");
        }
        return -1;
    }
}
