package dynamic.programming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinJumpsTest {

    @Test
    public void minJumpTest() {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        assertEquals(3, new MinJumps().minJumps(arr));
    }

}
