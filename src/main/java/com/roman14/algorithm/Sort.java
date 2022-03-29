package com.roman14.algorithm;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 정렬 알고리즘
 * @author MDH
 * @since 2022.03.24
 */
public class Sort
{
  /**
   * <b>교체</b>
   * <pre>
   *   배열의 원소 위치를 변경
   * </pre>
   * @param numbers 배열의 원소 위치를 변경할 정수 배열
   * @param pos1 변경할 위치 1
   * @param pos2 변경할 위치 2
   */
  private static void swap(int [] numbers, int pos1, int pos2)
  {
    int temp = numbers[pos1];
    numbers[pos1] = numbers[pos2];
    numbers[pos2] = temp;
  }

  /**
   * <b>선택 정렬</b>
   * <pre>
   * - 시간복잡도 : O(Math.pow(N,2))
   * </pre>
   * @param numbers 정렬할 정수 배열
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
      swap(numbers, i , index);
    }
  }


  /**
   * <b>버블 정렬</b>
   * <pre>
   * - 시간 복잡도 : O(Math.pow(N,2))
   * ※ 기본적으로 선택 정렬과 동일한 시간 복잡도를 지니나, 교체작업이 빈번히 이뤄지므로 실질적으로 버블 정렬에 비해 정렬 속도가 현저히 느리다.
   * </pre>
   * @param numbers 정렬할 정수 배열
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
          swap(numbers, i, j);
        }
      }
    }
  }

  /**
   * <b>삽입 정렬</b>
   * <pre>
   * - 시간 복잡도 : O(Math.pow(N,2))
   * ※ 기본적으로 선택, 버블 정렬과 동일한 시간복잡도를 가지나 거의 정렬된 상태의 대상에 대해 가장 빠른 속도를 보인다.
   * </pre>
   * @param numbers 정렬할 정수 배열
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
   * <b>퀵 정렬</b>
   * <pre>
   * - 시간 복잡도 : O(N * log(N))
   * - 분할정복 알고리즘을 사용
   * - 기준(피벗) 값을 사용
   * </pre>
   * @param numbers 정렬할 정수 배열
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
    int pivot = numbers[(start + end) / 2];

    int temp;

    while ( start <= end )
    {
      while ( pivot > numbers[start] ) start++;
      while ( pivot < numbers[end] ) end--;
      if ( start <= end )
      {
        swap(numbers, start, end);
        start++;
        end--;
      }
    }
    return start;
  }

  /**
   * <b>병합 정렬</b>
   * <pre>
   * - 시간 복잡도 : O(N*log(N))
   * - 퀵 정렬과 비슷한 시간복잡도를 지니나, pivot의 위치에 따라 시간 복잡도가 O(pow(N,2)) 만큼 늘어날 수 있는 퀵 정렬와는 달리 병합 정렬은 O(N*log(N))의 일정한 시간복잡도를 가진다
   * </pre>
   * @param numbers 정렬할 정수 배열
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

  /**
   * <h2>힙 정렬</h2>
   * <pre>
   * - 시간 복잡도 : O(N*log(N))
   * - 1차원 배열을 응용한 완전 2진 트리 힙 정렬
   * </pre>
   * <pre>
   * ■ 각 노드의 탐색방법
   * - leftChild  : target * 2 + 1
   * - rightChild : target * 2 + 2
   * - parent     : (target-1) / 2
   * - isLeaf     : numbers.length / 2 < target
   * </pre>
   * @param numbers 정렬할 정수 배열
   */
  public static void heapSort(int [] numbers)
  {
    heapify(numbers, numbers.length);

    for(int i=numbers.length-1; i>=0; i--)
    {
      swap(numbers, 0, i);
      heapify(numbers, i);
    }
  }
  private static void heapify(int [] numbers, int length)
  {
    for(int i=1; i<length; i++)
    {
      int target = i;
      do
      {
        int parent = (target -1) / 2;
        if(numbers[parent] < numbers[target])
        {
          swap(numbers, parent, target);
        }
        target = parent;
      }
      while(target != 0);
    }
  }
}
