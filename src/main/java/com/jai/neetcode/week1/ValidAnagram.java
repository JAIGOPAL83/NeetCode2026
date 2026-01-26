package com.jai.neetcode.week1;

public class ValidAnagram {

  public static void main(String[] args) {
    String s = "racecar";
    String t = "carrace";
    System.out.println("Is Valid Anagram = " + isAnagram(s, t));
  }

  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    java.util.TreeMap<Character, Integer> sMap = new java.util.TreeMap<>();
    for (Character c : s.toCharArray()) {
      sMap.put(c, sMap.getOrDefault(c, 0) + 1);
    }

    java.util.TreeMap<Character, Integer> tMap = new java.util.TreeMap<>();
    for (Character c : t.toCharArray()) {
      tMap.put(c, tMap.getOrDefault(c, 0) + 1);
    }

    return sMap.equals(tMap);
  }

  /**
   * Algorithm
   * If the lengths of the strings differ, return False immediately.
   * Create a frequency array count of size 26 initialized to zero.
   * Iterate through both strings:
   * Increment the count at the index corresponding to s[i].
   * Decrement the count at the index corresponding to t[i].
   * After processing both strings, scan through the count array:
   * If any value is not zero, return False because the frequencies differ.
   * If all values are zero, return True since the strings are anagrams.
   * @param s
   * @param t
   * @return
   */
  public boolean isAnagramNeetCode(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] count = new int[26];
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
      count[t.charAt(i) - 'a']--;
    }

    for (int val : count) {
      if (val != 0) {
        return false;
      }
    }
    return true;
  }
}
