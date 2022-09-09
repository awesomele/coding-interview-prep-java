package com.leyu.playground;

import java.util.Random;

public class RandomDemo {
  public static void random() {
    Random rand = new Random();
    int value = rand.nextInt(10);
    System.out.println(value);
  }

  public static void mathRandom() {
    double value = Math.random();
    System.out.println(value);
  }
}