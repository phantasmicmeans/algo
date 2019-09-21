package com.company;

public class Baek2839 {
    static StringBuffer sb = new StringBuffer();
    static int N;
    private static void salt() {
        int Min = Integer.MAX_VALUE;
        int a, b = 0;
        for (int i = 0; i <= N; i++) {
            a = i; // 3
            b = (N - a) % 5; // 0

            if (b == 0 ) {
                int newA = i / 3; // 1
                int newB = (N - a) / 5; // 3
                boolean isN = makeN(newA, newB);
                if (isN) {
                    int now = newA + newB;
                    Min = Math.min(Min, now);
                }
            }
        }

        if (Min == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(Min);
    }

    private static boolean makeN(int a, int b) {
        int result = (3 * a) + (5 * b);
        if (result == N) {
            return true;
        }
        return false;
    }
}
