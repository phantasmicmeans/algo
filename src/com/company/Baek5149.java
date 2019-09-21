package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek5149 {
    static int ipt = 0;
    static int count = 0;
    static int sqrt = 0;

    public static void main() throws IOException {
        // write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            ipt = Integer.parseInt(reader.readLine().trim());
            if (ipt == 0)
                return;
            sqrt = (int) Math.sqrt(2 * ipt);
            check(ipt);
            count = 0;
        }
    }
    public static void check(int n) {
        int real = 2 * n;
        for (int i = n + 1; i <= real; i++) {
            boolean prime = isPrime(i);
            if (prime) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isPrime(int n) {
        if (n == 0 || n == 1)
            return false;
        for (int k = 2;  k <= sqrt; k++) {
            if (n % k == 0) {
                return false;
            }
        }
        return true;
    }
}
