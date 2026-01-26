package com.jai.neetcode.brownbelt;

// Problem Description: https://www.geeksforgeeks.org/dsa/partition-problem-dp-18/
public class SubSetEqualSum {

  public static void main(String[] args) {
    //System.out.println(isSubSetEqualSum(new int[] {1,5,11,5}));
    //System.out.println(isSubSetEqualSum(new int[] {1,2,5}));
    System.out.println(equalPartition(new int[] {3,3,6,8,16,16,16,18,20}));
  }

  public static boolean isSubSetEqualSum(int[] nums) {
    int arrsum = java.util.Arrays.stream(nums).sum();

    if (arrsum %2 != 0) {
      return false;
    }

    int total_left_part_sum = 0;
    int total_right_part_sum = 0;
    int halfArrSum = arrsum/2;

    for (int num: nums) {
      if (total_left_part_sum > halfArrSum || total_right_part_sum > halfArrSum) {
        return  false;
      }
      if (total_left_part_sum + num <= halfArrSum) {
        total_left_part_sum += num;
      } else {
        total_right_part_sum += num;
      }
    }
    return total_left_part_sum == total_right_part_sum;
  }

  static boolean isSubsetSum(int n, int[] arr, int sum) {

    // base cases
    if (sum == 0)
      return true;
    if (n == 0)
      return false;

    // If element is greater than sum, then ignore it
    if (arr[n - 1] > sum)
      return isSubsetSum(n - 1, arr, sum);

    // Check if sum can be obtained by any of the following
    // (a) including the current element
    // (b) excluding the current element
    return isSubsetSum(n - 1, arr, sum) ||
      isSubsetSum(n - 1, arr, sum - arr[n - 1]);
  }

  static boolean equalPartition(int[] arr) {

    // Calculate sum of the elements in array
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }

    // If sum is odd, there cannot be two
    // subsets with equal sum
    if (sum % 2 != 0)
      return false;

    // Find if there is subset with sum equal
    // to half of total sum
    return isSubsetSum(arr.length, arr, sum / 2);
  }
}
