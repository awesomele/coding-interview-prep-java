package com.leyu.playground;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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

  public static void treeMap() {
    Map<Integer, String> unsortedMap = Map.of(
            11,"marcus",
            3, "le",
            2,"hao"
    );

    Map<Integer, String> sortedMap = new TreeMap<>(unsortedMap);

    for (var entry : sortedMap.entrySet()) {
      System.out.println(String.format("key = %s, value = %s", entry.getKey(), entry.getValue()));
    }
  }

  public static void LinkedHashMap() {

  }
}