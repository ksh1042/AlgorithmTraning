package com.roman14.algorithm;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sort
{
  /**
   * 선택정렬 알고리즘
   * 시간복잡도 : O(Math.pow(N,2))
   * @param numbers - The array to sort.
   */
  public static void selectionSort(int [] numbers)
  {
    if(numbers.length < 2) return;

    int index = 0, temp;

    for(int i=0; i<numbers.length; i++)
    {
      int min = Integer.MAX_VALUE;
      for(int j=i; j<numbers.length; j++)
      {
        if(min > numbers[j])
        {
          min = numbers[j];
          index = j;
        }
      }
      temp = numbers[i];
      numbers[i] = numbers[index];
      numbers[index] = temp;
    }
  }


  /**
   * 버블 정렬
   * 시간 복잡도 : O(Math.pow(N,2))
   * ※ 기본적으로 선택 정렬과 동일한 시간 복잡도를 지니나, 교체작업이 빈번히 이뤄지므로 실질적으로 버블 정렬에 비해 정렬 속도가 현저히 느리다.
   * @param numbers - The array to sort.
   */
  public static void bubbleSort(int [] numbers)
  {
    if(numbers.length < 2) return;

    int temp;

    for(int i=0; i<numbers.length-1; i++)
    {
      for(int j=i; j<numbers.length; j++)
      {
        if(numbers[i] > numbers[j])
        {
          temp = numbers[i];
          numbers[i] = numbers[j];
          numbers[j] = temp;
        }
      }
    }
  }

  /**
   * 삽입 정렬
   * 시간 복잡도 : O(Math.pow(N,2))
   * ※ 기본적으로 선택, 버블 정렬과 동일한 시간복잡도를 가지나 거의 정렬된 상태의 대상에 대해 가장 빠른 속도를 보인다.
   * @param numbers - The array to sort.
   */
  public static void insertionSort(int [] numbers)
  {
    if(numbers.length < 2) return;

    int j, temp;

    for(int i=0; i<numbers.length-1; i++)
    {
      j = i;
      while(numbers[j] >  numbers[j+1])
      {
        temp = numbers[j];
        numbers[j] = numbers[j+1];
        numbers[j+1] = temp;
        j--;
        if(j < 0) break;
       }
    }
  }

  /**
   * 퀵 정렬
   * 시간 복잡도 : O(N * log(N))
   * 분할정복 알고리즘을 사용
   * 기준(피벗) 값을 사용
   * @param numbers - The array to sort.
   */
  public static void quickSort(int [] numbers)
  {
    quickSort(numbers, 0, numbers.length-1);
  }
  private static void quickSort(int [] numbers, int start, int end)
  {
    if(numbers.length <= 1 || start > end) return;

    int part2 = partition(numbers, start, end);

    if(start < part2-1)
    {
      quickSort(numbers, start, part2-1);
    }
    if(part2 < end)
    {
      quickSort(numbers, part2, end);
    }
  }
  private static int partition(int [] numbers, int start, int end)
  {
    int pivot = numbers[(start+end) / 2];

    int temp;

    while( start<=end )
    {
      while(pivot > numbers[start]) start++;
      while(pivot < numbers[end]) end--;
      if(start <= end)
      {
        temp = numbers[start];
        numbers[start] = numbers[end];
        numbers[end] = temp;
        start++;
        end--;
      }
    }
    return start;
  }
}
