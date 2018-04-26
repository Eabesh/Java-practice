package data.structures.stack;

import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StackExamples {


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
   * 1.
   * Problem: Implement Queue using Stacks.
   * Solution:
   */

  class MyQueue{

    Stack<Integer> stack1, stack2;

    public MyQueue() {
      stack1 = new Stack<>();
      stack2 = new Stack<>();
    }

    void enque(int x) {
      stack1.push(x);
    }

    int deque() {
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
   * Problem: Check for balanced parentheses in an expression.
   * Solution:
   */

  /**
   * 3.
   * Problem: Reverse a stack using recursion.
   * Solution:
   */

  /**
   * 4.
   * Problem: Next Greater Element.
   * Solution:
   */

  /**
   * 5.
   * Problem: Spaghetti Stack.
   * Solution:
   */

  /**
   * 6.
   * Problem: Design and Implement Special Stack Data Structure | Added Space Optimized Version.
   * Solution:[Adobe]
   * Use two stacks: one to store actual stack elements and other as an auxiliary stack to
   * store minimum values. The idea is to do push() and pop() operations in such a way that the
   * top of auxiliary stack is always the minimum.
   */
  class SpecialStack {
    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> stack = new Stack<>();

    void push(int ele) {
      if (stack.isEmpty()) {
        stack.push(ele);
        minStack.push(ele);
      } else {
        stack.push(ele);
        if (minStack.peek() >= ele) minStack.push(ele);
      }
    }

    int pop() {
      int x = stack.pop();
      if (minStack.peek() == x) minStack.pop();
      return x;
    }

    int getMin() {
      return minStack.peek();
    }
  }



  /**
   * 7.
   * Problem: Implement two stacks in an array.
   * Solution:
   */

  /**
   * 8.
   * Problem: The Celebrity Problem.
   * Solution:
   */

  /**
   * 9.
   * Problem: Implement Stack using Queues.
   * Solution:
   */

  /**
   * 10.
   * Problem: The Stock Span Problem.
   * Solution:
   */

  /**
   * 11.
   * Problem: Iterative Postorder Traversal | Set 1 (Using Two Stacks).
   * Solution:
   */

  /**
   * 12.
   * Problem: Iterative Postorder Traversal | Set 2 (Using One Stack).
   * Solution:
   */

  /**
   * 13.
   * Problem: Merge Overlapping Intervals.
   * Solution:
   */

  /**
   * 14.
   * Problem: Stack | Set 2 (Infix to Postfix).
   * Solution:
   */


  /**
   * 15.
   * Problem: Largest Rectangular Area in a Histogram | Set 2
   * Find the largest rectangular area possible in a given histogram where the largest rectangle can
   * be made of a number of contiguous bars. For simplicity, assume that all bars have same width
   * and the width is 1 unit.
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

  private int calculateArea(int[] array, Stack<Integer> indexStack, int currIndex) {
    int topIndex = indexStack.pop();
    if (indexStack.isEmpty()) return array[topIndex] * currIndex;
    else return array[topIndex] * (currIndex  - (indexStack.peek() + 1));
  }

  /**
   * 16.
   * Problem: Expression Evaluation.
   */
  int evaluateExpression(String exp) {
    Stack<Integer> stackForOperands = new Stack<>();
    Stack<Character> stackForOperators = new Stack<>();
    String[] tokens = exp.split("\\s+");
    for (String token : tokens) {
      if(token.matches("-?\\d+")) stackForOperands.push(Integer.parseInt(token));
      else if ("(".equals(token)) stackForOperators.push(token.charAt(0));
      else if (")".equals(token)) {
        while (stackForOperators.peek() != '(') oneOperatorProcess(stackForOperands, stackForOperators);
        stackForOperators.pop();
      }
      else if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
        while (!stackForOperators.isEmpty() && findPrecedence(token.charAt(0), stackForOperators.peek())) oneOperatorProcess(stackForOperands, stackForOperators);
        stackForOperators.push(token.charAt(0));
      }
    }

    while (!stackForOperators.isEmpty()) oneOperatorProcess(stackForOperands, stackForOperators);
    return stackForOperands.pop();
  }

  private  boolean findPrecedence(char op1, char op2)
  {
    if (op2 == '(' || op2 == ')') return false;
    else if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
    else return true;
  }

  private void oneOperatorProcess(Stack<Integer> stackForOperands, Stack<Character> stackForOperators) {
    char operator = stackForOperators.pop();
    int b = stackForOperands.pop();
    int a = stackForOperands.pop();
    int result = 0;
    switch (operator) {
      case '+':
        result = a + b;
        break;
      case '-':
        result = a - b;
        break;

      case '*':
        result = a * b;
        break;

      case '/':
        result = a / b;
        break;
    }
    stackForOperands.push(result);
  }

  /**
   * 17.
   * Problem: Design a stack with operations on middle element.
   * Solution:
   */

  /**
   * 18.
   * Problem: Print ancestors of a given binary tree node without recursion.
   * Solution:
   */

  /**
   * 19.
   * Problem: Stack | Set 3 (Reverse a string using stack).
   * Solution:
   */

  /**
   * 20.
   * Problem: Program for Tower of Hanoi.
   * Solution:
   */

  /**
   * 21.
   * Problem: Stack | Set 4 (Evaluation of Postfix Expression).
   * Solution:
   */

  /**
   * 22.
   * Problem: How to efficiently implement k stacks in a single array?.
   * Solution:
   */

  /**
   * 23.
   * Problem: How to create mergable stack?.
   * Solution:
   */

  /**
   * 24.
   * Problem: Find maximum depth of nested parenthesis in a string.
   * Solution:
   */

  /**
   * 25.
   * Problem: Iterative Tower of Hanoi.
   * Solution:
   */

  /**
   * 26.
   * Problem: Find maximum of minimum for every window size in a given array.
   * Solution:
   */

  /**
   * 27.
   * Problem: Length of the longest valid substring.
   * Solution:
   */

  /**
   * 28.
   * Problem: Sort a stack using recursion.
   * Solution:
   */

  /**
   * 29.
   * Problem: Iterative Depth First Traversal of Graph.
   * Solution:
   */

  /**
   * 30.
   * Problem: Minimum number of bracket reversals needed to make an expression balanced.
   * Solution:
   */

  /**
   * 31.
   * Problem: Check if a given array can represent Preorder Traversal of Binary Search Tree.
   * Solution:
   */

  /**
   * 32.
   * Problem: Form minimum number from given sequence.
   * Solution:
   */

  /**
   * 33.
   * Problem: Stack Class in Java.
   * Solution:
   */

  /**
   * 34.
   * Problem: Design a stack that supports getMin() in O(1) time and O(1) extra space.
   * Solution:
   */



  /**
   * 35.
   * Problem: Implement a stack using single queue.
   * Solution:
   */

  /**
   * 36.
   * Problem: Find if an expression has duplicate parenthesis or not.
   * Solution:
   */

  /**
   * 37.
   * Problem: Find maximum difference between nearest left and right smaller elements.
   * Solution:
   */

  /**
   * 38.
   * Problem: Find next Smaller of next Greater in an array.
   * Solution:
   */

  /**
   * 39.
   * Problem: Find maximum sum possible equal sum of three stacks.
   * Solution:
   */

  /**
   * 40.
   * Problem: Count natural numbers whose all permutation are greater than that number.
   * Solution:
   */

  /**
   * 41.
   * Problem: Stack Data Structure (Introduction and Program).
   * Solution:
   */

  /**
   * 42.
   * Problem: How to implement stack using priority queue or heap?.
   * Solution:
   */

  /**
   * 43.
   * Problem: Delete consecutive same words in a sequence.
   * Solution:
   */

  /**
   * 44.
   * Problem: Decode a string recursively encoded as count followed by substring.
   * Solution:
   */

  /**
   * 45.
   * Problem: Bubble sort using two Stacks.
   * Solution:
   */

  /**
   * 46.
   * Problem: Pattern Occurrences : Stack Implementation Java.
   * Solution:
   */

  /**
   * 47.
   * Problem: Sort a stack using a temporary stack.
   * Solution:
   */

  /**
   * 48.
   * Problem: Create a customized data structure which evaluates functions in O(1).
   * Solution:
   */

  /**
   * 49.
   * Problem: Iterative method to find ancestors of a given binary tree.
   * Solution:
   */

  /**
   * 50.
   * Problem: Stack Permutations (Check if an array is stack permutation of other).
   * Solution:
   */

  /**
   * 51.
   * Problem: Tracking current Maximum Element in a Stack.
   * Solution:
   */

  /**
   * 52.
   * Problem: Check mirror in n-ary tree.
   * Solution:
   */

  /**
   * 53.
   * Problem: Reverse a number using stack.
   * Solution:
   */

  /**
   * 54.
   * Problem: Reversing the first K elements of a Queue.
   * Solution:
   */

  /**
   * 55.
   * Problem: Reversing a Queue.
   * Solution:
   */

  /**
   * 56.
   * Problem: Check  if stack elements are pairwise consecutive.
   * Solution:
   */

  /**
   * 57.
   * Problem: Interleave the first half of the queue with second half.
   * Solution:
   */

  /**
   * 58.
   * Problem: Remove brackets from an algebraic string containing + and &#8211; operators.
   * Solution:
   */

  /**
   * 59.
   * Problem: Reverse a stack without using extra space in O(n).
   * Solution:
   */

  /**
   * 60.
   * Problem: Print next greater number of Q queries.
   * Solution:
   */

  /**
   * 61.
   * Problem: Simplify the directory path (Unix like).
   * Solution:
   */

  /**
   * 62.
   * Problem: Next Greater Frequency Element.
   * Solution:
   */

  /**
   * 63.
   * Problem: Number of NGEs to the right.
   * Solution:
   */

  /**
   * 64.
   * Problem: Construct Binary Tree from String with bracket representation.
   * Solution:
   */

  /**
   * 65.
   * Problem: Check if two expressions with brackets are same.
   * Solution:
   */

  /**
   * 66.
   * Problem: Find index of closing bracket for a given opening bracket in an expression.
   * Solution:
   */

  /**
   * 67.
   * Problem: Identify and mark unmatched parenthesis in an expression.
   * Solution:
   */

  /**
   * 68.
   * Problem: Count subarrays where second highest lie before highest.
   * Solution:
   */

  /**
   * 69.
   * Problem: ZigZag Tree Traversal.
   * Solution:
   */

  /**
   * 70.
   * Problem: Convert Infix To Prefix Notation.
   * Solution:
   */

  /**
   * 71.
   * Problem: Print Reverse a linked list using Stack

   * Solution:
   */

  /**
   * 72.
   * Problem: Evaluation of Prefix Expressions

   * Solution:
   */

  /**
   * 73.
   * Problem: Check if an array is stack sortable

   * Solution:
   */

  /**
   * 74.
   * Problem: Growable array based stack

   * Solution:
   */


  /**
   * 75.
   * Problem: Implement Stack and Queue using Deque

   * Solution:
   */


  /**
   * 76.
   * Problem: Reverse individual words

   * Solution:
   */

  /**
   * 77.
   * Problem: Stack and Queue in Python using queue Module

   * Solution:
   */

  /**
   * 78.
   * Problem: Alternate Odd and Even Nodes in a Singly Linked List

   * Solution:
   */

  /**
   * 79.
   * Problem: Expression contains redundant bracket or not

   * Solution:
   */

  /**
   * 80.
   * Problem: Modify a binary tree to get preorder traversal using right pointers only

   * Solution:
   */


  /**
   * 81.
   * Problem: Postfix to Infix
   * Solution:
   */

  /**
   * 82.
   * Problem: Postfix to Prefix Conversion
   * Solution:
   */

  /**
   * 83.
   * Problem: Prefix to Postfix Conversion
   * Solution:
   */

  /**
   * 84.
   * Problem: Prefix to Infix Conversion

   * Solution:
   */

  /**
   * 85.
   * Problem: Print Bracket Number
   * Solution:
   */



}
