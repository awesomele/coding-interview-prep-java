package com.leyu.playground;

import java.util.Stack;

public class StackDemo {

  public static void playWithStack() {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < 10; ++i) {
      stack.push(i);
    }
    while (!stack.empty()) {
      System.out.println(stack.pop());
    }
  }
}