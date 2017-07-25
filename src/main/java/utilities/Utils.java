package utilities;

import java.util.Arrays;

public class Utils {

  public static int max(int... args) {
    return Arrays.stream(args).max().orElse(args[0]);
  }

}
