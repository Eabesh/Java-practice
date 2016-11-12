package dynamic.programming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditDistanceTest {

    @Test
    public void editTest() {
        String s1 = "AB";
        String s2 = "AC";
        assertEquals(1,new EditDistance().edit(s1,s2));
    }

    @Test
    public void editTest2() {
        String s1 = "sunday";
        String s2 = "saturday";
        assertEquals(3,new EditDistance().edit(s1,s2));
    }

}
