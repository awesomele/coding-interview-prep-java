package com.leyu.playground;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {
  public static void playSortedSet() {
    SortedSet<String> s = new TreeSet<>();
    s.addAll(List.of("le", "hao"));
    System.out.println(s.toString());
  }

  public static void intSortedSet() {
    SortedSet<Integer> sortedSet = new TreeSet<>();
    for (int i = 0; i < 10; ++i) {
      sortedSet.add(i);
    }
  }
}