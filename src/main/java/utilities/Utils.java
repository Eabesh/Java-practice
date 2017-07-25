package utilities;

import java.util.Arrays;

public class Utils {

  public static int max(int arg, int... args) {
    return Arrays.stream(args).max().orElse(arg);
  }

}
