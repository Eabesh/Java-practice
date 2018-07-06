package interview.hackerearth;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Largest {

  int largestNumber(String str) {
    str = str.replaceAll("[^-?0-9]+", " ");
    List<String> list = Arrays.asList(str.trim().split(" "));
    int result =  list.stream().mapToInt(Integer::parseInt).max().getAsInt();
    System.out.println(result);
    return result;
  }



}
