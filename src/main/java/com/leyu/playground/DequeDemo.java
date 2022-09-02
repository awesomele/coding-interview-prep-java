package com.leyu.playground;

import java.util.Deque;
import java.util.LinkedList;

// double ended queue
// offer [First | Last]
// pull [First | Last]
// peak [First | Last]
public class DequeDemo {
  public static void playDequeue() {
    Deque<Integer> dq = new LinkedList<>();
    for (int i = 9; i >= 0; --i) {
      dq.offerLast(i);
    }
    while (dq.peekFirst() != null) {
      System.out.print(dq.pollFirst());
    }
  }
}