package algorithms.bit;

public class BitExamples {


 /**
   * 1.
   * Problem: Smallest power of 2 greater than or equal to n.
   */
  int getNextPowerOf2(int n) {
    int power = 1;
    if (isPowerOf2(n)) return n;
    else while (power < n) power <<= 1;
    return power;
  }

  /**
   * 2.
   * Problem: Write an Efficient Method to Check if a Number is Multiple of 3.
   * Solution:
   * 1) Get count of all set bits at odd positions (For 23 it’s 3).
   * 2) Get count of all set bits at even positions (For 23 it’s 1).
   * 3) If difference of above two counts is a multiple of 3 then number is also a multiple of 3.
   */

  /**
   * 3.
   * Problem: Write a C program to find the parity of an unsigned integer.
   * Solution:
   */

  /**
   * 4.
   * Problem: Efficient way to multiply with 7.
   * Solution:
   */

  /**
   * 5.
   * Problem: Program to find whether a no is power of two.
   * Solution:
   */
  boolean isPowerOf2(int n) {
    return n != 0 && (n & (n - 1)) == 0;
  }

  /**
   * 6.
   * Problem: Position of rightmost set bit.
   * Solution:
   */

  /**
   * 7.
   * Problem: Find the Number Occurring Odd Number of Times.
   * Solution:
   */

  /**
   * 8.
   * Problem: Check for Integer Overflow.
   * Solution:
   */

  /**
   * 9.
   * Problem: Little and Big Endian Mystery.
   * Solution:
   */

  /**
   * 10.
   * Problem: Write an Efficient C Program to Reverse Bits of a Number.
   * Solution:
   */

  /**
   * 11.
   * Problem: Count set bits in an integer.
   * Solution:
   */

  /**
   * 12.
   * Problem: Count number of bits to be flipped to convert A to B.
   * Solution:
   */

  /**
   * 13.
   * Problem: Find the two non-repeating elements in an array of repeating elements.
   * Solution:
   */

  /**
   * 14.
   * Problem: Rotate bits of a number.
   * Solution:
   */

  /**
   * 15.
   * Problem: Compute the minimum or maximum of two integers without branching.
   * Solution:
   */

  /**
   * 16.
   * Problem: Compute modulus division by a power-of-2-number.
   * Solution:
   */

  /**
   * 17.
   * Problem: Compute the integer absolute value (abs) without branching.
   * Solution:
   */

  /**
   * 18.
   * Problem: Find whether a given number is a power of 4 or not.
   * Solution:
   */

  /**
   * 19.
   * Problem: Turn off the rightmost set bit.
   * Solution:
   */

  /**
   * 20.
   * Problem: Multiply a given Integer with 3.5.
   * Solution:
   */

  /**
   * 21.
   * Problem: Add 1 to a given number.
   * Solution:
   */

  /**
   * 22.
   * Problem: Optimization Techniques | Set 1 (Modulus).
   * Solution:
   */

  /**
   * 23.
   * Problem: Next higher number with same number of set bits.
   * Solution:
   */

  /**
   * 24.
   * Problem: Program to count number of set bits in an (big) array.
   * Solution:
   */

  /**
   * 25.
   * Problem: A Boolean Array Puzzle.
   * Solution:
   */

  /**
   * 26.
   * Problem: Smallest of three integers without comparison operators.
   * Solution:
   */

  /**
   * 27.
   * Problem: Add two numbers without using arithmetic operators.
   * Solution:
   */

  /**
   * 28.
   * Problem: Swap bits in a given number.
   * Solution:
   */

  /**
   * 29.
   * Problem: Count total set bits in all numbers from 1 to n.
   * Solution:
   */

  /**
   * 30.
   * Problem: Detect if two integers have opposite signs.
   * Solution:
   */

  /**
   * 31.
   * Problem: Find the element that appears once.
   * Solution:
   */

  /**
   * 32.
   * Problem: Binary representation of a given number.
   * Solution:
   */

  /**
   * 33.
   * Problem: Write your own strcmp that ignores cases.
   * Solution:
   */

  /**
   * 34.
   * Problem: Add two bit strings.
   * Solution:
   */

  /**
   * 35.
   * Problem: Generate n-bit Gray Codes.
   * Solution:
   */

  /**
   * 36.
   * Problem: Swap all odd and even bits.
   * Solution:
   */

  /**
   * 37.
   * Problem: Find position of the only set bit.
   * Solution:
   */

  /**
   * 38.
   * Problem: Russian Peasant  (Multiply two numbers using bitwise operators).
   * Solution:
   */

  /**
   * 39.
   * Problem: How to swap two numbers without using a temporary variable?.
   * Solution:
   */

  /**
   * 40.
   * Problem: Interesting Facts about Bitwise Operators in C.
   * Solution:
   */

  /**
   * 41.
   * Problem: Check if a number is multiple of 9 using bitwise operators.
   * Solution:
   */

  /**
   * 42.
   * Problem: How to turn off a particular bit in a number?.
   * Solution:
   */

  /**
   * 43.
   * Problem: Swap two nibbles in a byte.
   * Solution:
   */

  /**
   * 44.
   * Problem: Check if binary representation of a number is palindrome.
   * Solution:
   */

  /**
   * 45.
   * Problem: Write a function that returns 2 for input 1 and returns 1 for 2.
   * Solution:
   */

  /**
   * 46.
   * Problem: Bit Fields in C.
   * Solution:
   */

  /**
   * 47.
   * Problem: What are the differences between bitwise and logical AND operators in C/C++?.
   * Solution:
   */

  /**
   * 48.
   * Problem: Calculate square of a number without using *, / and pow().
   * Solution:
   */

  /**
   * 49.
   * Problem: Subtract two numbers without using arithmetic operators.
   * Solution:
   */

  /**
   * 50.
   * Problem: Calculate 7n/8 without using division and multiplication operators.
   * Solution:
   */

  /**
   * 51.
   * Problem: How to swap two bits in a given integer?.
   * Solution:
   */

  /**
   * 52.
   * Problem: Find nth Magic Number.
   * Solution:
   */

  /**
   * 53.
   * Problem: Check if two numbers are equal without using arithmetic and comparison operators.
   * Solution:
   */

  /**
   * 54.
   * Problem: Euclid&#8217;s Algorithm when % and / operations are costly.
   * Solution:
   */

  /**
   * 55.
   * Problem: Check if a given number is sparse or not.
   * Solution:
   */

  /**
   * 56.
   * Problem: Sum of bit differences among all pairs.
   * Solution:
   */

  /**
   * 57.
   * Problem: Find XOR of two number without using XOR operator.
   * Solution:
   */

  /**
   * 58.
   * Problem: Find the maximum subarray XOR in a given array.
   * Solution:
   */

  /**
   * 59.
   * Problem: Find Next Sparse Number.
   * Solution:
   */

  /**
   * 60.
   * Problem: Sum of Bitwise And of all pairs in a given array.
   * Solution:
   */

  /**
   * 61.
   * Problem: Given a set, find XOR of the XOR&#8217;s of all subsets..
   * Solution:
   */

  /**
   * 62.
   * Problem: Find the maximum subset XOR of a given set.
   * Solution:
   */

  /**
   * 63.
   * Problem: Gray to Binary and Binary to Gray conversion.
   * Solution:
   */

  /**
   * 64.
   * Problem: C++ bitset and its application.
   * Solution:
   */

  /**
   * 65.
   * Problem: Count strings with consecutive 1&#8217;s.
   * Solution:
   */

  /**
   * 66.
   * Problem: Check if a number is Bleak.
   * Solution:
   */

  /**
   * 67.
   * Problem: Copy set bits in a range.
   * Solution:
   */

  /**
   * 68.
   * Problem: Cyclic Redundancy Check and Modulo-2 Division.
   * Solution:
   */

  /**
   * 69.
   * Problem: Find even occurring elements in an array of limited range.
   * Solution:
   */

  /**
   * 70.
   * Problem: Generate 0 and 1 with 25% and 75% probability.
   * Solution:
   */

  /**
   * 71.
   * Problem: Print first n numbers with exactly two set bits.
   * Solution:
   */

  /**
   * 72.
   * Problem: Find profession in a special family.
   * Solution:
   */

  /**
   * 73.
   * Problem: C++ bitset interesting facts.
   * Solution:
   */

  /**
   * 74.
   * Problem: Find Two Missing Numbers | Set 2 (XOR based solution).
   * Solution:
   */

  /**
   * 75.
   * Problem: Swap three variables without using temporary variable.
   * Solution:
   */

  /**
   * 76.
   * Problem: Pairs of complete strings in two sets of strings.
   * Solution:
   */

  /**
   * 77.
   * Problem: Check whether a given number is even or odd.
   * Solution:
   */

  /**
   * 78.
   * Problem: Length of the Longest Consecutive 1s in Binary Representation.
   * Solution:
   */

  /**
   * 79.
   * Problem: Equal Sum and XOR.
   * Solution:
   */

  /**
   * 80.
   * Problem: Multiply a number with 10 without using multiplication operator.
   * Solution:
   */

  /**
   * 81.
   * Problem: Multiples of 4 (An Interesting Method).
   * Solution:
   */

  /**
   * 82.
   * Problem: Calculate XOR from 1 to n..
   * Solution:
   */

  /**
   * 83.
   * Problem: Bitwise and (or &#038;) of a range.
   * Solution:
   */

  /**
   * 84.
   * Problem: Multiplying a variable with a constant without using multiplication operator.
   * Solution:
   */

  /**
   * 85.
   * Problem: XOR  counts of 0s and 1s in binary representation.
   * Solution:
   */

  /**
   * 86.
   * Problem: Maximum 0&#8217;s between two immediate 1&#8217;s in binary representation.
   * Solution:
   */

  /**
   * 87.
   * Problem: Subset sum queries using bitset.
   * Solution:
   */

  /**
   * 88.
   * Problem: Highest power of 2 less than or equal to given number.
   * Solution:
   */

  /**
   * 89.
   * Problem: Check if a number has bits in alternate pattern.
   * Solution:
   */

  /**
   * 90.
   * Problem: Check if bits of a number has count of consecutive set bits in increasing order.
   * Solution:
   */

  /**
   * 91.
   * Problem: Compare two integers without using any Comparison operator.
   * Solution:
   */

  /**
   * 92.
   * Problem: Efficient method for 2&#8217;s complement of a binary string.
   * Solution:
   */

  /**
   * 93.
   * Problem: Multiplication of two numbers with shift operator.
   * Solution:
   */

  /**
   * 94.
   * Problem: Check divisibility in a binary stream.
   * Solution:
   */

  /**
   * 95.
   * Problem: Count smaller numbers whose XOR with n produces greater value.
   * Solution:
   */

  /**
   * 96.
   * Problem: Count minimum bits to flip such that XOR of A and B equal to C.
   * Solution:
   */

  /**
   * 97.
   * Problem: Count trailing zero bits using lookup table.
   * Solution:
   */

  /**
   * 98.
   * Problem: Efficiently check if a string has duplicates without using any additional data structure.
   * Solution:
   */

  /**
   * 99.
   * Problem: Count all pairs of an array which differ in K bits.
   * Solution:
   */

  /**
   * 100.
   * Problem: Builtin functions of GCC compiler.
   * Solution:
   */

  /**
   * 101.
   * Problem: Find longest sequence of 1&#8217;s in binary representation with one flip.
   * Solution:
   */

  /**
   * 102.
   * Problem: Count smaller values whose XOR with x is greater than x.
   * Solution:
   */

  /**
   * 103.
   * Problem: Convert decimal fraction to binary number.
   * Solution:
   */

  /**
   * 104.
   * Problem: Change bits to make specific OR value.
   * Solution:
   */

  /**
   * 105.
   * Problem: Find Duplicates of array using bit array.
   * Solution:
   */

  /**
   * 106.
   * Problem: Check whether K-th bit is set or not.
   * Solution:
   */

  /**
   * 107.
   * Problem: Toggling k-th bit of a number.
   * Solution:
   */

  /**
   * 108.
   * Problem: Numbers whose bitwise OR and sum with N are equal.
   * Solution:
   */

  /**
   * 109.
   * Problem: Maximum XOR value of a pair from a range.
   * Solution:
   */

  /**
   * 110.
   * Problem: Inserting m into n such that m starts at bit j and ends at bit i..
   * Solution:
   */

  /**
   * 111.
   * Problem: Count numbers whose sum with x is equal to XOR with x.
   * Solution:
   */

  /**
   * 112.
   * Problem: Reverse an array without using subtract sign ‘-‘ anywhere in the code.
   * Solution:
   */

  /**
   * 113.
   * Problem: Determine if a string has all Unique Characters.
   * Solution:
   */

  /**
   * 114.
   * Problem: Case conversion (Lower to Upper and Vice Versa) of a string using BitWise operators in C/C++.
   * Solution:
   */

  /**
   * 115.
   * Problem: Toggle case of a string using Bitwise operators.
   * Solution:
   */

  /**
   * 116.
   * Problem: Toggle all the bits of a number except k-th bit..
   * Solution:
   */

  /**
   * 117.
   * Problem: Closest (or Next) smaller and greater numbers with same number of set bits.
   * Solution:
   */

  /**
   * 118.
   * Problem: Bit Tricks for Competitive Programming.
   * Solution:
   */

  /**
   * 119.
   * Problem: XOR of all subarray XORs | Set 2.
   * Solution:
   */

  /**
   * 120.
   * Problem: Check if two numbers are bit rotations of each other or not.
   * Solution:
   */

  /**
   * 121.
   * Problem: Set the K-th bit of a given number.
   * Solution:
   */

  /**
   * 122.
   * Problem: Next greater integer having one more number of set bits.
   * Solution:
   */

  /**
   * 123.
   * Problem: Bitmasking and Dynamic Programming | Set-2 (TSP).
   * Solution:
   */

}
