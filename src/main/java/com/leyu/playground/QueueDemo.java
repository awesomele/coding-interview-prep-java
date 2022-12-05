package com.leyu.playground;

import java.util.*;

public class QueueDemo {

  public static void playQueue() {
    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    q.poll();
    int[] arr = new int[] {2,3};
    q.addAll(Arrays.stream(arr).boxed().toList());
  }

  List<Object> strings = new ArrayList();
}