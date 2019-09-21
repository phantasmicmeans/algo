package com.company;


import com.company.test.Solution;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        // write your code here
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        int [][] m = new int[][]{
                {1, 1},
                {2, 2},
                {1, 2}
        };
        s.solution(m);
    }
}