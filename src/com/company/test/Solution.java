package com.company.test;

import java.util.*;

public class Solution {
    public int[] solution(int[][] v) {
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    xs.add(v[i][j]);
                } else {
                    ys.add(v[i][j]);
                }
            }
        }
        int k = 0;
        int [] answer = new int[2];

        Collections.sort(xs);
        answer[k++] = check(xs);
        Collections.sort(ys);
        answer[k++] = check(ys);

        return answer;
    }
    private int check(List<Integer> list) {
        int first = list.get(0);
        int second = list.get(1);
        int third = list.get(2);
        if (first == second) {
            return third;
        } else {
            return first;
        }
    }
}
