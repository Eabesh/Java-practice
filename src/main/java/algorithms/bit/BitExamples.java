package algorithms.bit;

public class BitExamples {

  /**
   * 1.
   * Problem: Smallest power of 2 greater than or equal to n.
   */
  int getNextPowerOf2(int n) {
    int power = 1;
    if (exactPowerOf2(n)) return n;
    else while (power < n) power <<= 1;
    return power;
  }

  private boolean exactPowerOf2(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }

  /**
   * 2.
   * Problem:
   * Solution:
   */

  /**
   * 1.
   * Problem:
   * Solution:
   */

  /**
   * 1.
   * Problem:
   * Solution:
   */

  /**
   * 1.
   * Problem:
   * Solution:
   */

  /**
   * 1.
   * Problem:
   * Solution:
   */

  /**
   * 1.
   * Problem:
   * Solution:
   */

  /**
   * 1.
   * Problem:
   * Solution:
   */

  /**
   * 1.
   * Problem:
   * Solution:
   */

  /**
   * 1.
   * Problem:
   * Solution:
   */

  /**
   * 1.
   * Problem:
   * Solution:
   */


}
