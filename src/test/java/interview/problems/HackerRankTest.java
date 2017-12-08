package interview.problems;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by abhay on 07/12/17.
 */
public class HackerRankTest {
  @Test
  public void commercialPlacement() throws Exception {
    int[] addCost = {60, 100, 120};
    int[] addDuration = {10, 20, 30};
    double t1 = System.currentTimeMillis();
    assertEquals(220, new HackerRank().commercialPlacement(50, addDuration, addCost, addDuration.length));
        double t2 = System.currentTimeMillis();
    System.out.println("time taken in secs : " + (t2 - t1)/1000);
//    assertEquals(220, new HackerRank().commercialPlacementDP(50, addDuration, addCost, addDuration.length));
//
  }

  @Test
  public void commercialPlacementDP() throws Exception {
  }

//  void calculateTime(int n) {
//    double t1 = System.currentTimeMillis();
//    System.out.println(new HackerRank().commercialPlacement());
//    double t2 = System.currentTimeMillis();
//    System.out.println("time taken in secs : " + (t2 - t1)/1000);
//  }

}