package com.healthec.Practice;

public class Palindrom {

    public static void getPalindromNUmber(int num){
        int temp,sum=0,rev;
        temp=num;
        while(num>0){
            rev=num%10;
            sum=(sum*10)+rev;
            num=num/10;
        }
        if(temp==sum) {
            System.out.println("palindrom");
        }
        else
            System.out.println("Not palindrom");
    }

    public static void main(String[] args) {
        getPalindromNUmber(455);
    }
}
