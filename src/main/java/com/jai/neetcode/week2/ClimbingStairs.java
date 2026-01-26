package com.jai.neetcode.week2;

public class ClimbingStairs {

  public static void main(String[] args) {
    climbStairs(4);
  }

  public static int climbStairs(int n) {
    if (n==1)
      return n;

    int oneStep = 1;
    int twoStep = 1;

    int steps = n - 2;
    while (steps != 0) {
      int temp = oneStep;
      oneStep += twoStep;
      twoStep = temp;
      steps --;
    }

    int totalSteps =  oneStep + twoStep;
    //System.out.println("Total Steps = " + totalSteps);
    return totalSteps;
  }
}
