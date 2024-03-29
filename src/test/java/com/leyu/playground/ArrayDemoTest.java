package com.leyu.playground;

import org.junit.jupiter.api.Test;

public class ArrayDemoTest {
  @Test
  public void testFill() {
    ArrayDemo.fill();
  }

  @Test
  public void testIndexOf() {
    ArrayDemo.indexOf();
  }

  @Test
  public void testSubArray() {
    ArrayDemo.subArray();
  }

  @Test
  public void testPlayArray() {
    ArrayDemo.playArray();
  }

  @Test
  public void testReverseSortArray() {
    ArrayDemo.reverseSortArray();
  }

  @Test
  public void testArraySort() {
    ArrayDemo.playArraySort();;
  }

  @Test
  public void testPlayArraySortWithLambda() {
    ArrayDemo.playArraySortWithLambda();
  }

  @Test
  public void testArraySortWithLambda() {
    ArrayDemo.arraySortWithLambda();
  }

  @Test
  public void testArraySortWithComparator() {
    ArrayDemo.arraySortWithComparator();
  }

  @Test
  public void testArraySortWithMethod() {
    ArrayDemo.arraySortWithMethod();
  }
}