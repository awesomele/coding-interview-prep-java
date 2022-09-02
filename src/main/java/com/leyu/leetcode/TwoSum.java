package com.leyu.leetcode;

import java.util.*;

public class TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, List<Integer>> valueToIndexes = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      if (valueToIndexes.containsKey(nums[i])) {
        valueToIndexes.get(nums[i]).add(i);
      } else {
        valueToIndexes.put(nums[i], new ArrayList<>(Arrays.asList(i)));
      }
    }

    Arrays.sort(nums);
    int left = 0;
    int right = nums.length-1;
    while (left < right) {
      int remained = target - nums[left];
      if (remained == nums[right]) {
        if (nums[left] != nums[right]) {
          return new int[]{ valueToIndexes.get(nums[left]).get(0), valueToIndexes.get(nums[right]).get(0) };
        } else {
          return new int[]{ valueToIndexes.get(nums[left]).get(0), valueToIndexes.get(nums[right]).get(1) };
        }
      } else if (remained > nums[right]) {
        ++left;
      } else {
        --right;
      }
    }
    return new int[]{-1, -1};
  };
}