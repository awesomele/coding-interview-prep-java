package com.leyu.playground;

import java.util.*;
import java.util.stream.Collectors;

public class ListDemo {

  public static void intArrayToList() {
    int[] arrays = new int[]{1,2,3};
//    List<Integer> lst = Arrays.asList(arrays);  // <--- we need Integer[] to use Arrays.asList to convert
    List<Integer> unmodifiableList = Arrays.stream(arrays).boxed().toList();
    List<Integer> lst = Arrays.stream(arrays).boxed().collect(Collectors.toList());
  }

  public static void stringArrayToList() {
    String[] arrays = new String[]{"hello","world"};
    List<String> unmodifiableList = Arrays.stream(arrays).toList();
    List<String> lst = Arrays.stream(arrays).collect(Collectors.toList());
    System.out.println(unmodifiableList);
    System.out.println(lst);
  }

  public static void referenceIsPassedByValue() {
    List<Integer> lst = new ArrayList<>();
    lst.add(1);
    lst.add(2);
    tryToChangeTheReference(lst);
    System.out.println(lst);
  }

  private static void tryToChangeTheReference(List<Integer> lst) {
    lst = new ArrayList<>();
    lst.add(3);
    lst.add(4);
//    lst.removeLast();
  }

  public static void linkedList() {
    var lst = new LinkedList<>();
    lst.add(3);
    lst.add(4);
    lst.removeLast();
  }

  public static void playList() {
    List lst = null;

    lst = new ArrayList<Integer>(Arrays.asList(1,2,3)); // modifiable
    lst.add(4);
    lst.set(0, 10);
    System.out.println(lst);
    lst.get(1);
    lst.contains(1);
    lst.add(0,-1);


//        lst = Arrays.asList(1,2,3);  // immutable on size but can edit the element
//        lst.add(4); // exception
//        lst.set(0, 10);
//        System.out.println(lst);

//        lst = List.of(1,2,3);  // a true immutable
//        lst.add(4);  // exception
//        lst.set(0, 10);  // exception
//        System.out.println(lst);

  }

  public static void playLinkedList() {
    List<Character> resultInChar = new LinkedList<>();
    resultInChar.add(0, 'a');
    resultInChar.add(0, 'b');
    System.out.println(resultInChar.toString());
  }

  public static void playSubList() {
    List<Integer> lst = Arrays.asList(1,2,3,4);
    var subList = lst.subList(1, lst.size()-1 /*exclusive*/);
    Collections.sort(subList);
  }

  public static void playIndexOf() {
    List<Integer> lst = Arrays.asList(1,2,3,4);
    var index = lst.indexOf(1);
  }

  public static void playArraylist() {

  }

  public static void playReverseList() {
    List<Integer> lst = Arrays.asList(1,2,3,4);
    Collections.reverse(lst);
    System.out.println(lst.toString());


    List<List<Integer>> lstOfLst = new ArrayList<>();
    lstOfLst.add(Arrays.asList(1,2,3));
    lstOfLst.add(Arrays.asList(1,2));
    lstOfLst.add(Arrays.asList(1));
    System.out.println(lstOfLst.toString());
    Collections.reverse(lstOfLst);
    System.out.println(lstOfLst.toString());

  }
}