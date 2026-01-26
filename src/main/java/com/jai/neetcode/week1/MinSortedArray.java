package com.jai.neetcode.week1;

public class MinSortedArray {

  public static void main(String[] args) {
    int[] nums = {5,4,3,2,1};
    System.out.println("Min in sorted Arr = " + findMinNeetCode(nums));
  }

  public static int findMin(int[] nums) {
    java.util.Arrays.sort(nums);
    return nums[0];
  }

  public static int findMinNeetCode(int[] nums) {
    int leftIdx = 0;
    int rightIdx = nums.length - 1;

    while (leftIdx < rightIdx) {
      int middleIdx = leftIdx + (rightIdx - leftIdx) / 2;
      if (nums[middleIdx] < nums[rightIdx]) {
        rightIdx = middleIdx;
      } else {
        leftIdx = middleIdx + 1;
      }
    }
    return nums[leftIdx];
  }
}
