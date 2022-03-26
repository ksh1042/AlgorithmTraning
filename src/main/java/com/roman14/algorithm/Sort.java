package com.roman14.algorithm;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 정렬 알고리즘
 * @author MDH
 * @since 2022.03.24
 */
public class Sort
{
  private static void swap(int [] numbers, int pos1, int pos2)
  {
    int temp = numbers[pos1];
    numbers[pos1] = numbers[pos2];
    numbers[pos2] = temp;
  }

  /**
   * 선택정렬 알고리즘
   * 시간복잡도 : O(Math.pow(N,2))
   * @param numbers - 정렬할 정수 배열
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
   * @param numbers- 정렬할 정수 배열
   */
  public static void bubbleSort(int [] numbers)
  {
    if(numbers.length < 2) return;

    int temp = 0;

    for(int i=0; i<numbers.length-1; i++)
    {
      for(int j=i; j<numbers.length; j++)
      {
        if(numbers[i] > numbers[j])
        {
          swap(numbers, i, j);
        }
      }
    }
  }

  /**
   * 삽입 정렬
   * 시간 복잡도 : O(Math.pow(N,2))
   * ※ 기본적으로 선택, 버블 정렬과 동일한 시간복잡도를 가지나 거의 정렬된 상태의 대상에 대해 가장 빠른 속도를 보인다.
   * @param numbers - 정렬할 정수 배열
   */
  public static void insertionSort(int [] numbers)
  {
    if(numbers.length < 2) return;

    for(int i=0; i<numbers.length-1; i++)
    {
      int j = i;
      while(numbers[j] >  numbers[j+1])
      {
        swap(numbers, j, j+1);
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
   * @param numbers - 정렬할 정수 배열
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

    int temp = 0, s = start, e = end;

    while( s<=e )
    {
      while(pivot > numbers[s]) s++;
      while(pivot < numbers[e]) e--;
      if(s <= e)
      {
        swap(numbers, s, e);
        s++;
        e--;
      }
    }
    return s;
  }

  /**
   * 병합 정렬
   * 시간 복잡도 : O(N*log(N))
   * 퀵소트와 비슷한 시간복잡도를 지니나 pivot의 위치에 따라 O(pow(N,2)) 만큼 늘어날 수 있는 퀵소트와는 달리 병합 정렬은 O(N*log(N))의 일정한 시간복잡도를 가진다
   * @param numbers - 정렬할 정수 배열
   */
  public static void mergeSort(int [] numbers)
  {
    int [] temp = new int[numbers.length];

    mergeSort(numbers, temp, 0, numbers.length-1);
  }
  private static void mergeSort(int [] numbers, int [] temp, int start, int end)
  {
    if(start < end){
      int middle = (start+end) / 2;

      mergeSort(numbers, temp, start, middle);  // 절반 기준으로 앞에 부분의 정렬을 재귀적으로 호출하여 정렬 수행
      mergeSort(numbers, temp, middle+1, end);
      merge(numbers, temp, start, middle, end);

      System.out.println(Algorithms.toString(numbers) + " " + Algorithms.toString(temp));

    }
  }
  private static void merge(int [] numbers, int [] temp, int start, int middle, int end)
  {
    for(int i= start; i<=end; i++)
    {
      temp[i] = numbers[i];
    }
    int part1 = start;
    int part2 = middle + 1;
    int index = start;

    while(part1 <= middle && part2 <= end)
    {
      if(temp[part1] <= temp[part2])
      {
        numbers[index] = temp[part1];
        part1++;
      }
      else
      {
        numbers[index] = temp[part2];
        part2++;
      }
      index++;
    }

    for(int i=0; i<= middle - part1; i++)
    {
      numbers[index + i] = temp[part1 + i];
    }
  }
}
