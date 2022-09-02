package com.leyu.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/graph-valid-tree/
public class ValidTree {
  public boolean run(int n, int[][] edges) {
    var adjacencyMap = buildAdjacencyMap(n, edges);

    Set<Integer/*node id*/> visited = new HashSet<>();
    return dfs(0, n, adjacencyMap, visited, -1)
            && visited.size() == n;
  }

  private boolean dfs(
          int startNodeId,
          int totalCntOfNodes,
          Map<Integer, Set<Integer>> adjencyMap,
          Set<Integer> visited,
          int parentNodeId) {

    visited.add(startNodeId);

    if (visited.size() == totalCntOfNodes) {
      return true;
    }

    var neighours = adjencyMap.get(startNodeId);
    for (var n : neighours) {
      if (!visited.contains(n)) {
        boolean isValid = dfs(n, totalCntOfNodes, adjencyMap, visited, startNodeId);
        if (!isValid) {
          return false;
        }
      } else {
        if (n != parentNodeId) {
          return false;
        }
      }

    }

    return true;
  }

  private Map<Integer, Set<Integer>> buildAdjacencyMap(int n, int[][] edges) {
    Map<Integer, Set<Integer>> m = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      m.put(i, new HashSet<>());
    }

    for (int i = 0; i < edges.length; ++i) {
      int n1 = edges[i][0];
      int n2 = edges[i][1];
      m.get(n1).add(n2);
      m.get(n2).add(n1);
    }
    return m;
  }
}