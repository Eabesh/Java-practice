package data.structures.hashing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HashingExamplesTest {

  @Test
  public void anagrams() {
    List<String> list = new ArrayList<>();
    list.add("cat");
    list.add("dog");
    list.add("god");
    list.add("tca");
    ArrayList<ArrayList<Integer>> result = new HashingExamples().anagrams(list);
    result.forEach(l -> System.out.println(l));
  }

  @Test
  public void maxLen() {
    int arr[] = {0, 2, -2};
    System.out.println(new HashingExamples().maxLen(arr));

  }
}