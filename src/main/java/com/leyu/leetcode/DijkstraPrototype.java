package com.leyu.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class DijkstraPrototype {

  private record AdjacencyMapValue(int id, int cost) {

  }

  private record PriorityQueueValue(int id, Integer cost, Integer prev) {

  }

  public static int getShortestPath(int n, int[][] roads) {

    Map<Integer, List<AdjacencyMapValue>> adjacencyMap = buildAdjacencyMapMap(roads);
    int src = 0;
    int dest = n-1;
    return bfs(src, dest, adjacencyMap);
  }

  private static int bfs(int src, int dest, Map<Integer, List<AdjacencyMapValue>> adjacencyMap) {
    Map<Integer, PriorityQueueValue> visited = new HashMap<>();
    PriorityQueue<PriorityQueueValue> pq = new PriorityQueue<>(Comparator.comparing(PriorityQueueValue::cost));

    pq.add(new PriorityQueueValue(src, 0, null));
    while (!pq.isEmpty()) {
      PriorityQueueValue node = pq.poll();
      if (!visited.containsKey(node.id)) {
        visited.put(node.id, node);
      }

      List<AdjacencyMapValue> neighbors = adjacencyMap.get(node.id);
      for (var neighbor : neighbors) {
        int neighborId = neighbor.id;
        if (visited.containsKey(neighborId)) {
          continue;
        }

        int cost = node.cost + neighbor.cost;
        pq.add(new PriorityQueueValue(neighborId, cost, node.id));
      }
    }

    System.out.println(reconstructPath(dest, visited));

    return visited.get(dest).cost;
  }

  private static String reconstructPath(int dest, Map<Integer, PriorityQueueValue> visited) {
    List<Integer> lst = new ArrayList<>();
    lst.add(dest);

    Integer prev = visited.get(dest).prev;

    while (prev != null) {
      lst.add(prev);
      prev = visited.get(prev).prev;
    }

    Collections.reverse(lst);
    return lst.stream().map(String::valueOf).collect(Collectors.joining("->"));
  }

  private static Map<Integer, List<AdjacencyMapValue>> buildAdjacencyMapMap(int[][] roads) {
    Map<Integer, List<AdjacencyMapValue>> adjacencyMap = new HashMap<>();
    for (int i = 0;  i < roads.length; ++i) {
      int[] road = roads[i];
      int src = road[0];
      int dest = road[1];
      int cost = road[2];
      if (!adjacencyMap.containsKey(src)) {
        adjacencyMap.put(src, new ArrayList<>());
      }
      if (!adjacencyMap.containsKey(dest)) {
        adjacencyMap.put(dest, new ArrayList<>());
      }
      adjacencyMap.get(src).add(new AdjacencyMapValue(dest, cost));
      adjacencyMap.get(dest).add(new AdjacencyMapValue(src, cost));
    }
    return adjacencyMap;
  }

}