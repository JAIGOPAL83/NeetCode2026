package com.jai.neetcode.week1;

public class TopKFrequent {

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2};
    int k = 2;
    System.out.println("Top K Frequent = " + java.util.Arrays.toString(topKFrequent(nums, k)));
  }

  public static int[] topKFrequent(int[] nums, int k) {
    java.util.HashMap<Integer, Integer> freqMap = new java.util.HashMap<>();
    java.util.Arrays.sort(nums);
    for(int num: nums) {
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }
    java.util.TreeMap<Integer, java.util.List<Integer>> indexMap = new java.util.TreeMap<>(java.util.Collections.reverseOrder());
    for(java.util.Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
      int frequency = entry.getValue();
      java.util.List<Integer> numsList = indexMap.getOrDefault(frequency, new java.util.ArrayList<>());
      numsList.add(entry.getKey());
      indexMap.put(frequency, numsList);
    }

    java.util.ArrayList<Integer> topKFrequent = new java.util.ArrayList<>();
    for(java.util.Map.Entry<Integer, java.util.List<Integer>> entry: indexMap.entrySet()) {
      for (int topKValue : entry.getValue()) {
        if (topKFrequent.size() < k) {
          topKFrequent.add(topKValue);
        } else {
          break;
        }
      }
    }
    return topKFrequent.stream().mapToInt(x -> x).toArray();
  }

  public static int[] topKFrequentNeetCode(int[] nums, int k) {
    java.util.Map<Integer, Integer> count = new java.util.HashMap<>();
    java.util.List<Integer>[] freq = new java.util.List[nums.length + 1];

    for (int i = 0; i < freq.length; i++) {
      freq[i] = new java.util.ArrayList<>();
    }

    for (int n : nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }
    for (java.util.Map.Entry<Integer, Integer> entry : count.entrySet()) {
      freq[entry.getValue()].add(entry.getKey());
    }

    int[] res = new int[k];
    int index = 0;
    for (int i = freq.length - 1; i > 0 && index < k; i--) {
      for (int n : freq[i]) {
        res[index++] = n;
        if (index == k) {
          return res;
        }
      }
    }
    return res;
  }

}
