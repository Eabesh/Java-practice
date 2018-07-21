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
    int[] hist = {2, 2, 5, 4, 5, 1, 6};
    int[] hist1 = {2, 3, 4, 1};
    int x = 0;
    int i = 4;
    x = ++i + ++i + ++i;
    System.out.println(x);
    assertEquals(12, new StackExamples().maxRectangleArea(hist));
//    int[] hist2 = {5};
//    assertEquals(5, new StackExamples().maxRectangleArea(hist2));
//    assertEquals(6, new StackExamples().maxRectangleArea(hist1));
  }
  static int x;
  public static void main(String[] args) {
    String s = null;
    byte b = 50;
    boolean res = ("Welcome ".trim().intern() == "Welcome".trim());
    System.out.println(res);
    System.out.println("Hello" + args[0]);
  }


  @Test
  public void findCeleb() throws Exception {
    int[][] matrix = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}};
    assertEquals(2, new StackExamples().findCeleb(matrix));
  }

  @Test
  public void infixToPostFix() {
    String infix = "((A+B)*C)";
    System.out.println(new StackExamples().infixToPostFix(infix));
  }

  @Test
  public void postFixToInfix() {
    String postFix = "ab*c+";
    System.out.println(new StackExamples().postFixToInfix(postFix));
  }

  @Test
  public void isRedundancy() {
   String exp = "(a+b) + c";
   assertTrue(new StackExamples().isRedundancy(exp));
  }
}