package com.jai.neetcode.week2;

public class BuySellStock {

  public static void main(String[] args) {
    System.out.println("Max Profit = " + maxProfitNeetCode(new int[]{1, 2, 4}));
  }

  public static int maxProfit(int[] prices) {
    if (prices.length == 1)
      return 0;

    int buyPointer = 0;
    int sellPointer = 1;
    int maxProfit = 0;

    while (buyPointer < sellPointer) {
      boolean shiftBuyPointer = true;
      if (prices[sellPointer] > prices[buyPointer]) {
        int profit = prices[sellPointer] - prices[buyPointer];
        maxProfit = Math.max(profit, maxProfit);
      } else {
        buyPointer = buyPointer + 1;
        shiftBuyPointer = false;
      }

      if(shiftBuyPointer && sellPointer == prices.length - 1) {
        buyPointer = buyPointer + 1;
      }
      sellPointer = Math.min(prices.length-1, sellPointer + 1);
    }
    return maxProfit;
  }

  public static int maxProfitNeetCode(int[] prices) {
    int buyPointer = 0;
    int sellPointer = 1;
    int maxProfit = 0;

    while (sellPointer < prices.length) {
      if (prices[buyPointer] < prices[sellPointer]) {
        int profit = prices[sellPointer] - prices[buyPointer];
        maxProfit = Math.max(profit, maxProfit);
      } else {
        buyPointer = sellPointer;
      }
      sellPointer = sellPointer + 1;
    }

    return maxProfit;
  }
}
