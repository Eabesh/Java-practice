package recursion;

import utilities.ListNode;
import utilities.Stack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RecursionExamples {

  /**
   * Julie Zelenski's lecture @ Stanford.
   */

  /**
   * 1.
   * Problem: Exponent of a number
   * Solution: base*base^(exp - 1)
   */
  int getExponent(int base, int exp) {
    if (exp == 0) return 1;
    else return base * getExponent(base, exp - 1);
  }

  /**
   * More efficient.
   */
  int getExponentEfficient(int base, int exp) {
    if (exp == 0) return 1;
    else {
      int half = getExponentEfficient(base, exp / 2);
      if (exp % 2 == 0) return half * half;
      else return base * half * half;
    }
  }

  /**
   * 2.
   * Problem: Given a string, check whether palindrome or not.
   */
  public boolean isPalindrome(String str) {
    return (str.length() <=1) || str.charAt(0) == str.charAt(str.length() - 1)
            && isPalindrome(str.substring(1, str.length() - 1));
  }

  /**
   * 3.
   * Problem: BinarySearch
   */
  int binarySearch(int[] array, int startIndex, int endIndex, int value) {
    if (startIndex <= endIndex) {
      int midIndex = startIndex + (endIndex - startIndex) / 2;
      if (value == array[midIndex]) return midIndex;
      else if (value < array[midIndex]) return binarySearch(array, startIndex, midIndex - 1, value);
      else return binarySearch(array, midIndex + 1, endIndex, value);
    } else return -1;
  }

  /**
   * 4.
   * Problem: Combination
   */
  int combination(int n, int k) {
    if (n == k || k == 0) return 1;
    else return combination(n - 1, k) + combination(n - 1, k - 1);
  }

  /**
   * 5.
   * Problem: Tower of Hanoi
   */
  void towerOfHanoi(int disk, String source, String dest, String temp){
    if (disk > 0) {
      towerOfHanoi(disk - 1, source, temp, dest);
      System.out.println(source + " -> " + dest);
      towerOfHanoi(disk - 1, temp, dest, source);
    }
  }

  /**
   * 6.
   * Problem: Permutations of a string
   */
 public void printPermutations(String soFar, String remaining) {
    if (remaining.isEmpty()) System.out.println(soFar);
    else {
      for (int i = 0; i < remaining.length(); i++)
        printPermutations(soFar + remaining.charAt(i),
                remaining.substring(0, i) + remaining.substring(i + 1));
    }
  }

  /**
   * 7.
   * Problem: Subset of String.
   */
  void printSubsets(String soFar, String remaining) {
    if (remaining.isEmpty()) System.out.println(soFar);
    else {
      printSubsets(soFar + remaining.charAt(0), remaining.substring(1));
      printSubsets(soFar, remaining.substring(1));
    }
  }

  /**
   * 8.
   * Problem: AnagramFinder
   * Solution: Use backtracking
   *  boolean solve(configuration conf) {
   *    // BASE CASE
   *    if (no more choices)
   *      return (conf is in goal state);
   *    else {
   *      for (choice : choices) {
   *        try one choice c;
   *        // solve from here, if work out, you are done
   *        if (solve(conf with choice c made) return true;
   *        unmake choice c;
   *      }
   *      return false;  // tried all choices, no solution found.
   *    }
   *  }
   */
  boolean isAnagram(String soFar, String remaining, HashSet<String> dictionary) {
    if (remaining.isEmpty()) return dictionary.contains(soFar);
    else {
      for (int i = 0; i < remaining.length(); i++) {
        if (isAnagram(soFar + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), dictionary))
          return true;
      }
    }
    return false;
  }

  /**
   * 9.
   * Problem: N Queens Problems
   */
  public void placeQueen(int[][] board, int row, int column) {
    board[row][column] = 1;
  }

  public void removeQueen(int[][] board, int row, int column) {
    board[row][column] = 0;
  }

  public boolean isSafe(int[][] board, int row, int column) {
    for (int c = column; c >= 0 ; c--) if (board[row][c] == 1) return false;
    for (int r = row, c = column; r >= 0 && c >=0; r--, c--) if (board[r][c] == 1) return false;
    for (int r = row, c = column; r < board.length && c >= 0; r++, c--) if(board[r][c] == 1) return false;
    return true;
  }

  public boolean solveNQueen(int[][] board, int column) {
    if (column >= board[0].length) return true;
    else {
      for (int row = 0; row < board.length; row++) {
        if (isSafe(board, row, column)) {
          placeQueen(board, row, column);
          if (solveNQueen(board, column + 1)) return true;
          removeQueen(board, row, column);
        }
      }
    }
    return false;
  }

  /**
   * Problems from Geeksforgeeks.
   */


  /**
   * 1.
   * Reverse a linked list using recursion.
   */
  ListNode reverseList(ListNode current) {
    if (current == null || current.next == null) return current;
    else {
      ListNode head = reverseList(current.next);
      current.next.next = current;
      current.next = null;
      return head;
    }
  }

  /**
   * 2.
   * Problem: Reverse a stack using recursion. Or reverse a stack without using any other data structure or
   * auxiliary space.
   */
  void reverseStack(Stack stack) {
    if(!stack.isEmpty()) {
      int top = stack.pop();
      reverseStack(stack);
      insertAtBottom(stack,top);
    }
  }

  private void insertAtBottom(Stack stack, int elem) {
    if (stack.isEmpty())
      stack.push(elem);
    else {
      int top = stack.pop();
      insertAtBottom(stack,elem);
      stack.push(top);
    }
  }

  /**
   * 3.
   * Problem: Check if a number is Palindrome
   * Given an integer, write a function that returns true if the given number is palindrome, else false.
   * For example, 12321 is palindrome, but 1451 is not palindrome.
   */
  boolean isPalindromeNumber(int num, int numCopy, int reverse) {
    if (numCopy == 0) return num == reverse;
    return isPalindromeNumber(num, numCopy / 10, reverse * 10  + numCopy % 10);
  }

  /**
   * 4.
   * Problem: Print all possible combinations of r elements in a given array of size n.
   * For example, if input array is {1, 2, 3, 4} and r is 2, then output should be {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and
   * {3,4}.
   */
  void printCombinationOfArray(int[] array, String soFar, int r, int beginIndex) {
    if (r == 0) System.out.println("{" + soFar.substring(0, soFar.length() - 2) + "}");
    else
      for (int i = beginIndex; i < array.length; i++)
        printCombinationOfArray(array, soFar + array[i] + ", ", r - 1, i + 1);
  }

  /**
   * 5.
   * Problem: Print all possible strings of length k that can be formed from a set of n characters
   */
  void printKLengthString(char[] array, int length, String soFar) {
    if (length == 0) System.out.println(soFar);
    else {
        for (char ch : array)
        printKLengthString(array, length - 1, soFar + ch);
    }
  }

  /**
   * 6.
   * Problem: Tail Recursion
   * Solution: A recursive function is tail recursive when recursive call is the last thing executed by the function.
   * Why do we care?
   * The tail recursive functions considered better than non tail recursive functions as tail-recursion can be optimized
   * by compiler. The idea used by compilers to optimize tail-recursive functions is simple, since the recursive call is
   * the last statement, there is nothing left to do in the current function, so saving the current function’s stack
   * frame is of no use.
   */
  int factorial(int num) {
    if (num == 0) return 1;
    else return num * factorial(num - 1);
  }

  /**
   * Tail recursive
   */
  int factTailRecursive(int num, int accumulator) {
    if (num == 0) return accumulator;
    else return factTailRecursive(num - 1, accumulator * num);
  }

  /**
   * 7.
   * Problem: Print all increasing sequences of length k from first n natural numbers
   * Input: k = 2, n = 3
   * Output:
   * 1 2
   * 1 3
   * 2 3
   */
  void printIncreasingSequence(String soFar, int n, int k, int begin) {
    if (k == 0) System.out.println(soFar);
    else
      for (int i = begin; i <= n; i++)
        printIncreasingSequence(soFar + i + " ", n, k - 1, i + 1);
  }

  /**
   * 8.
   * Problem: Generate all possible sorted arrays from alternate elements of two given sorted arrays
   */

  /**
   * 9.
   * Problem: Minimum steps to reach a destination
   * Given a number line from -infinity to +infinity. You start at 0 and can go either to the left or to the right. The
   * condition is that in i’th move, you take i steps.
   */
  int findMinSteps(int source, int dest, int minSteps, int n){
    if (Math.abs(source) > dest) return Integer.MAX_VALUE;
    else if (source == dest) return minSteps;
    else return Math.min(findMinSteps(source + n, dest, minSteps + 1, n + 1),
              findMinSteps(source - n, dest,minSteps + 1, n + 1));
  }

  /**
   * 10.
   * Problem: Given a string, print all possible palindromic partitions
   * Solution:
   */


  /**
   * 11.
   * Problem: Print a pattern without using any loop
   * Solution:
   */


  /**
   * 12.
   * Problem: Print all non-increasing sequences of sum equal to a given number x
   * Solution:
   */


  /**
   * 13.
   * Problem: Sort a stack using recursion
   * Solution:
   */


  /**
   * 14.
   * Problem: Print all n-digit strictly increasing numbers
   * Solution:
   */

  /**
   * 15.
   * Problem: Find all even length binary sequences with same sum of first and second half bits
   * Solution:
   */

  /**
   * 16.
   * Problem: Print all possible expressions that evaluate to a target
   * Solution:
   */

  /**
   * 17.
   * Problem: Print sums of all subsets of a given set
   */
  void printSubsetSum(int sum, int[] set, int beginIndex) {
    if (beginIndex >= set.length) System.out.println(sum);
    else {
      printSubsetSum(sum + set[beginIndex], set, beginIndex + 1);
      printSubsetSum(sum, set, beginIndex + 1);
    }
  }

  /**
   * 18.
   * Problem: String with additive sequence
   * Solution:
   */

  /**
   * 19.
   * Problem: Print all longest common sub-sequences in lexicographical order
   * You are given two strings.Now you have to print all longest common sub-sequences in
   * lexicographical order?
   * Solution:
   */


  /**
   * 20.
   * Problem: Program for Chocolate and Wrapper Puzzle
   * Given following three values, the task is to find the total number of maximum chocolate
   * you can eat.
   * 1. money : Money you have to buy chocolates
   * 2. price : Price of a chocolate.
   * 3. wrap : Number of wrappers to be returned for getting one extra chocolate.
   * Input :   money = 16, price = 2, wrap = 2
   * Output :   15
   * Price of a chocolate is 2. You can buy 8 chocolates from
   * amount 16. You can return 8 wrappers back and get 4 more
   * chocolates. Then you can return 4 wrappers and get 2 more
   * chocolates. Finally you can return 2 wrappers to get 1
   * more chocolate.
   * Solution:
   */

  /**
   * 21.
   * Problem: Recursion
   * Solution:
   */

  /**
   * 22.
   * Problem:  program to implement Collatz Conjecture
   * Solution:
   */

  /**
   * 23.
   * Problem: Generate all binary strings without consecutive 1’s.
   * Given a integer K. Task is Print All binary string of size K (Given number).
   * Solution:
   */

  /**
   * 24.
   * Problem: Recursive Bubble Sort
   * Solution: Done in sorting examples.
   */

  /**
   * 25.
   * Problem: Recursive Insertion Sort
   * Solution:
   */

  /**
   * 26.
   * Problem: Find ways an Integer can be expressed as sum of exponent-th power of unique natural
   * numbers.
   * Given two numbers sum and exponent, find number of ways sum can be expressed as sum of exponent-th power
   * of unique natural numbers.
   * Input  : sum = 100, exponent = 2
   * Output : 3
   * Explanation: 100 = 10^2
   * OR 6^2 + 8^2
   * OR 1^2 + 3^2 + 4^2 + 5^2 + 7^2
   * Hence total 3 possibilities
   * Solution:
   */
  int findUniqueWays(int sum, int exponent, int start) {
    if (sum < 0) return 0;
    else if (sum == 0) return 1;
    else {
      int uniqueWays = 0;
      for (int i = start; i <= Math.sqrt(sum); i++)
          uniqueWays += findUniqueWays(sum -  (int) Math.pow(i, exponent), exponent, i + 1);
      return uniqueWays;
    }
  }

  /**
   * 27.
   * Problem: Recaman’s sequence
   * Solution: a(n) = {a(n - 1) - n if (a(n - 1) - n > 0 && is new ; else a(n - 1) + n}
   * a(1) = 1;
   *
   */
  Set<Integer> set = new HashSet<>();
  int recamanSequence(int n) {
    if (n < 2) {
      set.add(n);
      return n;
    }
    else {
      int prevTerm = recamanSequence(n - 1);
      if (prevTerm - n > 0 && !set.contains(prevTerm - n)) {
        set.add(prevTerm - n);
        return prevTerm - n;
      }
      else {
        set.add(prevTerm + n);
        return prevTerm + n;
      }
    }
  }




  /**
   *  Problems from CareerCup.
   */

  /**
   * 1.
   * Problem: Given two integers ‘n’ and ‘m’, find all the stepping numbers in range [n, m].
   * A number is called as a stepping number if the adjacent digits are having a difference of 1.
   * For eg. 8,343,545 are stepping numbers. While 890, 098 are not.
   * The difference between a ‘9’ and ‘0’ should not be considered as 1.
   */
  public HashSet<Integer> steppingNumbersSet = new HashSet<>();
  void printSteppingNumber(int soFar, int n, int m, ArrayList<Integer> choices) {
    if (soFar < m) {
      for (int choice : choices) {
        ArrayList<Integer> newChoices = new ArrayList<>();
        if (choice + 1 <= 9) newChoices.add(choice + 1);
        if (choice - 1 >= 0) newChoices.add(choice - 1);
        int steppingNumber = soFar * 10 + choice;
        if (steppingNumber >= n && steppingNumber <= m) steppingNumbersSet.add(steppingNumber);
        printSteppingNumber(steppingNumber, n, m, newChoices);
      }
    }
  }

  /**
   * 2.
   * Problem: Reverse a stack without using any other data structure or auxiliary space.
   */


}
