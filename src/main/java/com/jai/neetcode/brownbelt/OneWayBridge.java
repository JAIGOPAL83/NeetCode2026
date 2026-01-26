package com.jai.neetcode.brownbelt;

public class OneWayBridge {

  public static void main(String[] args) {
    System.out.println("Solution = " + solution(9, new int[] {5, 3, 8, 1, 8, 7, 7, 6}));
  }

  public static int solution(int U, int[] weights) {
    java.util.List<Integer> carsBridgeQueue = new java.util.LinkedList<>();
    int noOfRemovals = 0;

    for (int currentCar : weights) {
      // 1. If a single car is over the limit, it must turn back immediately
      if (currentCar > U) {
        noOfRemovals++;
        continue;
      }

      // 2. Check if adding this car exceeds the limit with the car already there
      if (!carsBridgeQueue.isEmpty()) {
        if (carsBridgeQueue.get(0) + currentCar > U) {
          // Limit exceeded! This driver turns back.
          noOfRemovals++;
          // We DON'T add it to the queue, and the car already in the queue stays there
          continue;
        }
      }

      // 3. If it fits, it enters the bridge
      carsBridgeQueue.add(currentCar);

      // 4. Maintenance: If there are now 2 cars, the first one will leave
      // to make room for the next iteration's "lead" car.
      if (carsBridgeQueue.size() > 1) {
        carsBridgeQueue.remove(0);
      }
    }

    return noOfRemovals;
  }
}
