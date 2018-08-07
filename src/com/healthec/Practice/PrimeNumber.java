package com.healthec.Practice;

public class PrimeNumber {


    public static void getPrimeNumbers(int num){

        int flag=0,temp=num/2;
        if(num==0||num==1){
            System.out.println("Not a prime Number");
        }
        for(int i=2;i<temp;i++){
            if(num%i==0){
                System.out.println("Not Prime");
                flag=1;
                break;
            }
        }
        if(flag==0){
            System.out.println("Prime");
        }
    }

    public static void main(String[] args) {
        getPrimeNumbers(9);
    }
}
