package dynamic.programming.coin.change;

import algorithms.programming.coin.change.CountWaysToScore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountWaysToScoreTest {

    @Test
    public void countTest() {
        int[] arr = {3, 5, 10};
        assertEquals(4, new CountWaysToScore().count(arr,20));
    }

}
