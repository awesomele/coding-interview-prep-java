package com.leyu.playground;

import org.junit.jupiter.api.Test;

public class RandomDemoTest {
  @Test
  public void test() {
    for (int i = 0; i < 10; ++i) {
      RandomDemo.random();
    }
  }

  @Test
  public void testMathRandom() {
    for (int i = 0; i < 10; ++i) {
      RandomDemo.mathRandom();
    }
  }
}