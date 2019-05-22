package interview.CoderPad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorQuestions {

    public static void printLargestNumber(List<String> stringsArr){

        Collections.sort(stringsArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
            String o1o2 = o1+o2;
            String o2o1 = o2+o1;
            return o1o2.compareTo(o2o1) >0 ? -1:1;
            }
        });

        System.out.println("list is "+ stringsArr);
    }

    public static void main (String[] args) {

        List<String> arr;
        arr = new ArrayList<>();

        //output should be 6054854654
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        printLargestNumber(arr);

        // output should be 777776
        /* arr.add("7");
        arr.add("776");
        arr.add("7");
        arr.add("7");
        */

        //output should be 998764543431
        /*arr.add("1");
        arr.add("34");
        arr.add("3");
        arr.add("98");
        arr.add("9");
        arr.add("76");
        arr.add("45");
        arr.add("4");
        */
    }
}

