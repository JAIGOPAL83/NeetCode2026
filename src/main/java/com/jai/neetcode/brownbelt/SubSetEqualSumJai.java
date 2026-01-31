package com.jai.neetcode.brownbelt;

public class SubSetEqualSumJai {

  public static void main(String[] args) {
    System.out.println("Subset sum equal=" + isEqualSum(new int[] {1, 5, 5, 11}));
  }

  public static boolean isEqualSum(int[] subset) {
    int subSetSum = 0;
    for (int k : subset) {
      subSetSum += k;
    }

    if (subSetSum % 2 != 0) {
      return  false;
    }

    int columns = subSetSum/2 + 1;
    int rows = subset.length+1;
    boolean[][] result = new boolean[rows][columns];

    for (int i=0; i<rows; i++) {
      for (int j=0; j<columns; j++) {
        if (i==0 && j==0) {
          result[i][j] = true;
        } else if (i == 0) {
          result[i][j] = false;
        }

        if (i > 0) {
          if(result[i-1][j]) {
            result[i][j] = true;
          } else {
            if (j - subset[i-1] >= 0) {
              int prevColumnValue = j - subset[i-1];
              result[i][j] = result[i - 1][prevColumnValue];
            } else {
              result[i][j] = false;
            }
          }
          System.out.println("Result = result["+i+"]["+j+"]" + result[i][j]);
        }
      }
    }
    return result[rows-1][columns-1];
  }
}
