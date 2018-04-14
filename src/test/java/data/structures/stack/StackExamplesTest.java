package data.structures.stack;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class StackExamplesTest {

  @Test
  public void specialStack() {
    StackExamples.SpecialStack specialStack = new StackExamples().new SpecialStack();
    specialStack.push(10);
    specialStack.push(20);
    specialStack.push(30);
    System.out.println("Min = " + specialStack.getMin());
    specialStack.push(5);
    System.out.println("Min = " + specialStack.getMin());
    System.out.println("Pop = " + specialStack.pop());
    System.out.println("Min = " + specialStack.getMin());
    System.out.println("Pop = " + specialStack.pop());

    System.out.println("Min = " + specialStack.getMin());
    System.out.println("Pop = " + specialStack.pop());
  }
  @Test
  public void evaluateExpression() throws Exception {
    assertEquals(110, new StackExamples().evaluateExpression("12 + 5 - 7 + 100"));
    assertEquals(12, new StackExamples().evaluateExpression("( 10 + 2 )"));
    assertEquals(5, new StackExamples().evaluateExpression("( 10 / 2 )"));
  }

  @Test
  public void maxRectangleArea() throws Exception {
    int[] hist = {6, 2, 5, 4, 5, 1, 6};
    assertEquals(12, new StackExamples().maxRectangleArea(hist));
    int[] hist2 = {5};
    assertEquals(5, new StackExamples().maxRectangleArea(hist2));
  }

  @Test
  public void findCeleb() throws Exception {
    int[][] matrix = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}};
    assertEquals(2, new StackExamples().findCeleb(matrix));
  }

}