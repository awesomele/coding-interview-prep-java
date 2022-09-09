package com.leyu.playground;

import java.util.*;

public class CommonAPIS {
  public static int maxInt = Integer.MAX_VALUE;

  public static int minInt = Integer.MIN_VALUE;
  
  public static long maxLong = Long.MAX_VALUE;
  
  public static double maxDouble = Double.MAX_VALUE;

  public static void initializeListWithLiterals() {
    // initialize a list with literals
    List<Integer> integerList = new ArrayList<>(Arrays.asList(1,2,3));
    List<String> stringList = new LinkedList<>(Arrays.asList("a", "b", "c"));

    // initialize a set with literal values
    Set<Integer> integerSet = new HashSet<>(List.of(1,2,3));

    // initialize an array
    int[][] twoDimIntegerArray = new int[3][4];  // row cnt is 3 and col cnt is 4;
    int[][] twoDimIntegerArrayInitWithLiteral = new int[][]{{1,1},{2,2}};

    // sort a list
    List<Integer> unsortedIntegerList = new ArrayList<>(Arrays.asList(2,1,3));
    Collections.sort(unsortedIntegerList); // sort is in-place

    // sort an array
    int[] unsortedIntArray = new int[]{2,1,3};
    Arrays.sort(unsortedIntArray);

    // iterate a map
    var m = Map.of(
      "1", "le",
      "2", "hao"
    );
    for (var entry : m.entrySet()) {
      var key = entry.getKey();
      var value = entry.getValue();
    }

    // get subList
    List<Integer> theCompleted = new ArrayList<>(Arrays.asList(1,2,3));
    List<Integer> theSubList = theCompleted.subList(1,theCompleted.size() /*exclusive*/);

    // get subString
    String completedString = "hello";
    String subString = completedString.substring(1,completedString.length());
  }

}