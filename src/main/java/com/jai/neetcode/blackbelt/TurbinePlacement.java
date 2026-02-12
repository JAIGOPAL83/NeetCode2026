package com.jai.neetcode.blackbelt;

import java.util.*;

// Bird Habitats
public class TurbinePlacement {

  public static void main(String[] args) {

  }

  public static int countValidPositions(int[][] grid, int K) {
    int rows = grid.length;
    int cols = grid[0].length;
    int[][] distances = new int[rows][cols];
    Queue<int[]> queue = new LinkedList<>();

    // Initialize distances with -1 (unvisited)
    for (int[] row : distances) Arrays.fill(row, -1);

    // 1. Locate habitats
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == 1) {
          distances[r][c] = 0;
          queue.offer(new int[]{r, c});
        }
      }
    }

    // 2. Multi-source BFS (Manhattan distance)
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      for (int[] d : dirs) {
        int nr = curr[0] + d[0];
        int nc = curr[1] + d[1];

        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && distances[nr][nc] == -1) {
          distances[nr][nc] = distances[curr[0]][curr[1]] + 1;
          queue.offer(new int[]{nr, nc});
        }
      }
    }

    // 3. Count valid cells
    int count = 0;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (distances[r][c] > K) count++;
      }
    }
    return count;
  }
}
