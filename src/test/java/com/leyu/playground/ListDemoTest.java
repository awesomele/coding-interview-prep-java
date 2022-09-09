package com.leyu.playground;

import org.junit.jupiter.api.Test;

public class ListDemoTest {
  @Test
  public void testReferenceIsPassedByValue() {
    ListDemo.referenceIsPassedByValue();
  }

  @Test
  public void testStringArrayToList() {
    ListDemo.stringArrayToList();
  }

  @Test
  public void testPlayList() {
    ListDemo.playList();
  }

  @Test
  public void testPlayLinkedList() {
    ListDemo.playLinkedList();
  }

  @Test
  public void testPlayReverseList() {
    ListDemo.playReverseList();
  }
}