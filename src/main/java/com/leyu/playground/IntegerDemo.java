package com.leyu.playground;

import java.util.Map;

public class IntegerDemo {
  public static void charCastToInt() {
    int a = 'a';
    int z = 'z';
    System.out.println(a);
    System.out.println(z);
  }

  public static void intRange() {
    int a = 294967296;
    int b = 2000000000;
    long c_long_wrong = a + b;  // <- this is wrong!  the result is overflow.
    long c_long = (long)a + (long)b;
    double c_double_wrong = a + b;
    double c_double = (double)a + (double)b;
    double d = Math.pow(10, 9);
    if (a + b > Integer.MAX_VALUE) {
      System.out.println("overflow!");
    }
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("a + b = " + (a+b));
    System.out.println("c_long = " + c_long);
    System.out.println("d = " + d);
    System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
    System.out.println("Long.MAX_VALUE: " + Long.MAX_VALUE);
    System.out.println("Double.MAX_VALUE: " + Double.MAX_VALUE);
  }

  public static void convertIntToLong() {
    int a = 1;
    long b = a;
//    Long.va
  }


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