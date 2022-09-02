package com.leyu.playground;

import org.junit.jupiter.api.Test;

public class EnumDemoTest {
  @Test
  public void testEnumSet() {
    EnumDemo.enumSet();
  }

  @Test
  public void testCastEnumToInt() {
    EnumDemo.castEnumToInt();
  }

  @Test
  public void testOverrideEnumEqual() {
    EnumDemo.playWithEquals();
  }
}