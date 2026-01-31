package com.jai.neetcode.week3;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    System.out.println("LongestSubstringWithoutRepeatingCharacters = " + lengthOfLongestSubstring("zxyzxyz"));
    System.out.println("LongestSubstringWithoutRepeatingCharacters = " + lengthOfLongestSubstring("xyzabczabc"));
    System.out.println("LongestSubstringWithoutRepeatingCharacters = " + lengthOfLongestSubstring("xxxx"));
    System.out.println("LongestSubstringWithoutRepeatingCharacters = " + lengthOfLongestSubstring("pwwkew"));
    System.out.println("LongestSubstringWithoutRepeatingCharacters = " + lengthOfLongestSubstring("pwwkea"));
    System.out.println("LongestSubstringWithoutRepeatingCharacters = " + lengthOfLongestSubstring("dvdf"));
    System.out.println("LongestSubstringWithoutRepeatingCharacters = " + lengthOfLongestSubstring(" "));
    System.out.println("LongestSubstringWithoutRepeatingCharacters = " + lengthOfLongestSubstring("thequickbrownfoxjumpsoverthelazydogthequickbrownfoxjumpsovert"));
  }

  public static int lengthOfLongestSubstring(String s) {
    if (s.isEmpty())
      return 0;

    HashSet<Character> characterHashSet;
    int longestSubStringLength = 0;
    for (int i=0; i<s.length(); i++) {
      String newString = s.substring(i);
      characterHashSet = new HashSet<>();
      for (Character c : newString.toCharArray()) {
        if (!characterHashSet.contains(c)) {
          characterHashSet.add(c);
        } else {
          break;
        }
      }
      longestSubStringLength = Math.max(longestSubStringLength, characterHashSet.size());
    }
    return longestSubStringLength;
  }
}
