package com.leyu.playground;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class PriorityQueueDemo {

  private record Data(int id, int distance) {
  }

  public static void minHeap() {
    Queue<Integer> min = new PriorityQueue<>();
    Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < 10; ++i) {
      min.add(i);
      max.add(i);
    }

    System.out.println(min);
    System.out.println(max);
  }

  public static void customizedComparator() {
   // Queue<Data> min = new PriorityQueue<Data>((a, b) -> Integer.compare(a.distance, b.distance));
   // Queue<Data> min = new PriorityQueue<Data>((a, b) -> {return a.distance -  b.distance;}); // <-- same effect
//    Queue<Data> min = new PriorityQueue<Data>((a, b) -> a.distance -  b.distance);
//    Queue<Data> max = new PriorityQueue<Data>(Comparator.comparing(Data::distance).reversed());

    Queue<Data> min = new PriorityQueue<Data>(Comparator.comparing(Data::distance));
    for (int i = 0; i < 2; ++i) {
      min.add(new Data(i, 10 - i));
    }

    System.out.println(min);
  }

}