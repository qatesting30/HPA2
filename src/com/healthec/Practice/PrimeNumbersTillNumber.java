package com.healthec.Practice;

public class PrimeNumbersTillNumber {

    public static void getPrimeNumbersTillNumber(int num){

        for(int i=2;i<num;i++){
            boolean isPrime=true;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    isPrime=false;
                    break;
                }

            }
            if(isPrime==true){
                System.out.print(i+" ");
            }
        }
    }

    public static void main(String[] args) {
        getPrimeNumbersTillNumber(15);
    }
}
