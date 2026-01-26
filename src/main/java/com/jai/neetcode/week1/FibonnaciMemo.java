package com.jai.neetcode.week1;

public class FibonnaciMemo {

  // We use an array to store previously calculated values
  private static long[] memo;

  public static long fib(int n) {
    if (n == 1 || n == 0) {
      memo[n] = n;
      return n;
    }

    // 1. Check if we already calculated this value
    if (memo[n] != 0) {
      return memo[n];
    }

    // 2. Otherwise, calculate it and save it to the memo
    memo[n] = fib(n - 1) + fib(n - 2);

    return memo[n];
  }

  public static void main(String[] args) {
    int n = 5;
    memo = new long[n + 1]; // Initialize the cache
    System.out.println("Fibonacci of " + n + " is: " + fib(n));
  }
}
