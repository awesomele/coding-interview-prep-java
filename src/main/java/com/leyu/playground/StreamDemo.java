package com.leyu.playground;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
  public static void playCollector() {
    Double[] a = { 1.0, 3.0, 5.0, 7.0 };
    Double[] b = { 2.0, 4.0, 6.0, 8.0 };
    List<Double[]> embeddings = List.of(a, b);

    var shit = IntStream.range(0, a.length)
            .mapToObj(i -> generateList(embeddings, i)).toList();
    System.out.println(shit);

//        List<Double> listA = Arrays.asList(a);
//        List<Double> listB = Arrays.asList(b);
//        Stream<Double> combined = Stream.concat(listA.stream(), listB.stream());
//        System.out.println(combined.toList());
  }

  private static List<Double> generateList(List<Double[]> lst, int index) {
    return lst.stream().map(array -> array[index]).toList();
  }
}