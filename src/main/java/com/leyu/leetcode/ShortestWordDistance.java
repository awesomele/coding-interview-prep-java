package com.leyu.leetcode;

import java.util.*;

public class ShortestWordDistance {
  public int shortestDistance(String[] wordsDict, String word1, String word2) {
    Map<String, List<Integer>> m = new HashMap<>();
    for (int i = 0; i < wordsDict.length; ++i) {
      if (m.containsKey(wordsDict[i])) {
        m.get(wordsDict[i]).add(i);
      } else {
        m.put(wordsDict[i], new ArrayList<>(Arrays.asList(1)));
      }
    }

    List<Integer> lst1 = m.get(word1);
    List<Integer> lst2 = m.get(word2);
    int ret = Integer.MAX_VALUE;
    for (var p1 : lst1) {
      for (var p2 : lst2) {
        ret = Math.min(Math.abs(p1-p2), ret);
      }
    }
    return ret;
  }
}