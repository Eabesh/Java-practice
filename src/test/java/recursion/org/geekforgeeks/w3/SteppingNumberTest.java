package recursion.org.geekforgeeks.w3;

import org.junit.Test;

import java.util.Vector;

public class SteppingNumberTest {

    @Test
    public void printNumberTest() {
        Vector<Integer> choices = new Vector<Integer>();
        choices.add(1);
        choices.add(2);
        choices.add(3);
        choices.add(4);
        choices.add(5);
        choices.add(6);
        choices.add(7);
        choices.add(8);
        choices.add(9);
        (new SteppingNumber()).printNumber(choices,"",2);
    }

}
