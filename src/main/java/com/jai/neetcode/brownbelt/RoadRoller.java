package com.jai.neetcode.brownbelt;

public class RoadRoller {

  public static void main(String[] args) {
    //System.out.println("Solution = " + solution(new int[] {2, 4, 2, 6, 7, 1}, new int[] {0, 5, 3, 2, 1, 5}, 2));
    System.out.println("Solution = " + solution(new int[] {4, 8, 2, 2, 1, 4}, new int[] {1, 2, 3, 1, 2, 3}, 3));
  }

  public static int solution(int[] X, int[]Y, int W) {
    // If there are no potholes, no drives are needed
    if (X == null || X.length == 0) {
      return 0;
    }

    java.util.Arrays.sort(X);
    int drives = 0;
    int drivePos = -1;
    for (int z: X) {
      if (z > drivePos) {
        drivePos = z + W;
        drives++;
      }
    }

    return drives;
  }
}
