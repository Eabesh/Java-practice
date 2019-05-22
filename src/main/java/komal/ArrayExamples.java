package komal;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayExamples {

    /*Equilibrium point in an array*/

    public static void testEquilibrium(){
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println("First equilibrium index is " +
                findEquilibriumInArray(arr));
    }
    public static int findEquilibriumInArray(int[] arr){
        int size = arr.length;
        int rightSum = 0;
        for(int i =0 ; i<size;i++)
            rightSum+=arr[i];

        int leftSum =0 ;
        for(int i = 0 ; i< size; i++)
        {
            rightSum -= arr[i];

            if(rightSum == leftSum)
                return i;

            leftSum+= arr[i];

        }
        return -1;
    }


    /*max sum contiguous subarray - kadanes*/

    public static void maxSumTest(){
        int [] a = {-2, -3, -4, 1, -2, -1, -5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSum(a));
    }
    public static int maxSum(int[] arr){
        int max_sum_result = Integer.MIN_VALUE;
        int sum_till_here = 0;
        int size = arr.length;
        for(int i =0 ; i< size; i++){
            sum_till_here+=arr[i];
            if(max_sum_result< sum_till_here)
                max_sum_result = sum_till_here;
            if(sum_till_here<0)
                sum_till_here = 0;
        }
        return max_sum_result;
    }

    /*longest increasing subseq*/

    public static void testLis(){
        int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        System.out.println("Length of Longest Increasing Subsequence is " + longestIncreasingSubseq(A));
    }
    public static int longestIncreasingSubseq(int[] arr){
        int size = arr.length;
        int[] lis = new int[size];
        for(int i =0 ; i< size ;i++){
            lis[i] =1;
        }

        int max =0;
        for(int i =1; i<size; i++){
            for(int j=0; j<=i-1;j++){
                if(arr[j]< arr[i] && lis[j]+1 > lis[i])
                    lis[i] = lis[j]+1;
                if(max<lis[i])
                    max = lis[i];
            }
        }

    return max;
    }

    public static void main(String[] args)
    {
        //maxSumTest();
        testLis();

    }

}
