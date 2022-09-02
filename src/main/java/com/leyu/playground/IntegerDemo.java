package com.leyu.playground;

import java.util.Map;

public class IntegerDemo {
  public static void integerComparison() {
    Integer a = 10;
    Integer b = 2;
    b = 10;

    Map<Integer, Integer> m = Map.of(10,10);

    boolean isSameOne = a == b;
    boolean isSameTwo = a.equals(b);
    System.out.println("a == b is " + isSameOne);
    System.out.println("a.equals(b) " + isSameTwo);

    boolean isSameThree = a == m.get(a);
    boolean isSameFour= a.equals(m.get(a));
    System.out.println("a == m.get(a) is " + isSameThree);
    System.out.println("a.equals(m.get(a)) " + isSameFour);
  }
}