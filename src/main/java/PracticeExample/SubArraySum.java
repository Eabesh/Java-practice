package PracticeExample;

import java.util.*;

public class SubArraySum {

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,-1,-1,-1,-1,-1,-10,10,10,2,3,5));
        System.out.println("number of subarray "+findSubArraysCount(list,20));
    }

    private static int findSubArraysCount(List<Integer> list,int sum){

        int numOfSubArray =0;
        List<List<Integer>> indexList = new ArrayList<>();
        int longestSubarray = 0;

      //  System.out.println("here");
        if(list.size() == 1){
            if(list.get(0) == sum)
                return 1;
        }
        for(int i = 0; i< list.size(); i++){
           // System.out.println(list.get(i));
            int sumNow = list.get(i);
            List<Integer> currentSumIndex = new ArrayList<>();
            currentSumIndex.add(i);
            if(sumNow == sum){
                currentSumIndex.add(i);
                numOfSubArray++;
                indexList.add(currentSumIndex);
                continue;
            }
            for(int j = i+1; j < list.size(); j++){
             //   System.out.println(list.get(j));
                sumNow += list.get(j);
                if(sumNow == sum){
                    System.out.println("index of arrays "+i +" to "+j);
                    currentSumIndex.add(j);
                    indexList.add(currentSumIndex);
                    numOfSubArray+=1;
                    break;
                }
            }
        }
        System.out.println("list is "+ indexList);

        for(List<Integer> list1 : indexList){
            int tempSub = (list1.get(1) - list1.get(0)) + 1;
            if(tempSub > longestSubarray) {
                System.out.println("index for longest subarray = "+list1);
                longestSubarray = tempSub;
            }
        }
        return longestSubarray;
    }

    public static int subArrayCount(List<Integer> list,int sum){
        Map<Integer,Integer> map = new HashMap<>();

       // for()

        return 0;
    }
}
