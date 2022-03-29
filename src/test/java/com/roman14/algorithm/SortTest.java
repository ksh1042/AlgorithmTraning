package com.roman14.algorithm;


import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
/**
 * <b>정렬 테스트 클래스</b>
 * <pre>
 *  ※ JUnit 4.11 부터 테스트케이스의 순서 정의 가능
 *  ※ TestNG, Spock 등 다른 테스트 라이브러리를 통해서 테스트 가능
 * </pre>
 * @See com.roman14.algorithm.Sort
 */
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class SortTest
{
  private static final int TEST_ARRAY_SIZE = 10000;
  private static final int SHUFFLE_TIMES   = TEST_ARRAY_SIZE * 10;
  private static final int [] TEST_CASE1_ANSWER = IntStream.rangeClosed(1, TEST_ARRAY_SIZE).toArray();    // 기본 테스트 케이스
  private static final int [] TEST_CASE2_ANSWER = IntStream.rangeClosed(1, TEST_ARRAY_SIZE-1).toArray();  // 홀수 혹은 짝수 갯수가 되는 반대되는 상황의 테스트 케이스

  @Test
  @Order(1)
  @DisplayName("선택 정렬")
  void selectionSort()
  {
    final int [] testCase1 = Algorithms.randomIntArray(TEST_ARRAY_SIZE, SHUFFLE_TIMES);
    final int [] testCase2 = Algorithms.randomIntArray(TEST_ARRAY_SIZE-1, SHUFFLE_TIMES);

    // 속도
    /*
    Assertions.assertAll(
      ()-> assertTimeout(Duration.ofMillis(50), ()-> Sort.selectionSort(testCase1)),
      ()-> assertTimeout(Duration.ofMillis(50), ()-> Sort.selectionSort(testCase2))
    );
    */
    Sort.selectionSort(testCase1);
    Sort.selectionSort(testCase2);
    // 결과
    Assertions.assertAll(
      ()-> assertArrayEquals(TEST_CASE1_ANSWER, testCase1),
      ()-> assertArrayEquals(TEST_CASE2_ANSWER, testCase2)
    );
  }

  @Test
  @Order(2)
  @DisplayName("버블 정렬")
  void bubbleSort()
  {
    final int [] testCase1 = Algorithms.randomIntArray(TEST_ARRAY_SIZE, SHUFFLE_TIMES);
    final int [] testCase2 = Algorithms.randomIntArray(TEST_ARRAY_SIZE-1, SHUFFLE_TIMES);

    Sort.bubbleSort(testCase1);
    Sort.bubbleSort(testCase2);

    // 결과
    Assertions.assertAll(
      ()-> assertArrayEquals(TEST_CASE1_ANSWER, testCase1),
      ()-> assertArrayEquals(TEST_CASE2_ANSWER, testCase2)
    );
  }

  @Test
  @Order(3)
  @DisplayName("삽입 정렬")
  void insertionSort()
  {
    final int [] testCase1 = Algorithms.randomIntArray(TEST_ARRAY_SIZE, SHUFFLE_TIMES);
    final int [] testCase2 = Algorithms.randomIntArray(TEST_ARRAY_SIZE-1, SHUFFLE_TIMES);

    Sort.insertionSort(testCase1);
    Sort.insertionSort(testCase2);

    // 결과
    Assertions.assertAll(
      ()-> assertArrayEquals(TEST_CASE1_ANSWER, testCase1),
      ()-> assertArrayEquals(TEST_CASE2_ANSWER, testCase2)
    );
  }

  @Test
  @Order(4)
  @DisplayName("퀵 정렬")
  void quickSort()
  {
    final int [] testCase1 = Algorithms.randomIntArray(TEST_ARRAY_SIZE, SHUFFLE_TIMES);
    final int [] testCase2 = Algorithms.randomIntArray(TEST_ARRAY_SIZE-1, SHUFFLE_TIMES);

    Sort.quickSort(testCase1);
    Sort.quickSort(testCase2);

    // 결과
    Assertions.assertAll(
      ()-> assertArrayEquals(TEST_CASE1_ANSWER, testCase1),
      ()-> assertArrayEquals(TEST_CASE2_ANSWER, testCase2)
    );
  }

  @Test
  @Order(5)
  @DisplayName("병합 정렬")
  void mergeSort()
  {
    final int [] testCase1 = Algorithms.randomIntArray(TEST_ARRAY_SIZE, SHUFFLE_TIMES);
    final int [] testCase2 = Algorithms.randomIntArray(TEST_ARRAY_SIZE-1, SHUFFLE_TIMES);

    Sort.mergeSort(testCase1);
    Sort.mergeSort(testCase2);

    // 결과
    Assertions.assertAll(
      ()-> assertArrayEquals(TEST_CASE1_ANSWER, testCase1),
      ()-> assertArrayEquals(TEST_CASE2_ANSWER, testCase2)
    );
  }

  @Test
  @Order(6)
  @DisplayName("힙 정렬")
  void heapSort()
  {
    final int [] testCase1 = Algorithms.randomIntArray(TEST_ARRAY_SIZE, SHUFFLE_TIMES);
    final int [] testCase2 = Algorithms.randomIntArray(TEST_ARRAY_SIZE-1, SHUFFLE_TIMES);

    Sort.heapSort(testCase1);
    Sort.heapSort(testCase2);

    // 결과
    Assertions.assertAll(
      ()-> assertArrayEquals(TEST_CASE1_ANSWER, testCase1),
      ()-> assertArrayEquals(TEST_CASE2_ANSWER, testCase2)
    );
  }
}