package recursion;

import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class PermutationsTest {

    @Test
    public void permuteTest() {
        Permutations permutations = new Permutations();
        permutations.permute("","AB");
        Vector<String> expectedResult = new Vector<String>();
        expectedResult.add("AB");
        expectedResult.add("BA");
        assertEquals(expectedResult,permutations.permutations);
    }

}
