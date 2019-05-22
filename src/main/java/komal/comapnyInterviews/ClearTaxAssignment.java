package komal.comapnyInterviews;

import java.io.*;
import java.util.*;

public class ClearTaxAssignment {
    public static ArrayList<Integer> list;
    public static Integer bucketSizeInt = -1;
    public static void main(String[] args) throws IOException {

        fileExtraction();
        printHistogram();

    }

    public static void fileExtraction() throws IOException {
        File file = new File("/Users/komalsingh/Downloads/inputCT2.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        list = new ArrayList();
        String stInput =  br.readLine();
        if ( stInput!= null) {
            String[] strings = stInput.split(",");
            for (String s : strings) {
                list.add(Integer.parseInt(s.trim()));
            }
            System.out.println("list is " + list);
        }
        else {
            System.out.println("Invalid input");
            return;
        }

        String bucketSize = br.readLine();
        if(bucketSize != null) {
            bucketSizeInt = Integer.parseInt(bucketSize);
            System.out.println("bucket is "+ bucketSize);
        }
        else {
            System.out.println("Invalid input");
            return;
        }

    }


    public static void printHistogram(){
        HashMap<Integer,Integer> map = new HashMap<>();

        if(list == null || bucketSizeInt == -1 )
            return;
        int bucket = 0;
        int maxNumber = Integer.MIN_VALUE;
        for(Integer integer : list){
            if(integer> maxNumber)
                maxNumber = integer;

            bucket = findBucket(integer);
            System.out.println("bucket for inc "+ integer+ " - "+bucket);

            /*Integer bucketChoose = getBucket(integer);
          //  System.out.println("bucket for "+integer+" is "+ bucketChoose);
            if(map.containsKey(bucketChoose)){
                int count = map.get(bucketChoose)+1;
                map.put(bucketChoose,count);
            }
            else map.put(bucketChoose,1);*/

        }

       /* int floor =0;
        for(int i = 1; i <= getBucket(maxNumber) ; i++ ){
            int ceilInt = i*bucketSizeInt;
            if(!map.containsKey(i))
                System.out.println(floor+" to "+ ceilInt+": "+"0");
            else
                System.out.println(floor+" to "+ ceilInt+": "+map.get(i));
            floor = ceilInt;
        }*/
    }

    private static int findBucket(Integer integer) {
        int count =0;
        while(integer!=0){
            if(integer == bucketSizeInt)
            {
             count++;
             break;
            }
            integer = integer/bucketSizeInt; // 30/10 = 3 , 3/10 = 0 count =2, 450/10 = 45, 100/10 = 10, 10/10 =1 , 1/10
            count++;
        }
        return count;
    }

    public static Integer getBucket(Integer integer) {
        if(integer%bucketSizeInt == 0)
            return integer/bucketSizeInt;

        return (integer/bucketSizeInt)+1;
    }


}
