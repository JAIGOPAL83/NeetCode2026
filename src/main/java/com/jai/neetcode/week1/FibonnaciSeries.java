package com.jai.neetcode.week1;

public class FibonnaciSeries {

  public static void main(String[] args) {
    for (int i=0; i< 50; i++) {
      System.out.println(fibonnaci(i));
    }
  }

  public static int fibonnaci(int n) {
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;

    return fibonnaci(n - 1) + fibonnaci(n - 2);
  }
}
