package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Baek1065 {
    static int N;
    public void main() throws IOException {
        // write your code here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int count = 0;
        if (N < 100) {
            count += N;
        } else {
            count += 99;
            for (int i = 100; i <= N; i++) {
                String number = String.valueOf(i);
                int first = Integer.parseInt(number.substring(0, 1));
                int second = Integer.parseInt(number.substring(1, 2));
                int third = Integer.parseInt(number.substring(2, 3));
                if ((second - first) == (third - second)) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
