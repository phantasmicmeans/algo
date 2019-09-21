package com.company;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class BaekHansu {
    static int sum = 0;
    static LinkedList<Integer> people = new LinkedList<>();
    public static void main() throws IOException {
        // write your code here
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            int height = sc.nextInt();
            people.add(height);
            sum += height;
        }
        Collections.sort(people);
        int a = 0;
        int b = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                int subSum = people.get(i) + people.get(j);
                if (sum - subSum == 100) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i != a && i != b) {
                System.out.println(people.get(i));
            }
        }
    }
}
