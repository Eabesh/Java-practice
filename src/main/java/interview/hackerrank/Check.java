package interview.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class Check {
  public static void main(String[] args) {
    Check p = new Check();
    p.start();

  }

  void start() {
    boolean b1 = false;
    boolean b2 = fix(b1);
    System.out.println(b1 + " " + b2);

  }

  boolean fix(boolean b1) {
    b1 = true;
    return b1;
  }

  boolean isIsomorphic(String str1, String str2) {
    if (str1.length() != str2.length()) return false;
    else {
      Map<Character, Character> map = new HashMap<>();
      for (int i = 0; i < str1.length(); i++) {
        if (map.get(str1.charAt(i)) != null) {
          if(str2.charAt(i) != map.get(str1.charAt(i))) return false;
        }else {
          if (map.containsValue(str2.charAt(i))) return false;
          else map.put(str1.charAt(i), str2.charAt(i));
        }
      }
    }
    return true;
  }
}
