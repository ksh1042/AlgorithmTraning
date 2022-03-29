package com.roman14.algorithm;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Algorithms
{
  public static int [] randomIntArray(int size, int suffleTimes)
  {
    int [] result = IntStream.rangeClosed(1,size).toArray();

    int first, second;

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

  /**
   * 정수배열 문자열 출력 메서드
   * - Arrays.toString(int []) 메서드로 대체 가능함에 따라 Deprecated 처리
   * @param numbers - 출력할 정수 배열을 입력
   * @return - 배열을 문자열로 반환
   */
  @Deprecated
  public static String toString(int [] numbers)
  {
    return Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(", ", "{", "}"));
  }
}
