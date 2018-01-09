package data.structures.stack;

import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StackExamples {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 50; i++) {

      executorService.execute(new Runnable() {
        @Override
        public void run() {
          System.out.println("Thread id is " + Thread.currentThread().getId() );
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      });

    }
    executorService.shutdown();
  }

  /**
   * 1.
   * Problem: Implement Queue using Stacks
   */
  class MyQueue{

    Stack<Integer> stack1, stack2;

    public MyQueue() {
      stack1 = new Stack<>();
      stack2 = new Stack<>();
    }

    void push(int x) {
      stack1.push(x);
    }



    int pop() {
      reverseStack(stack1, stack2);
      int front =  stack2.pop();
      reverseStack(stack2, stack1);
      return front;
    }

    int peek() {
      reverseStack(stack1, stack2);
      int front =  stack2.peek();
      reverseStack(stack2, stack1);
      return front;
    }


    boolean empty() {
      return stack1.isEmpty();
    }


    private void reverseStack(Stack<Integer> stack1, Stack<Integer> stack2) {
      while (!stack1.isEmpty()) stack2.push(stack1.pop());
    }
  }

  /**
   * 2.
   * Problem: Check for balanced parentheses in an expression
   */


  /**
   * 3.
   * Problem: Reverse a stack using recursion
   */


  /**
   * 4.
   * Problem: Next Greater Element
   */


  /**
   * 5.
   * Problem: Spaghetti Stack
   */


  /**
   * 6.
   * Problem: Design and Implement Special Stack Data Structure | Added Space Optimized Version
   */

  /**
   * 7.
   * Problem: Implement two stacks in an array
   */


  /**
   * 8.
   * Problem: The Celebrity Problem
   * In a party of N people, only one person is known to everyone. Such a person may be present in the party,
   * if yes, (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “.
   * Find the stranger (celebrity) in minimum number of questions.
   * Solution: The idea is to use two pointers, one from start and one from the end. Assume the start person is A,
   * and the end person is B. If A knows B, then A must not be the celebrity. Else, B must not be the celebrity.
   * We will find a celebrity candidate at the end of the loop. Go through each person again and check whether
   * this is the celebrity.
   */
  int findCeleb(int[][] matrix) {
    int a = 0;
    int b = matrix.length - 1;
    while (a < b) {
      if (knows(matrix,a,b)) a++;
      else b--;
    }
    for (int i = 0; i < matrix.length; i++) {
      if (i != a)
        if (knows(matrix,a,i) || !knows(matrix,i,a)) return -1;
    }
    return a;
  }

  private boolean knows(int[][] m, int a, int b) { return m[a][b] == 1 ;}

  /**
   * 9.
   * Problem: Implement Stack using Queues
   */


  /**
   * 10.
   * Problem: The Stock Span Problem
   */





  /**
   * 11.
   * Problem: Iterative Postorder Traversal | Set 1 (Using Two Stacks)
   */

  /**
   * 12.
   * Problem: Iterative Postorder Traversal | Set 2 (Using One Stack)
   */


  /**
   * 13.
   * Problem: Merge Overlapping Intervals
   */


  /**
   * 14.
   * Problem: Stack | Set 2 (Infix to Postfix)
   */


  /**
   * 15.
   * Problem: Largest Rectangular Area in a Histogram | Set 2
   * Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number
   * of contiguous bars. For simplicity, assume that all bars have same width and the width is 1 unit.
   * For example, consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 1, 6}. The largest possible
   * rectangle possible is 12.
   */
  public int maxRectangleArea(int[] array) {
    Stack<Integer> indexStack = new Stack<>();
    int currIndex = 0, maxArea = -1;
    while (currIndex < array.length) {
      if (indexStack.isEmpty() || array[indexStack.peek()] <= array[currIndex]) indexStack.push(currIndex++);
      else maxArea = Math.max(calculateArea(array, indexStack, currIndex), maxArea);
    }
    while (!indexStack.isEmpty()) maxArea = Math.max(calculateArea(array, indexStack, currIndex), maxArea);
    return maxArea;
  }

  private int calculateArea(int[] array, Stack<Integer> integerStack, int currIndex) {
    int topIndex = integerStack.pop();
    if (integerStack.isEmpty()) return array[topIndex] * currIndex;
    else return array[topIndex] * (currIndex - 1 - integerStack.peek());
  }

  /**
   * 16.
   * Problem: Expression Evaluation
   */

  /**
   * 17.
   * Problem: Design a stack with operations on middle element
   */


  /**
   * 18.
   * Problem: Print ancestors of a given binary tree node without recursion
   */


  /**
   * 19.
   * Problem: Stack | Set 3 (Reverse a string using stack)
   */


  /**
   * 20.
   * Problem: C Program for Tower of Hanoi
   */


  /**
   * 21.
   * Problem: Stack | Set 4 (Evaluation of Postfix Expression)
   */

  /**
   * 22.
   * Problem: How to efficiently implement k stacks in a single array?
   */


  /**
   * 23.
   * Problem: How to create mergable stack?
   */


  /**
   * 24.
   * Problem: Find maximum depth of nested parenthesis in a string
   */


  /**
   * 25.
   * Problem: Iterative Tower of Hanoi
   */



  /**
   * 26.
   * Problem: Find maximum of minimum for every window size in a given array
   */

  /**
   * 27.
   * Problem: Length of the longest valid substring
   */


  /**
   * 28.
   * Problem: Sort a stack using recursion
   */


  /**
   * 29.
   * Problem: Iterative Depth First Traversal of Graph
   */


  /**
   * 30.
   * Problem: Minimum number of bracket reversals needed to make an expression balanced
   */

  /**
   * 31.
   * Problem: Check if a given array can represent Preorder Traversal of Binary Search Tree
   */



  /**
   * 32.
   * Problem: Form minimum number from given sequence
   */

  /**
   * 33.
   * Problem: Stack Class in Java
   */


  /**
   * 34.
   * Problem: Design a stack that supports getMin() in O(1) time and O(1) extra space
   */


  /**
   * 35.
   * Problem: Implement a stack using single queue
   */


  /**
   * 36.
   * Problem: Find if an expression has duplicate parenthesis or not
   */


  /**
   * 37.
   * Problem: Find maximum difference between nearest left and right smaller elements
   */



  /**
   * 38.
   * Problem: Find next Smaller of next Greater in an array
   */

  /**
   * 39.
   * Problem: Find maximum sum possible equal sum of three stacks
   */


  /**
   * 40.
   * Problem: Count natural numbers whose all permutation are greater than that number
   */


  /**
   * 41.
   * Problem: Stack Data Structure (Introduction and Program)
   */


  /**
   * 42.
   * Problem: How to implement stack using priority queue or heap?
   */
  /**
   * 43.
   * Problem: Delete consecutive same words in a sequence
   */

  /**
   * 44.
   * Problem: Decode a string recursively encoded as count followed by substring
   */
  /**
   * 45.
   * Problem: Bubble sort using two Stacks
   */


}
