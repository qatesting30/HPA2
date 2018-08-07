package com.healthec.Practice;

public class PrimeNumbersBetweenRange {

    public static void getPrimeNumbersBetween(int startNum,int endNum){

        for (int i = startNum;i<endNum;i++){
            int flag=0;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                System.out.print(i+ " ");

        }
    }

    public static void main(String[] args) {
        getPrimeNumbersBetween(10,100);
    }
}
