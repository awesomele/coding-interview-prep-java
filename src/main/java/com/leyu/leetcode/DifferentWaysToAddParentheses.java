package com.leyu.leetcode;

import java.util.*;

// https://leetcode.com/problems/different-ways-to-add-parentheses/
// https://leetcode.com/problems/different-ways-to-add-parentheses/discuss/2406044/JAVA-Solution-As-Clean-As-Mineral-Water
public class DifferentWaysToAddParentheses {

  private class TreeNode {
    char operator;
    TreeNode left;
    TreeNode right;
  }

  private record SubExpression(int start, int end) {}

  private record Data(int left, int right, char operator, SubExpression subExpression) {

  }

  private static Set<Character> OPERATORS = Set.of('+','-','*');

  public List<Integer> diffWaysToCompute(String expression) {
    Map<Integer /*index to operation*/, Data> mem = new HashMap<>();
    buildMap(expression, mem);

    List<Integer> indexsOfOperater = new ArrayList<>();
    for (var entry : mem.entrySet()) {
      int idx = entry.getKey();
      indexsOfOperater.add(idx);
    }
    Collections.sort(indexsOfOperater);

    List<List<Integer>> operatorPermutations = getPermutation(indexsOfOperater);

    // operatorPermutations = dedupe(operatorPermutations, mem, expression);

    List<Integer> results = new ArrayList<>();
    for (var operatorSequence : operatorPermutations) {
      Map<Integer, Data> memCopy = new HashMap<>(mem);
      int result = evaluate(operatorSequence, memCopy, indexsOfOperater);
      results.add(result);
    }

    Collections.sort(results);
    return results;
  }

  private List<List<Integer>> dedupe(
          List<List<Integer>> operatorPermutations,
          Map<Integer, Data> mem,
          String originalExpression) {

    Set<String> experessions = new HashSet<>();
    List<List<Integer>> dedupedList = new ArrayList<>();
    for (var operatorSequence : operatorPermutations) {
      String expression = buildExpressionFromOperatorSequence(operatorSequence, mem, originalExpression);
      if (!experessions.contains(expression)) {
        dedupedList.add(operatorSequence);
      }
    }
    return dedupedList;
  }

  private String buildExpressionFromOperatorSequence(
          List<Integer> operatorSequence,
          Map<Integer, Data> mem,
          String originalExpression) {

//    List<Character> chars = new ArrayList<>(Arrays.asList(originalExpression.toCharArray()));
//    for (int i = 0; i < operatorSequence.size(); ++i) {
//      int idx = operatorSequence.get(i);
//      var data = mem.get(i);
//
//    }
    return "";
  }

  private int evaluate(
          List<Integer> operatorSequence,
          Map<Integer, Data> mem,
          List<Integer> indexsOfOperater) {

    int result = 0;
    Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < operatorSequence.size(); ++i) {
      int currentOperatoridx = operatorSequence.get(i);
      result = evaluateCore(mem.get(currentOperatoridx).operator,
              mem.get(currentOperatoridx).left,
              mem.get(currentOperatoridx).right);
      visited.add(currentOperatoridx);

      if (i != operatorSequence.size() -1) {
        int nextOperatoridx = operatorSequence.get(i+1);
        updateOperands(currentOperatoridx, nextOperatoridx, mem, indexsOfOperater, result, visited);
      }
    }
    return result;
  }

  private void updateOperands(
          int currentOperatoridx,
          int nextOperatoridx,
          Map<Integer, Data> mem,
          List<Integer> indexsOfOperater,
          int newOperand,
          Set<Integer> visited) {

    if (isNextToEachOther(currentOperatoridx, nextOperatoridx, indexsOfOperater)) {
      Data oldData = mem.get(nextOperatoridx);
      Data newData;
      if (indexsOfOperater.indexOf(nextOperatoridx) > indexsOfOperater.indexOf(currentOperatoridx)) {
        newData = new Data(newOperand, oldData.right, oldData.operator, oldData.subExpression);
      } else {
        newData = new Data(oldData.left, newOperand, oldData.operator, oldData.subExpression);
      }
      mem.put(nextOperatoridx, newData);

    } else {
      // find the  operator that would consume the result
      int operator1 = indexsOfOperater.indexOf(currentOperatoridx) - 1;
      while (operator1 >= 0) {
        int idx = indexsOfOperater.get(operator1);
        if (visited.contains(idx)) {
          operator1 -= 1;
          continue;
        }
        Data oldData = mem.get(idx);
        Data newData = new Data(oldData.left, newOperand, oldData.operator, oldData.subExpression);
        mem.put(idx, newData);
        break;
      }
      int operator2 = indexsOfOperater.indexOf(currentOperatoridx) + 1;
      while (operator2 <= indexsOfOperater.size() - 1) {
        int idx = indexsOfOperater.get(operator2);
        if (visited.contains(idx)) {
          operator2 += 1;
          continue;
        }
        Data oldData = mem.get(idx);
        Data newData = new Data(newOperand, oldData.right, oldData.operator, oldData.subExpression);
        mem.put(idx, newData);
        break;
      }
    }
  }

  private boolean isNextToEachOther(int idx1, int idx2, List<Integer> indexsOfOperater) {
    int tmp = indexsOfOperater.indexOf(idx1) - indexsOfOperater.indexOf(idx2);
    return tmp == 1 || tmp == -1;
  }

  private int evaluateCore(char operator, int left, int right) {
    if (operator == '-') {
      return left-right;
    } else if (operator == '+') {
      return left + right;
    } else if (operator == '*') {
      return left*right;
    } else {
      return 0;
    }
  }

  private List<List<Integer>> getPermutation(List<Integer> indexsOfOperater) {
    List<List<Integer>> permutations = new ArrayList<>();
    for (int i = 0; i < indexsOfOperater.size(); ++i) {
      Set<Integer> visisted = new HashSet<>();
      List<Integer> permutation = new ArrayList<>();
      permutation.add(indexsOfOperater.get(i));
      visisted.add(indexsOfOperater.get(i));
      getPermutationCore(indexsOfOperater, permutation, visisted, permutations);
    }
    return permutations;
  }

  private void getPermutationCore(
          List<Integer> indexsOfOperater,
          List<Integer> permutation,
          Set<Integer> visisted,
          List<List<Integer>> permutations) {

    if (permutation.size() == indexsOfOperater.size()) {
      permutations.add(new ArrayList<>(permutation));
      return;
    }

    for (int i = 0; i < indexsOfOperater.size(); ++i) {
      if (visisted.contains(indexsOfOperater.get(i))) {
        continue;
      }

      permutation.add(indexsOfOperater.get(i));
      visisted.add(indexsOfOperater.get(i));
      getPermutationCore(indexsOfOperater, permutation, visisted, permutations);
      permutation.remove(permutation.size()-1);
      visisted.remove(indexsOfOperater.get(i));
    }

  }

  private void buildMap(
          String expression,
          Map<Integer, Data> mem) {

    int len = expression.length();
    int idx = 0;
    while(idx < len) {
      var curChar = expression.charAt(idx);
      boolean isOperator = OPERATORS.contains(curChar);
      if (!isOperator) {
        ++idx;
      } else {
        // parse the operand
        int startIdxOfLeftOperand = getStartIdxOfLeftOperand(idx, expression);
        int left = Integer.valueOf(expression.substring(startIdxOfLeftOperand, idx));
        int endIdxOfRightOperand = getEndIdxOfLeftOperand(idx, expression);
        int right = Integer.valueOf(expression.substring(idx+1, endIdxOfRightOperand+1));
        char operator = expression.charAt(idx);
        SubExpression subExpression = new SubExpression(startIdxOfLeftOperand, endIdxOfRightOperand);
        mem.put(idx, new Data(left, right, operator, subExpression));
        idx = endIdxOfRightOperand + 1;
      }
    }
  }

  private int getStartIdxOfLeftOperand(int idxOfOperator, String expression) {
    int anchorIdx = idxOfOperator-1;
    while ( anchorIdx -1 >= 0 && !isCharOperator(expression.charAt(anchorIdx -1)) ) {
      --anchorIdx;
    }
    return anchorIdx;
  }

  private int getEndIdxOfLeftOperand(int idxOfOperator, String expression) {
    int anchorIdx = idxOfOperator+1;
    while (anchorIdx+1 < expression.length() && !isCharOperator(expression.charAt(anchorIdx+1))) {
      ++anchorIdx;
    }
    return anchorIdx;
  }


  private boolean isCharOperator(char c) {
    return OPERATORS.contains(c);
  }
}