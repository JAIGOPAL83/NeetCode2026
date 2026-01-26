package com.jai.neetcode.brownbelt;

// https://leetcode.com/problems/house-robber/description/
public class HouseRobber {

  public static void main(String[] args) {
    //System.out.println("Solution = " + rob(new int[]{1, 2, 3, 1}));
    //System.out.println("Solution = " + rob(new int[]{2, 1, 1, 2}));
    System.out.println("Solution = " + rob(new int[]{2,7,9,3,1}));
  }

  public static int rob(int[] nums) {
    // Handle empty input
    if (nums == null || nums.length == 0) return 0;

    // Handle a single house
    if (nums.length == 1) return nums[0];

    int prevTwo = 0; // Max money 2 houses back
    int prevOne = 0; // Max money 1 house back

    for (int money : nums) {
      // Calculate the current maximum
      // Either we rob this house + prevTwo, or we skip it and keep prevOne
      int current = Math.max(money + prevTwo, prevOne);

      // Shift the values forward for the next iteration
      prevTwo = prevOne;
      prevOne = current;
    }

    return prevOne;
  }
}
