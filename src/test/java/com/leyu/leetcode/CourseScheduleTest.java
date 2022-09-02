package com.leyu.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CourseScheduleTest {

  private record TestInput(int numCourses, int[][] prerequisites){

  }
  private record TestCase(TestInput testInput, boolean expected) {

  }

  private List<TestCase> setupTestCases() {
    return List.of(
            new TestCase(new TestInput(1, new int[][]{}),true),
            new TestCase(new TestInput(2, new int[][]{{1,0}}),true),
            new TestCase(new TestInput(2, new int[][]{{1,0}, {0, 1}}),false),
            new TestCase(new TestInput(5, new int[][]{{1, 4}, {2, 4}, {3,1}, {3,2}}),true),
            new TestCase(new TestInput(20, new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}),false),
            new TestCase(new TestInput(3, new int[][]{{1,0},{1,2},{0,1}}),false)
    );
  }

  @Test
  public void test() {
    var testCases = setupTestCases();
    var courseSchedule = new CourseSchedule();
    for (var testCase : testCases) {
      var testInput = testCase.testInput;
      var actual = courseSchedule.run(testInput.numCourses, testInput.prerequisites);
      assertThat(actual).isEqualTo(testCase.expected);
    }
  }
}