package com.jai.neetcode.week4;

// https://neetcode.io/problems/eating-bananas/solution
public class MinEatingSpeed {

  public static void main(String[] args) {
    System.out.println(minEatingSpeed(new int[] {25, 10, 23, 4}, 4));
    //System.out.println(minEatingSpeed(new int[] {1, 4, 3, 2}, 9));
    //.out.println(minEatingSpeed(new int[] {30,11,23,4,20}, 6));
  }

  public static int minEatingSpeed(int[] piles, int h) {
    int left = 1;
    int right = java.util.Arrays.stream(piles).max().getAsInt(); // Max pile is the max speed needed

    int result = right;

    while (left <= right) {
      int mid = left + (right - left) / 2; // Current speed to test
      long totalHours = 0;

      for (int pile : piles) {
        // Using the integer ceiling trick
        totalHours += (pile + mid - 1) / mid;
      }

      if (totalHours <= h) {
        result = mid;      // This speed works, but can we go slower?
        right = mid - 1;   // Try smaller speeds
      } else {
        left = mid + 1;    // Too slow, must eat faster
      }
    }
    return result;
  }

}
