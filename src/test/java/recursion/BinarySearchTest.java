package recursion;

import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void searchTest() {
        Vector<Integer> elements = new Vector<Integer>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
        elements.add(5);
        assertEquals(2,(new BinarySearch()).search(elements,3,0,elements.size()));
    }

}
