package com.jai.neetcode.brownbelt;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/
public class LongestSubStringContainingVowels {

  public static void main(String[] args) {
    //System.out.println("Solution = " + solution("eleetminicoworoep"));
    //System.out.println("Solution = " + solution("leetcodeisgreat"));
    //System.out.println("Solution = " + solution("bcbcbc"));
    System.out.println("Solution = " + solution("id"));
  }

  public static int solution(String s) {
    // Map to store first occurrence of each parity state
    Map<String, Integer> firstSeen = new HashMap<>();

    // Initial state: all 5 vowels (a, e, i, o, u) have even counts
    char[] state = {'0', '0', '0', '0', '0'};
    String initialState = new String(state);
    firstSeen.put(initialState, -1);

    int maxLen = 0;
    String vowels = "aeiou";

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int vIdx = vowels.indexOf(c);

      // If it's a vowel, flip its parity in the state array
      if (vIdx != -1) {
        state[vIdx] = (state[vIdx] == '0') ? '1' : '0';
      }

      String currentState = new String(state);

      // If this state has been seen before, a valid substring exists
      if (firstSeen.containsKey(currentState)) {
        maxLen = Math.max(maxLen, i - firstSeen.get(currentState));
      } else {
        // Otherwise, record the first time we see this state
        firstSeen.put(currentState, i);
      }
    }
    return maxLen;
  }
}
