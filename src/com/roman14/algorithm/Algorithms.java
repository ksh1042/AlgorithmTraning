package com.roman14.algorithm;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Algorithms
{
  public static int [] randomIntArray(int size, int suffleTimes)
  {
    int [] result = IntStream.rangeClosed(1,size).map( it -> it ).toArray();

    int first = 0, second = 0;

    for(int i=0; i<suffleTimes; i++)
    {
      first = (int)(Math.random()* size);
      second = (int)(Math.random()* size);

      int temp = result[first];
      result[first] = result[second];
      result[second] = temp;
    }

    return result;
  }

  public static String toString(int [] numbers)
  {
    return Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(", ", "{", "}"));
  }
}
