package com.jai.neetcode.brownbelt;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PlaneSeats {

  public static void main(String[] args) {
    //solution(2, "1A 2F 1C");
    //solution(1, "");
    solution(22, "1A 3C 2B 20G 5A");
  }

  public static int solution(int N, String S) {

    String[] seats = S.split(" ");
    java.util.Arrays.sort(seats);
    System.out.println(java.util.Arrays.toString(seats));

    java.util.HashMap<Integer, Set<String>> seatsMap = new java.util.HashMap<>();
    int total_allocated_family_seats = 0;

    for (String seat : seats) {
      if (!java.util.Objects.equals(seat, "")) {
        Integer rowNumber = Integer.valueOf(seat.substring(0, seat.length() - 1));
        System.out.println("rowNumber = " + rowNumber);
        String seatNumber = seat.substring(seat.length() - 1);
        System.out.println("seatNumber = " + seatNumber);
        if (!seatsMap.containsKey(rowNumber)) {
          Set<String> seatNumbers = new TreeSet<>();
          seatNumbers.add(seatNumber);
          seatsMap.put(rowNumber, seatNumbers);
        } else {
          seatsMap.get(rowNumber).add(seatNumber);
        }
      }
    }

    List<String> possibleSeatCombinations = new java.util.ArrayList<>();
    possibleSeatCombinations.add("BCDE");
    possibleSeatCombinations.add("DEFG");
    possibleSeatCombinations.add("FGHJ");

    for (int i=1; i<=N; i++) {
      if (!seatsMap.containsKey(i)) {
        total_allocated_family_seats += 2;
      } else {
        String seatsAllocated = String.join("", seatsMap.get(i));
        for (String seatCombination : possibleSeatCombinations) {
          if (!isSeatContains(seatsAllocated, seatCombination)) {
            seatsAllocated += seatCombination;
            total_allocated_family_seats += 1;
          }
        }
      }
    }
    System.out.println("Total allocated seats = " + total_allocated_family_seats);
    return total_allocated_family_seats;
  }

  public static boolean isSeatContains(String seatAllocated, String seatCombination) {
    Set<Character> charSet = new HashSet<>();
    for (char c : seatAllocated.toCharArray()) {
      charSet.add(c);
    }

    for (char c : seatCombination.toCharArray()) {
      if (charSet.contains(c)) {
        return true; // Found a common character
      }
    }

    return false;
  }
}
