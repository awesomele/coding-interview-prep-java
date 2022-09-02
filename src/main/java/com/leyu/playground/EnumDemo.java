package com.leyu.playground;

import java.util.EnumSet;

public class EnumDemo {
  private enum Color {
    RED,
    YELLOW,
    BLACK
  }

  public static void enumSet() {
//        var a = EnumSet.allOf(Color.class);
//        var a = EnumSet.noneOf(Color.class);
    var a = EnumSet.of(Color.RED, Color.BLACK);
    System.out.println(a);
  }

  public static void castEnumToInt() {
    // Ordinals are fixed by starting at 0 and working up, cannot be customized
    var a = Color.BLACK.ordinal();
    System.out.println(a);
  }

  public static void playWithEquals() {
    System.out.println(Color.RED.equals(Color.YELLOW));
  }
}