package com.jai.neetcode.week4;

import java.util.*;

public class CommonDigit {

  public static void main(String[] args) {
    solution(new int[] {50, 30, 15, 51, 10, 20, 15});
  }

  public static int solution(int[] nums) {
    HashMap<Character, List<Integer>> numsMap = new HashMap<>();


      for (int i = 0; i < nums.length; i++) {
        String numStr = String.valueOf(nums[i]);
        int numSize = numStr.length();
        for (int j = 0; j < numSize; j++) {
          List<Integer> numsList = numsMap.getOrDefault(numStr.charAt(j), new java.util.ArrayList<>());
          numsList.add(nums[i]);
          numsMap.put(numStr.charAt(j), numsList);
        }

    }

    for(Map.Entry<Character, List<Integer>> entry : numsMap.entrySet()) {
      System.out.println(entry.getKey() + " = " + entry.getValue());
    }

    return 0;
  }
}
