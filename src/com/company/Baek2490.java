package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2490 {
    static int[] yut = new int[2];
    private void main() throws IOException {
        // write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0 ; i < 3; i++) {
            yut[0] = 0;
            yut[1] = 0;
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            for (int k = 0; k < 4; k++) {
                int number = Integer.parseInt(st.nextToken());
                yut[number]++;
            }
            check();
        }
    }
    private static void check() {
        switch (yut[0]) {
            case 0:
                System.out.println("E");
                break;
            case 1:
                System.out.println("A");
                break;
            case 2:
                System.out.println("B");
                break;
            case 3:
                System.out.println("C");
                break;
            case 4:
                System.out.println("D");
                break;
        }
    }
}
