package com.leyu.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DijkstraPrototypeTest {
  @Test
  public void testOne() {
    int[][] roads = new int[][]{{0,1,1},{0,2,3},{1,2,1}};
    int n = 3;

    int actual =  DijkstraPrototype.getShortestPath(n, roads);
    assertThat(actual).isEqualTo(2);
  }

  @Test
  public void testTwo() {
    int[][] roads = new int[][]{{0,6,10},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1}};
    int n = 7;

    int actual =  DijkstraPrototype.getShortestPath(n, roads);
    assertThat(actual).isEqualTo(7);
  }

  @Test
  public void testThree() {
    int[][] roads = new int[][]{{0,6,1},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1}};
    int n = 7;

    int actual =  DijkstraPrototype.getShortestPath(n, roads);
    assertThat(actual).isEqualTo(1);
  }
}