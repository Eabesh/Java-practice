package interview.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstOccurranceTest {

  @Test
  public void firstOccurrance() {
    assertEquals("b", new FirstOccurrance().firstOccurrance("cbaa"));
    assertEquals("c", new FirstOccurrance().firstOccurrence("cab"));
  }
}