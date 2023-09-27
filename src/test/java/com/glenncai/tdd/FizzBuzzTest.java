package com.glenncai.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * FizzBuzz Test
 *
 * @author Glenn Cai
 * @version 1.0 27/09/2023
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

  FizzBuzz fizzBuzz;

  @BeforeEach
  void setup() {
    fizzBuzz = new FizzBuzz();
  }

  @Test
  @Order(1)
  @DisplayName("Divisible by Three")
  void testForDivisibleByThree() {
    String expected = "Fizz";

    assertEquals(expected, fizzBuzz.compute(3), "Should return Fizz");
  }

  @Test
  @Order(2)
  @DisplayName("Divisible by Five")
  void testForDivisibleByFive() {
    String expected = "Buzz";

    assertEquals(expected, fizzBuzz.compute(5), "Should return Buzz");
  }

  @Test
  @Order(3)
  @DisplayName("Divisible by Three and Five")
  void testForDivisibleByThreeAndFive() {
    String expected = "FizzBuzz";

    assertEquals(expected, fizzBuzz.compute(15), "Should return FizzBuzz");
  }

  @Test
  @Order(4)
  @DisplayName("Not Divisible by Three or Five")
  void testForNotDivisibleByThreeOrFive() {
    String expected = "7";

    assertEquals(expected, fizzBuzz.compute(7), "Should return 7");
  }

  @ParameterizedTest(name = "value={0}, expected={1}")
  @CsvFileSource(resources = "/small-test-data.csv")
  @Order(5)
  @DisplayName("Testing With Small Data File")
  void testSmallDataFile(int value, String expected) {
    assertEquals(expected, fizzBuzz.compute(value), "Should return " + expected);
  }

  @ParameterizedTest(name = "value={0}, expected={1}")
  @CsvFileSource(resources = "/medium-test-data.csv")
  @Order(6)
  @DisplayName("Testing With Medium Data File")
  void testMediumDataFile(int value, String expected) {
    assertEquals(expected, fizzBuzz.compute(value), "Should return " + expected);
  }

  @ParameterizedTest(name = "value={0}, expected={1}")
  @CsvFileSource(resources = "/large-test-data.csv")
  @Order(7)
  @DisplayName("Testing With Large Data File")
  void testLargeDataFile(int value, String expected) {
    assertEquals(expected, fizzBuzz.compute(value), "Should return " + expected);
  }
}