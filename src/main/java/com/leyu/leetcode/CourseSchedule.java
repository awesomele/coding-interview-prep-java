package com.leyu.leetcode;

import java.util.*;

// https://leetcode.com/problems/course-schedule/
public class CourseSchedule {
  private record Maps(
          Map<Integer, Set<Integer>> nextCourses,
          Map<Integer, Set<Integer>> depsMap) {}

  public boolean run(int numCourses, int[][] prerequisites) {
    if (prerequisites.length == 0) {
      return true;
    }

    Maps maps = getAdjancencyMatrix(numCourses, prerequisites);
    Map<Integer, Set<Integer>> nextCourses = maps.nextCourses;
    Map<Integer, Set<Integer>> depsMap = maps.depsMap;

    List<Integer> coursesDontNeedPrerequisites = getCoursesDontNeedPrerequisites(depsMap);
    if (coursesDontNeedPrerequisites.size() == 0) {
      return false;
    }

    if (coursesDontNeedPrerequisites.size() >= numCourses) {
      return true;
    }

    return bfs(coursesDontNeedPrerequisites, nextCourses, depsMap, numCourses);
  }

  private boolean bfs(
          List<Integer> coursesDontNeedPrerequisites,
          Map<Integer, Set<Integer>> nextCourses,
          Map<Integer, Set<Integer>> depsMap,
          int numCourses) {

    int numCourseLeft = numCourses;
    Queue<Integer> q = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    for (var course : coursesDontNeedPrerequisites) {
      q.add(course);
      visited.add(course);
      --numCourseLeft;
    }

    while (!q.isEmpty()) {
      int totalCntOfCoursesInCurrentLevel = q.size();
      for (int i =0; i < totalCntOfCoursesInCurrentLevel; ++i) {
        Integer course = q.poll();
        Set<Integer> nextLevelCourses = nextCourses.getOrDefault(course, Set.of());
        for (var c : nextLevelCourses) {
          if (visited.contains(c)) {
            continue;
          }

          var deps = depsMap.getOrDefault(c, Set.of());
          if (isAllDepsVisited(deps, visited)) {
            q.add(c);
            visited.add(c);
            --numCourseLeft;
          }
        }
      }
    }

    return numCourseLeft == 0;
  }

  private boolean isAllDepsVisited(Set<Integer> deps, Set<Integer> visited) {
    for (var dep : deps) {
      if (!visited.contains(dep)) {
        return false;
      }
    }
    return true;
  }

  private Maps getAdjancencyMatrix(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> nextCourses = new HashMap<>();
    Map<Integer, Set<Integer>> depsMap = new HashMap<>();
    for (int i = 0; i < numCourses; ++i) {
      nextCourses.put(i, new HashSet<>());
      depsMap.put(i, new HashSet<>());
    }
    for (int i = 0; i < prerequisites.length; ++i) {
      int from = prerequisites[i][1];
      int to = prerequisites[i][0];
      nextCourses.get(from).add(to);
      depsMap.get(to).add(from);
    }

    return new Maps(nextCourses, depsMap);
  }

  private List<Integer> getCoursesDontNeedPrerequisites(
          Map<Integer, Set<Integer>> depsMap) {
    List<Integer> coursesDontNeedPrerequisites = new ArrayList<>();
    for (var entry : depsMap.entrySet()) {
      if (entry.getValue().isEmpty()) {
        int courseId = entry.getKey();
        coursesDontNeedPrerequisites.add(courseId);
      }
    }
    return coursesDontNeedPrerequisites;
  }
}