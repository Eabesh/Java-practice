package interview.hackerrank;

import java.util.*;

public class Example {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t > 0) {
      String str = in.nextLine();
      int k = in.nextInt();
      int[] frequency = getFrequency(str);
      TreeMap<Integer, ArrayList<Character>> map = new TreeMap<>();
      for (int i = 0; i < frequency.length; i++) {
        if (frequency[i] > 0) {
          if (map.get(frequency[i]) != null) {
            ArrayList<Character> list = map.get(frequency[i]);
            char c = (char)(i + 97);
            list.add(c);
            map.put(frequency[i], list);
          }else {
            ArrayList<Character> list = new ArrayList<>();
            char c = (char)(i + 97);
            list.add(c);
            map.put(frequency[i], list);
          }
        }
        int n = map.size() - k;
        if (map.size() > k) System.out.println(-1);
        else {
          for (Map.Entry<Integer, ArrayList<Character>> entry: map.entrySet()){
            if (--n == 0) System.out.println(entry.getValue().get(0));
          }
        }
      }

      t--;
    }


  }

  static int[] getFrequency(String str) {
    int[] frequency = new int[26];
    for (char c : str.toCharArray()) {
      frequency[c - 97]++;
    }
    return frequency;
  }



}
