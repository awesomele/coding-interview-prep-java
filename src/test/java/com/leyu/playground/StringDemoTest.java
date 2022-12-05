package com.leyu.playground;

import org.junit.jupiter.api.Test;

public class StringDemoTest {

  @Test
  public void testValueOf() {
    StringDemo.valueOf();
  }

  @Test
  public void testStringComparison() {
    StringDemo.stringComparison();
  }

  @Test
  public void testSplit() {
    StringDemo.split();
  }

  @Test
  public void testStringAt() {
    StringDemo.stringAt();
  }

  @Test
  public void testConvertCharacterListToStringUseStream() {
    StringDemo.convertCharacterListToStringUseStream();
  }

  @Test
  public void testConvertCharacterListToStringUseStringBuilder() {
    StringDemo.convertCharacterListToStringUseStringBuilder();
  }

  @Test
  public void testConvertCharArrayToString() {
    StringDemo.convertCharArrayToString();
  }

  @Test
  public void testPlayWithSubString() {
    StringDemo.playWithSubString();
  }

  @Test
  public void playWithCharacterList() {
    StringDemo.playWithCharacterList();
  }

  @Test
  public void testPlayWithStringBuilder() {
    StringDemo.stringBuilder();
  }

  @Test
  public void testPlayIntToString() {
    StringDemo.playIntToString();
  }

  @Test
  public void testPlayStringValueOfOnOptional() {
    StringDemo.playStringValueOfOnOptional();
  }
}