package com.healthec.Practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestNumberInArray {

    //Using simple array
    public static int thirdLargestNumberInArray(int[]a, int total) {

        int temp;

        for(int i= 0; i<total;i++) {

            for(int j=i+1;j<total;j++) {

                if(a[i]>a[j]) {

                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

       return a[total-3];
}

public static int thirdLargestNumberInArrayUsingCollection(Integer[]a,int total) {

       List<Integer> list = Arrays.asList(a);
       Collections.sort(list);

       int element = list.get(total-3);
       return element;
    }
    public static void main(String args[]){
        int a[]={1,2,5,6,3,2};
        int b[]={44,66,99,77,33,22,55};
        Integer [] c = {44,66,99,77,33,22,55};
        System.out.println("Third Largest: "+thirdLargestNumberInArray(a,6));
        System.out.println("Third Largest: "+thirdLargestNumberInArray(b,7));
        System.out.println("Third Largest using collectin: "+thirdLargestNumberInArrayUsingCollection(c,7));
    }
}


