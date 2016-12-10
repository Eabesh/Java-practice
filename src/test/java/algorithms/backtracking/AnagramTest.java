package algorithms.backtracking;

import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class AnagramTest {

    @Test
    public void isAnagramTest() {
        Vector<String> dictionary = new Vector<String>();
        dictionary.add("hello");
        dictionary.add("bye");
        dictionary.add("go");
        assertEquals(true,(new Anagram()).isAnagram("","og",dictionary));
    }

}
