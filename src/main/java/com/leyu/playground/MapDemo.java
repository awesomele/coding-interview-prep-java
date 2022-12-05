package com.leyu.playground;

import java.util.*;

public class MapDemo {
  public static void playMap() {
    Map<Integer, Integer> mem = Map.of(
            1,2,
            3,4
    );

    mem.getOrDefault(4, -1);

    for (var entry : mem.entrySet()) {
//      if (entry.getValue().size() == 0) {
//
//      }
    }
  }
  public static void playHashMap() {

  }

  public static void removeValueFromMap() {
    Map<Integer, String> unsortedMap = new HashMap<>();

    unsortedMap.put(11,"marcus");
    unsortedMap.put(3, "le");
    unsortedMap.put(2,"hao");
    var keys = unsortedMap.keySet();

    System.out.println("unsortedMap = " + unsortedMap);
    System.out.println("remove le (key is 3)");
    unsortedMap.remove(3);
    System.out.println("unsortedMap = " + unsortedMap);
  }

  public static void treeMap() {
    Map<Integer, String> unsortedMap = Map.of(
            11,"marcus",
            3, "le",
            2,"hao"
    );

    TreeMap<Integer, String> sortedMap = new TreeMap<>(unsortedMap);

    System.out.println("sorted map entry:");
    for (var entry : sortedMap.entrySet()) {
      System.out.println(String.format("key = %s, value = %s", entry.getKey(), entry.getValue()));
    }
  }

  public static void higherKey() {
    Map<Integer, String> unsortedMap = Map.of(
            11,"marcus",
            3, "le",
            2,"hao"
    );

    TreeMap<Integer, String> sortedMap = new TreeMap<>(unsortedMap);

    for (var entry : sortedMap.entrySet()) {
      System.out.println(String.format("key = %s, value = %s", entry.getKey(), entry.getValue()));
    }

    System.out.println(String.format("sortedMap.lowerKey(3) = %s",  sortedMap.lowerKey(3)));
    System.out.println(String.format("sortedMap.floorKey(3) = %s",  sortedMap.floorKey(3)));
  }

  public static void comparisonLinkedHashMapVsHashMapOnTheEntryOrdering() {
    Map<Integer, Integer> map = new HashMap<>();
    LinkedHashMap<Integer, Integer> map2 = new LinkedHashMap<>();
    for (int i =0; i < 80000; ++i) {
      map.put(i, i);
      map2.put(i,i);
    }

    int idx = 0;
    int countOfNotInSameOrder = 0;
    for (var entry : map.entrySet()) {
      int key = entry.getKey();
      if (key != idx) {
        ++countOfNotInSameOrder;
      }
      ++idx;
    }
    System.out.println("HashMap, countOfNotInSameOrder = " + countOfNotInSameOrder);


    idx = 0;
    countOfNotInSameOrder = 0;
    for (var entry : map2.entrySet()) {
      int key = entry.getKey();
      if (key != idx) {
        ++countOfNotInSameOrder;
      }
      ++idx;
    }
    System.out.println("LinkedHashMap, countOfNotInSameOrder = " + countOfNotInSameOrder);
  }

  public static void linkedHashMapChangeTheOrder() {
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    for (int i =0; i < 3; ++i) {
      map.put(i, i);
    }

    System.out.println("LinkedHashMap: initial setup");
    for (var entry : map.entrySet()) {
      System.out.println(entry.toString());
    }
  }
}