package com.jai.neetcode.week3;

import java.util.*;

// https://neetcode.io/problems/longest-consecutive-sequence/question?list=blind75
public class LongestConsecutiveSubsequence {

  public static void main(String[] args) {
    //System.out.println("Longest Subsequence = " + longestConsecutive(new int[]{11,1,2,3,4,5,6,7,8,9,10}));
    //System.out.println("Longest Subsequence = " + longestConsecutive(new int[] {2,20,4,10,3,4,5}));
    //System.out.println("Longest Subsequence = " + longestConsecutive(new int[] {3, 5, 7, 9}));
    System.out.println("Longest Subsequence = " + longestConsecutive(new int[] {9,1,4,7,3,-1,0,5,8,-1,6}));
  }

  public static int longestConsecutive(int[] nums) {
    if(nums.length == 0)
      return 0;

    SortedSet<Integer> sortedSet = Arrays.stream(nums).boxed()
      .collect(java.util.stream.Collectors.toCollection(TreeSet::new));

    System.out.println("SortedSet: " + sortedSet);

    int longestSubSequence = 1;
    int loopSubSequence = 1;

    List<Integer> sortedList = new ArrayList<>(sortedSet);

    for(int i=1; i<sortedList.size(); i++) {
      if(sortedList.get(i) - sortedList.get(i-1) == 1) {
        loopSubSequence+=1;
      } else {
        loopSubSequence = 1;
      }
      longestSubSequence = Math.max(loopSubSequence, longestSubSequence);
    }
    return longestSubSequence;
  }
}
