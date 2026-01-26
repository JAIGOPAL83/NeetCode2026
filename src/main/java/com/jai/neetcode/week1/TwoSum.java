package com.jai.neetcode.week1;

public class TwoSum {

  public static void main(String[] args) {
    int[] nums = {5, 5};
    int target = 10;
    System.out.println("Two sum = " + java.util.Arrays.toString(twoSum(nums, target)));
  }

  public static int[] twoSum(int[] nums, int target) {
    int currIdx = 0;
    int firstIdx = 0;
    java.util.ArrayList<Integer> numsList = new java.util.ArrayList<>();
    for (int num : nums) {
      int twoNum = target - num;
      if (numsList.contains(twoNum)) {
        firstIdx = numsList.indexOf(twoNum);
        break;
      } else {
        numsList.add(num);
        currIdx++;
      }
    }
    return new int[]{firstIdx, currIdx};
  }

  // neet code solution
  public int[] twoSumNeetCode(int[] nums, int target) {
    java.util.HashMap<Integer, Integer> prevMap = new java.util.HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      int diff = target - num;

      if (prevMap.containsKey(diff)) {
        return new int[] { prevMap.get(diff), i };
      }

      prevMap.put(num, i);
    }

    return new int[] {};
  }
}
