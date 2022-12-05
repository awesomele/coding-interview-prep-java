package com.leyu.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CountGoodMeals {

  private int[] getTestInput() {
    int size = 100000;
    int[] testInput = new int[size];
    for (int i = 0; i < size; ++i) {
      testInput[i] = 32;
    }
    return testInput;
  }
  public int run( ) {
    var testInput = getTestInput();
    return countPairs(testInput);
  }

  public int countPairs(int[] deliciousness) {
    if (deliciousness.length <= 1) {
      return 0;
    }

    Arrays.sort(deliciousness);
    int lastIdx = deliciousness.length-1;
    int maxSum = deliciousness[lastIdx] + deliciousness[lastIdx-1];
    int maxN = Math.min(maxSum / 2, 21);
    int[] powers = new int[maxN + 1];
    for (int i = 0; i <= maxN; ++i) {
      powers[i] = (int)Math.pow(2, i);
    }

    Map<Integer, Integer> valueToFreq = new TreeMap<>();
    for (int value : deliciousness) {
      if (!valueToFreq.containsKey(value)) {
        valueToFreq.put(value, 1);
      } else {
        valueToFreq.put(value, valueToFreq.get(value) + 1);
      }
    }

    long count = 0;
    for (var entry : valueToFreq.entrySet()) {
      int value1 = entry.getKey();
      int freq1 = entry.getValue();
      for (int sum : powers) {
        if (sum < value1) {
          continue;
        }

        int value2 = sum - value1;
        if (value2 < value1) {
          continue;
        }

        if (!valueToFreq.containsKey(value2)) {
          continue;
        }

        int freq2 = valueToFreq.get(value2);
        if (value1 != value2) {
          count += freq1 * freq2;
        } else if (value1 == value2) {
          if (freq1 > 1) {
            count += getCntOfCombination(freq1);
          }
        } else {
          // no-op
        }
      }
    }

//    int ret = (int)(count);
    return (int)(count % 1000000007);
  }

  private long getCntOfCombination(int freq) {
    long a = (long)freq * (long)(freq-1);
    long b = 2;
    long ret = a / b;
    return ret;
  }

}