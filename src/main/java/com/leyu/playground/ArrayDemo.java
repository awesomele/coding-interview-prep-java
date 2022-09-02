package com.leyu.playground;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayDemo {

  public static void indexOf() {
    int[] arr = {1, 2, 3, 4, 5};
    int idx = Arrays.stream(arr).boxed().toList().indexOf(3);
    System.out.println(idx);
  }

  public static void subArray() {
    int[] arr = {1, 3, 2, 1, 0};
    System.out.println(Arrays.toString(arr));

    int[] sub = Arrays.copyOfRange(arr, 0, 1);
    System.out.println(Arrays.toString(sub));
  }

  public static void playArray() {
//        int[] arr = {1, 2, 3};
//        System.out.println(Arrays.toString(arr));
//        System.out.println(arr.length);
//        arr[0] = 10;
//        System.out.println(Arrays.toString(arr));
//        arr[arr.length] = 4; // exception fixed size
//        System.out.println(Arrays.toString(arr));

    int[] arr2 = new int[10];
    System.out.println(Arrays.toString(arr2));
    System.out.println(arr2.length);

    for (int i : arr2) {

    }
  }

  public static void playArraySort() {
    int[] arr = {1, 3, 2, 1, 0};
    System.out.println(Arrays.toString(arr));
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void playArraySortWithLambda() {
    int[][] arr = {{1,4}, {0,3}, {1,3}};

    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.deepToString(arr));  // <--- int[][] is an array of object

    Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));
//    Arrays.sort(arr, Comparator.comparingInt(item -> item[0]).thenComparing());

    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.deepToString(arr));
  }

  public static void reverseSortArray() {
    int[] array = new int[] {2,1,3};
    System.out.println(Arrays.toString(array));

    Arrays.sort(array);
    System.out.println(Arrays.toString(array));

    // Arrays.sort(array, Collections.reverseOrder());  // <---- Collections.reverseOrder() cannot use on primitive array, needs to be Integer[]
    var lst= Arrays.stream(array).boxed().collect(Collectors.toList());
    Collections.sort(lst, Collections.reverseOrder());
    System.out.println(lst);
  }

  private static int[] foo() {

    return new int[]{1, 2};
  }

}