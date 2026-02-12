package com.jai.neetcode.week3;

public class ContainerWithMostWater {

  public static void main(String[] args) {
    // System.out.println("Max_area = " + maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    System.out.println("Max_area = " + maxArea(new int[] {1,7,2,5,4,7,3,6}));
  }

  public static int maxArea(int[] heights) {

    int max_area = 0;
    int a_pointer = 0;
    int b_pointer = heights.length-1;

    while(a_pointer < b_pointer) {
      if(heights[a_pointer] < heights[b_pointer]) {
        max_area = Math.max(max_area, heights[a_pointer] * (b_pointer - a_pointer));
        a_pointer+=1;
      } else {
        max_area = Math.max(max_area, heights[b_pointer] * (b_pointer - a_pointer));
        b_pointer-=1;
      }
    }

    return max_area;
  }
}
