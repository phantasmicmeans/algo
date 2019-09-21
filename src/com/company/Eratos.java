package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Eratos {
    static int N;
    static StringBuffer sb = new StringBuffer();

    private void main() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs("");
        System.out.println(sb.toString());
    }
    private static void dfs(String number) {
        if (N == number.length()) {
            sb.append(number + "\n");
        } else {
            for (int i = 1; i <= 9; i++) {
                String now = number + i;
                boolean prime = checkPrime(Integer.valueOf(now));
                if (prime) { // if Prime
                    dfs(now);
                }
            }
        }
    }

    private static boolean checkPrime(int number) {
        boolean prime = false;
        if (number <= 1) return false;

        int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 에라토스테네스의 접근
     * 주어진 자연수 N이 소수이기 위한 필요충분 조건은 N이 N의 제곱근보다 크지 않은 어떤 소수로도 나눠지지 않는다.
     * 수가 수를 나누면 몫이 발생하게 되는데 몫과 나누는 수,
     * 둘 중 하나는 반드시 N의 제곱근 이하이기 때문이다.
     *
     */
    public void Eratos(int n) {
        if (n <= 1 ) return;
        /*	2부터 n까지 n-1개를 저장할 수 있는 배열 할당
		배열 참조 번호와 소수와 일치하도록 배열의 크기는
		n+1 길이만큼 할당(인덱스 번호 0과 1은 사용하지 않음)	*/
        boolean []primeArray = new boolean[n + 1];

        /*  배열초기화: 처음엔 모두 소수로 보고 true값을 줌	*/
        for (int i = 2; i <= n; i++) {
            primeArray[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (primeArray[i]) { // not prime
                for (int j = i * i; j <= n; j += i) {
                    primeArray[i] = false;
                }
            }
        }
    }

    public void EratosJava (int n) {
        ArrayList<Boolean> primeList;
        if (n <= 1) return;

        primeList = new ArrayList<>(n + 1);
        // 0번째와 1번째를 소수 아님으로 처리
        primeList.add(false);
        primeList.add(false);
        // 2~ n 까지 소수로 설정
        for (int i = 2; i <= n; i++) {
            primeList.add(true);
        }

        for (int i = 2; (i*i) <= n; i++) {
            if (primeList.get(i)) { // if isPrime
                // 각각의 배수들을 지워간다.
                for (int j = i * i; j <= n; j += i) {
                    primeList.set(j, false);
                    //i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
                }
            }
        }
    }

    private void isPrime(int number) {
        boolean prime = false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }
    }
}
