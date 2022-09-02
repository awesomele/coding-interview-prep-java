package com.leyu.playground;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetDemo {
  public static void playSet() {
    Set<Integer> values = new HashSet<>();
    values.add(1);
    values.contains(1);
    values.addAll(List.of(1,2,3));

    for (var val : values) {

    }

    Set<Integer> values2 = new HashSet<>(List.of(1,2,3));

  }

  public static void toList() {
    Set<Integer> values = new HashSet<>();
    values.addAll(List.of(1,2,3));
    System.out.println("values = " + values);

    List<Integer> lst;
    lst = new ArrayList<>(values);
    System.out.println("lst = " + lst);

    lst = values.stream().toList(); // unmodifiableList
    System.out.println("lst = " + lst);
    // lst.add(4);  // UnsupportedOperationException due to unmodifiableList

    lst = values.stream().collect(Collectors.toList()); // mutable
    System.out.println("lst = " + lst);
    lst.add(4);
    System.out.println("lst = " + lst);


  }
}