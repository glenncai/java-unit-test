package com.glenncai.unitdemo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.Duration;
import java.util.List;

/**
 * DemoUtils Test
 *
 * @author Glenn Cai
 * @version 1.0 27/09/2023
 */
@TestMethodOrder(MethodOrderer.Random.class)
class DemoUtilsTest {
  DemoUtils demoUtils;

  @BeforeAll
  static void setupBeforeAll() {
    System.out.println("Running setupBeforeAll()");
    System.out.println();
  }

  @AfterAll
  static void tearDownAfterAll() {
    System.out.println("Running tearDownAfterAll()");
  }

  @BeforeEach
  void setupBeforeEach() {
    System.out.println("Running init()");
    demoUtils = new DemoUtils();
  }

  @AfterEach
  void tearDownAfterEach() {
    System.out.println("Running tearDown()");
    System.out.println();
  }

  @Test
  @DisplayName("Equals and Not Equals")
  void testEqualsAndNotEquals() {
    System.out.println("Running test: testEqualsAndNotEquals");

    assertEquals(6, demoUtils.add(2, 4), "2+4 should be 6");
    assertNotEquals(10, demoUtils.add(2, 4), "2+4 should not be 10");
  }

  @Test
  @DisplayName("Null and Not Null")
  void testNullAndNotNull() {
    System.out.println("Running test: testNullAndNotNull");

    String x = "Hello";
    assertNull(demoUtils.checkNull(null), "Should be null");
    assertNotNull(demoUtils.checkNull(x), "Should not be null");
  }

  @Test
  @DisplayName("Same and Not Same")
  void testSameAndNotSame() {
    System.out.println("Running test: testSameAndNotSame");

    String x = "Hello";
    assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Should be same");
    assertNotSame(demoUtils.getAcademy(), x, "Should not be same");
  }

  @Test
  @DisplayName("True and False")
  void testTrueAndFalse() {
    System.out.println("Running test: testTrueAndFalse");

    assertTrue(demoUtils.isGreater(10, 5), "10 is greater than 5");
    assertFalse(demoUtils.isGreater(5, 10), "5 is not greater than 10");
  }

  @Test
  @DisplayName("Array Equals")
  void testArrayEquals() {
    System.out.println("Running test: testArrayEquals");

    String[] expected = {"A", "B", "C"};
    assertArrayEquals(expected, demoUtils.getFirstThreeLettersOfAlphabet(),
                      "Arrays should be equal");
  }

  @Test
  @DisplayName("Iterable Equals")
  void testIterableEquals() {
    System.out.println("Running test: testIterableEquals");

    List<String> expected = List.of("glenn", "cai", "code");
    assertIterableEquals(expected, demoUtils.getAcademyInList(), "Lists should be equal");
  }

  @Test
  @DisplayName("Multiply")
  void testMultiply() {
    System.out.println("Running test: testMultiply");

    assertEquals(8, demoUtils.multiply(2, 4), "2*4 should be 8");
  }

  @Test
  @DisplayName("Lines Match")
  void testLinesMatch() {
    System.out.println("Running test: testLinesMatch");

    List<String> expected = List.of("glenn", "cai", "code");
    assertLinesMatch(expected, demoUtils.getAcademyInList(), "Lists should be equal");
  }

  @Test
  @DisplayName("Throws and Does Not Throw")
  void testThrowsAndDoesNotThrow() {
    System.out.println("Running test: testThrowsAndDoesNotThrow");

    assertThrows(Exception.class, () -> demoUtils.throwException(-1), "Should throw exception");
    assertDoesNotThrow(() -> demoUtils.throwException(1), "Should not throw exception");
  }

  @Test
  @DisplayName("Timeout")
  void testTimeout() {
    System.out.println("Running test: testTimeout");

    assertTimeoutPreemptively(Duration.ofSeconds(3), () -> demoUtils.checkTimeout(),
                              "Should not timeout");
  }
}