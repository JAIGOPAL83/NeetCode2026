package com.jai.neetcode.brownbelt;

import java.util.*;

public class MaxChamber {

  public static void main(String[] args) {
    System.out.println("Solution = " + solution(new String[] {}));
  }

  public static int solution(String[] B) {
    int N = B.length, M = B[0].length();
    int[][] dp = new int[N][M];
    for (int[] row : dp) java.util.Arrays.fill(row, -1);

    if (B[0].charAt(0) == 'X')
      return -1;

    dp[0][0] = 1;

    for (int i = 0; i < N; i++) {
      // 1. Snaking Right: check if coming from the left neighbor is better
      for (int j = 1; j < M; j++) {
        if (B[i].charAt(j) == '.' && dp[i][j-1] != -1)
          dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + 1);
      }
      // 2. Snaking Left: check if coming from the right neighbor is better
      for (int j = M - 2; j >= 0; j--) {
        if (B[i].charAt(j) == '.' && dp[i][j+1] != -1)
          dp[i][j] = Math.max(dp[i][j], dp[i][j+1] + 1);
      }
      // 3. Drop Down: Prepare the next row based on current row results
      if (i < N - 1) {
        for (int j = 0; j < M; j++) {
          if (dp[i][j] != -1 && B[i+1].charAt(j) == '.')
            dp[i+1][j] = dp[i][j] + 1;
        }
      }
    }
    return dp[N-1][M-1];
  }


    public static int solution2(String[] B) {
      int N = B.length;
      int M = B[0].length(); // Using B[0].length() for the width

      // 1. Safety Check: If Start or End is blocked, return -1 immediately
      if (B[0].charAt(0) == 'X' || B[N - 1].charAt(M - 1) == 'X') {
        return -1;
      }

      // dp[j] stores the max chambers reached at column j in the current row
      int[] dp = new int[M];
      Arrays.fill(dp, -1);

      // Initial Position: Start at (0,0) with 1 chamber visited
      dp[0] = 1;

      for (int i = 0; i < N; i++) {
        // STEP A: "Drop Down" from the previous row
        // Note: On row 0, we skip this to keep our starting dp[0]=1
        if (i > 0) {
          for (int j = 0; j < M; j++) {
            if (dp[j] != -1 && B[i].charAt(j) == '.') {
              dp[j] += 1; // Add 1 for entering the current floor
            } else {
              dp[j] = -1; // Blocked or unreachable from above
            }
          }
        }

        // STEP B: Right Pass (Can I get a better score by walking RIGHT?)
        int[] rightPass = new int[M];
        for (int j = 0; j < M; j++) {
          if (B[i].charAt(j) == 'X') {
            rightPass[j] = -1;
          } else {
            int fromAbove = dp[j];
            int fromLeft = (j > 0 && rightPass[j - 1] != -1) ? rightPass[j - 1] + 1 : -1;
            rightPass[j] = Math.max(fromAbove, fromLeft);
          }
        }

        // STEP C: Left Pass (Can I get a better score by walking LEFT?)
        int[] leftPass = new int[M];
        for (int j = M - 1; j >= 0; j--) {
          if (B[i].charAt(j) == 'X') {
            leftPass[j] = -1;
          } else {
            int fromAbove = dp[j];
            int fromRight = (j < M - 1 && leftPass[j + 1] != -1) ? leftPass[j + 1] + 1 : -1;
            leftPass[j] = Math.max(fromAbove, fromRight);
          }
        }

        // STEP D: Update main DP table for this row
        for (int j = 0; j < M; j++) {
          dp[j] = Math.max(rightPass[j], leftPass[j]);
        }
      }

      // Final result at the exit (bottom-right)
      return dp[M - 1];
    }



}
