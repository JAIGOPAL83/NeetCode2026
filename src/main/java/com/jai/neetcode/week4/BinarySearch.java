package com.jai.neetcode.week4;

public class BinarySearch {

  public static void main(String[] args) {
    //System.out.println("Solution = " + search(new int[] {-1, 0, 2, 4, 6, 8}, 3));
    //System.out.println("Solution = " + search(new int[] {-1, 0, 2, 4, 6, 8, 9}, 8));
    //System.out.println("Solution = " + search(new int[] {1, 5}, 6));
    System.out.println("Solution = " + search(new int[] {-1,0,3,5,9,12}, 13));
  }

  public static int search(int[] nums, int target) {
    int start_pointer = 0;
    int end_pointer = nums.length-1;

    while(start_pointer <= end_pointer) {
      int mid_pointer = (start_pointer + end_pointer)/2;
      if(nums[mid_pointer] == target) {
        return  mid_pointer;
      } else if (nums[mid_pointer] < target) {
        start_pointer = mid_pointer + 1;
      } else if (nums[mid_pointer] > target) {
        end_pointer = mid_pointer - 1;
      }
    }

    return -1;
  }
}
