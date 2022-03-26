package com.roman14.main;

import com.roman14.algorithm.Algorithms;
import com.roman14.algorithm.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SortMain
{
  public static void main(String[] args)
  {
    final int size = 1500;
    final int suffleTimes = size * 3;

    int [] numbers = Algorithms.randomIntArray(size, suffleTimes);
    //List<Integer> list = Arrays.stream(numbers).mapToObj(Integer::valueOf).collect(Collectors.toList());

    System.out.println(Algorithms.toString(numbers));

    long startTime = System.currentTimeMillis();

    // TODO -> place test Algorithm source over here.
    // !!DEBUG ONLY!!

    Sort.quickSort(numbers);

    System.out.println(Algorithms.toString( numbers ));

    //);Sort.quickSort(numbers);
    //Arrays.sort(numbers);
    //list.stream().sorted().collect(Collectors.toList());

    System.out.println( "cost = " + ((double)(System.currentTimeMillis() - startTime) / 1000)  + " sec" );
  }
}
