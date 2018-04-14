package interview.hackerrank;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstOccurrance {

  String firstOccurrance(String str) {
    int[] freq  = new int[26];
    for (Character ch : str.toCharArray()) freq[ch - 'a']++;
    for (int i = 0; i < freq.length; i++) if (freq[i] == 1) return String.valueOf((char)(i + 'a'));
    return null;
  }

  String firstOccurrence(String str) {
    Map<Character, Integer> map = new LinkedHashMap<>();
    for (Character ch : str.toCharArray()) {
      if (map.containsKey(ch))  map.put(ch, map.get(ch)  + 1);
      else map.put(ch, 1);
    }
    for (Character key : map.keySet()) if (map.get(key) == 1) return String.valueOf(key);
    return null;

  }
}
