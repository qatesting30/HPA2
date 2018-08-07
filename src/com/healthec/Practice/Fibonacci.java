package com.healthec.Practice;

public class Fibonacci {

    public static void getFibonacciNumbers(int num) {

        int a =0,b=1,c;

        System.out.print(a+" "+b);

        for(int i=2;i<num;i++){
            c=a+b;
            System.out.print(" "+c);
            a=b;
            b=c;
        }
    }

    public static void main(String[] args) {
        getFibonacciNumbers(10);
    }
}
