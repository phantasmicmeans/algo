package com.company;

import java.util.Scanner;

public class Baek2577 {
    static int[] visited = new int[10];

    private void check() {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int number = 1;
        for (int i = 0; i < 3; i++) {
            number *= Integer.parseInt(sc.nextLine().trim());
        }
        String num = String.valueOf(number);
        for (int i = 0; i < num.length(); i++) {
            String s = num.substring(i, i + 1);
            visited[Integer.parseInt(s)]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(visited[i]);
        }
    }
}
