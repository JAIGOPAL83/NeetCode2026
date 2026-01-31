package com.jai.neetcode.week3;

public class TwoIntegerSum {

  public static void main(String[] args) {
    //System.out.println("TwoIntegerSum = " + java.util.Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 5)));
    //System.out.println("TwoIntegerSum = " + java.util.Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
    //System.out.println("TwoIntegerSum = " + java.util.Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 9)));
    //System.out.println("TwoIntegerSum = " + java.util.Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 6)));
    System.out.println("TwoIntegerSum = " + java.util.Arrays.toString(twoSum(new int[]{-5, -3, -2, -1, 0, 5}, 0)));
  }

  public static int[] twoSum(int[] numbers, int target) {
    int leftIdx = 0;
    int index1 = -1;
    int index2 = -1;

    boolean targetNotFound = true;

    while(targetNotFound && leftIdx <= numbers.length-2){
      int sum = 0;
      for(int i=leftIdx; i<=numbers.length-2; i++){
        sum = numbers[leftIdx] + numbers[i+1];
        if (sum == target) {
          index1 = leftIdx+1;
          index2 = i+2;
          targetNotFound = false;
          break;
        } else if (sum > target) {
          break;
        }
      }
      leftIdx++;
    }
    return new int[] {index1, index2};

  }
}
