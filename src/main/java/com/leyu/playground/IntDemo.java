package com.leyu.playground;

public class IntDemo {

  public static void charCastToInt() {
    int a = 'a';
    int z = 'z';
    System.out.println(a);
    System.out.println(z);
  }

  public static void intRange() {
    int a = 294967296;
    int b = 2000000000;
    long c = a + b;
    double d = Math.pow(10, 9);
    if (a + b > Integer.MAX_VALUE) {
      System.out.println("overflow!");
    }
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("c = " + c);
    System.out.println("d = " + d);
    System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
  }

  public static void convertIntToLong() {
    int a = 1;
    long b = a;
//    Long.va
  }
}