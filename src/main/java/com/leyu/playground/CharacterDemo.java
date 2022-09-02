package com.leyu.playground;

import java.util.ArrayList;
import java.util.List;

public class CharacterDemo {
  public static void playCharacterComparison() {
//    Character c1 = 'a';
//    Character c2 = 'a';
//    System.out.println(c1 == c2);

    String s = "aa";
    Character c1 = s.charAt(0);
    Character c2 = s.charAt(1);
    System.out.println(c1 == c2);

    Character c3 = 0 + 48;
    List<Character> lst = new ArrayList<>();
    int digit =1;
    int OFFSET = 2;
    int fine = digit + OFFSET;
    lst.add((char)fine);
    int a = 1;
    int b = 10;
    Math.pow(a,b);
    var c = Double.valueOf(a);

  }
}