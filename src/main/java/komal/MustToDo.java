package komal;

import java.util.HashMap;

public class MustToDo {
    /*sub array with sum k*/
    public static void subArrayWithSum(int[] arr,int sum){
        int curr_sum = 0;
        HashMap<Integer,Integer> sumHash = new HashMap<>();

        for(int i = 0 ; i< arr.length; i++){
            curr_sum += arr[i];

            if(curr_sum == sum){
                System.out.println("array from index 0 to "+ i);
                break;
            }

            else {
            }

        }

    }
}
