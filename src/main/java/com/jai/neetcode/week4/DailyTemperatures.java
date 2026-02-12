package com.jai.neetcode.week4;

public class DailyTemperatures {

  public static void main(String[] args) {
    System.out.println("solution = " + java.util.Arrays.toString(dailyTemperatures(new int[] {30,38,30,36,35,40,28})));
    System.out.println("solution = " + java.util.Arrays.toString(dailyTemperatures(new int[] {30,38,30,36,35,40,41})));
    System.out.println("solution = " + java.util.Arrays.toString(dailyTemperatures(new int[] {22,21,20})));
    System.out.println("solution = " + java.util.Arrays.toString(dailyTemperatures(new int[] {89,62,70,58,47,47,46,76,100,70})));
  }

  public static int[] dailyTemperatures(int[] temperatures) {
  int[] warmerTemp = new int[temperatures.length];

    if (temperatures.length == 1) {
      warmerTemp[0] = 0;
      return  warmerTemp;
    }

    for(int i = 0; i < temperatures.length; i++){
      int dayTemp = temperatures[i];
      int warmerDaysCount = 1;
      for(int j = i+1; j < temperatures.length; j++){
        if (temperatures[j] <= dayTemp) {
          warmerDaysCount = warmerDaysCount + 1;
        } else {
          warmerTemp[i] = warmerDaysCount;
          break;
        }
      }
    }

    return  warmerTemp;
  }
}
