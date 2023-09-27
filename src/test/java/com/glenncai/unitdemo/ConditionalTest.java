package com.glenncai.unitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

/**
 * Conditional Test
 *
 * @author Glenn Cai
 * @version 1.0 27/09/2023
 */
class ConditionalTest {

  @Test
  @Disabled("Don't run until bug #42 has been fixed")
  void basicTest() {
    // Execute method and perform assertions
  }

  @Test
  @EnabledOnOs(OS.LINUX)
  void testForLinuxOnly() {
    // Execute method and perform assertions
  }

  @Test
  @EnabledOnOs(OS.WINDOWS)
  void testForWindowsOnly() {
    // Execute method and perform assertions
  }

  @Test
  @EnabledOnOs({OS.LINUX, OS.MAC})
  void testForLinuxOrMacOnly() {
    // Execute method and perform assertions
  }

  @Test
  @EnabledOnJre(JRE.JAVA_17)
  void testForOnlyJava17() {
    // Execute method and perform assertions
  }

  @Test
  @EnabledOnJre(JRE.JAVA_11)
  void testForOnlyJava11() {
    // Execute method and perform assertions
  }

  @Test
  @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
  void testForJava11To17() {
    // Execute method and perform assertions
  }

  @Test
  @EnabledForJreRange(min = JRE.JAVA_11)
  void testForJava11AndAbove() {
    // Execute method and perform assertions
  }

  @Test
  @EnabledIfEnvironmentVariable(named = "UNIT_TEST_ENV", matches = "DEV")
  void testIfEnvironmentVariableIsSet() {
    // Execute method and perform assertions
  }

  @Test
  @EnabledIfSystemProperty(named = "UNIT_TEST_SYS_PROP", matches = "CI_CD_DEPLOY")
  void testIfSystemPropertyIsSet() {
    // Execute method and perform assertions
  }
}
