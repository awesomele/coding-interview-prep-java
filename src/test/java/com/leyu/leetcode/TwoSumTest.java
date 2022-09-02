package com.leyu.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TwoSumTest {

  @Test
  public void test() {
    int[] input = {3, 3};
    int[] output = TwoSum.twoSum(input, 6);
    System.out.println(Arrays.toString(output));
  }
}