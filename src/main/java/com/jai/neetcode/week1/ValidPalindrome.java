package com.jai.neetcode.week1;

public class ValidPalindrome {

  public static void main(String[] args) {
    String text = ".,";
    System.out.println("Is Palindrome = " + isValidPalindrome(text));
  }

  public static boolean isValidPalindrome(String str) {
    boolean isPalindrome = false;
    str = str.replaceAll("[^a-zA-Z0-9]", "").trim().toLowerCase();
    if (str.length() < 2)
      return true;
    System.out.println("Given string is = " + str);
    int startIdx = 0;
    int endIdx = str.length() - 1;
    while (startIdx < endIdx) {
      if (str.charAt(startIdx) == str.charAt(endIdx)) {
        startIdx++;
        endIdx--;
        isPalindrome = true;
      } else {
        isPalindrome = false;
        break;
      }
    }
    return isPalindrome;
  }

  // NeetCode solution
  public boolean isPalindrome(String s) {
    StringBuilder newStr = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (Character.isLetterOrDigit(c)) {
        newStr.append(Character.toLowerCase(c));
      }
    }
    return newStr.toString().equals(newStr.reverse().toString());
  }
}
