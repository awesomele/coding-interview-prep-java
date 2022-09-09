package com.leyu.playground;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class StringDemo {

  private static final String HELLO = "hello";

  public static void initializeString() {
    String a = "hello";
    a = "world";

  }

  public static void valueOf() {
    int i = 'a';
    String a = String.valueOf((char)i);
    System.out.println("a = " + a);
  }

  public static void stringComparison() {
    String a = String.format("hello %d", 1);
    String b = String.format("hello %d", 1);

    boolean doubleEqualOp = a == b; // check if the reference are equal.
    System.out.println("use ==, get " + doubleEqualOp);
    boolean equalOp = a.equals(b); // check if the actual content are equal.
    System.out.println("use equals, get " + equalOp);
  }

  public static void stringAt() {
    String s = "hello";
    for (int i = 0; i < s.length(); ++i) {
      Character c = s.charAt(i);
      System.out.println(c);
    }
  }

  public static void character() {
    Map<Character, Integer> romanLetterToIntegerMap = Map.of(
      'I', 10,
      'V', 100
    );
  }

  public static void convertCharacterListToStringUseStream() {
    List<Character> commonPrefixChars = List.of('l', 'e');
    var ret = commonPrefixChars.stream()
            .map(String::valueOf)
            .collect(Collectors.joining());
    System.out.println(ret);
  }

  public static void convertCharacterListToStringUseStringBuilder() {
    List<Character> commonPrefixChars = List.of('l', 'e');
    StringBuilder sb = new StringBuilder();
    for (Character c : commonPrefixChars) {
      sb.append(c);
    }

    String ret = sb.toString();
    System.out.println(ret);
  }

  // String.valueOf way does not support Character[]
  public static void convertCharArrayToString() {
    char[] chars = {'l','e','y','u'};
    String ret = String.valueOf(chars);
    System.out.println(ret);
  }

  public static void playWithSubString() {
    String a = "hello";
    String sub = a.substring(0, a.length()-1);
    System.out.println(sub);
  }

  public static void isSubString() {
    String a = "hello";
    String b = "hell";
  }

  public static void playWithCharacterList() {
    List<Character> lst = List.of('l', 'e');
    var sb = new StringBuilder();
    for (var c : lst) {
      sb.append(c);
    }

   var s = sb.toString();

  }

  public static void streamJoin() {
    List<String> paths = new ArrayList<>();
    paths.add("hello");
    paths.add("world");
    var ret = paths.stream().collect(Collectors.joining("->"));

  }

  public static void stringBuilder() {
    StringBuilder sb = new StringBuilder();
    sb.append('a');
    sb.append('b');
    sb.append('c');
    System.out.println(sb.toString());
    sb.reverse();
    System.out.println(sb.toString());
    sb.deleteCharAt(0);
    System.out.println(sb.length());
    System.out.println(sb.toString());
    sb.deleteCharAt(0);
    System.out.println(sb.length());
    System.out.println(sb.toString());
  }

  public static void playIntToString() {
    int a = 0;
    System.out.println(String.valueOf(a));
  }

  public static void playStringValueOfOnOptional() {
    String a = null;
    var b = Optional.ofNullable(a);
    var c = b.map(String::valueOf);
    System.out.println(c);
  }

  public static void toCharArray() {
    String s = "abcd";
    char[] chars = s.toCharArray();

    List<Character> lst = new ArrayList<>();
    for(var c : chars) {
      lst.add(c);
    }
  }


}