package com.glenncai.tdd;

/**
 * FizzBuzz
 *
 * @author Glenn Cai
 * @version 1.0 27/09/2023
 */
public class FizzBuzz {

  public String compute(int i) {
    StringBuilder result = new StringBuilder();

    if (i % 3 == 0) {
      result.append("Fizz");
    }

    if (i % 5 == 0) {
      result.append("Buzz");
    }

    return result.isEmpty() ? String.valueOf(i) : result.toString();
  }
}
