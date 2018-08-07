package com.healthec.Practice;

public class PrintingPyramids {

    public static void printTriagle(int n) {
        // number of spaces
        int k = 2*n - 2;

        // outer loop to handle number of rows
        //  n in this case
        for (int i=0; i<n; i++)
        {

            // inner loop to handle number spaces
            // values changing acc. to requirement
            for (int j=0; j<k; j++)
            {
                // printing spaces
                System.out.print(" ");
            }

            // decrementing k after each loop
            k = k - 2;

            //  inner loop to handle number of columns
            //  values changing acc. to outer loop
            for (int j=0; j<=i; j++ )
            {
                // printing stars
                System.out.print("* ");
            }

            // ending line after each row
            System.out.println();
        }
    }

    public static void printNumberLeftTriangle(int n){
        int i,j,num=n,k=2*n-1;

        for(i=0;i<n;i++){
            for(j=0;j<k;j++){
                System.out.print(" ");
                }
                k=k-1;
            for(j=0;j<=i;j++){
                System.out.print("* ");
               // num=num-1;

            }
            System.out.println();
        }
    }




    public static void main(String[] args) {


        printNumberLeftTriangle(5);
    }
}
