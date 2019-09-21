package com.company.Back;


import java.util.ArrayList;
import java.util.Arrays;

public class Second {
    ArrayList<Node> keys = new ArrayList<>();
    ArrayList<Node> locks = new ArrayList<>();
    static int visited[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int keyMax, lockMax;

    public boolean solution(int[][] key, int[][] lock) {
        visited = new int[lock.length][lock.length];
        keyMax = key.length;
        lockMax = lock.length;
        addQueue(key, lock);
        int mustSize = locks.size();
        System.out.println("mustSize :" + mustSize);

        int visitCount = 0;

        for (int i = 0; i < 4; i++) { //90도 회전
            ArrayList<Node> lotated = lotate();
            System.out.println("\n\n[[[lotate]]]\n\n");
                for (int b = 0; b < 4; b++) {
                    int matchCount = 0;
                    System.out.println("[[[start]]]");

                    for (int a = 0; a < lotated.size(); a++) {
                        Node node = lotated.get(a);
                        int nextX = dx[b] + node.i;
                        int nextY = dy[b] + node.j;
                        if (visited[node.i][node.j] == 0) {
                            boolean matche = isMatch(node.i, node.j);
                            if (matche) matchCount++;
                            visited[node.i][node.j] = 1;
                        }

                        if (nextX >= 0 && nextY >= 0 && nextX < lock.length && nextY < lock.length && visited[nextX][nextY] == 0) {
                            if (visited[nextX][nextX] == 0) {
                                boolean matche = isMatch(nextX, nextX);
                                if (matche) matchCount++;
                                visited[nextX][nextX] = 1;
                            }
                            lotated.add(new Node(nextX, nextY));
                        }
                    }
                    if (matchCount == mustSize) return true;
                    matchCount = 0;
                    for (int a = 0; a < locks.size(); a++) {
                        Arrays.fill(visited[a], 0);
                    }
            }

        }
        return false;
    }

    public boolean isMatch(int x, int y) {
        System.out.println("x, y:" + x + ", " + y);

        int i = 0;
        while(i < locks.size()) {
            Node node = locks.get(i++);
            System.out.println("node X, Y :" + node.i + ", " + node.j);
            if (node.i == x && node.j == y) {
                System.out.println("MATCH~~");
                return true;
            }
        }
        return false;
    }
    public ArrayList<Node> lotate() {
        ArrayList<Node> lotated = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            Node node = keys.get(i);
            int x = node.i;
            int y = node.j;
            if (x == keyMax -1 && y == keyMax - 1) { // 끝지점이면
                node.j = 0;
            } else if (x == keyMax - 1 && y == 0) {
                node.i = 0;
            } else if (x == 0 && y == 0) {
                node.j = keyMax - 1;
            } else if (x == 0 && y == keyMax - 1) {
                node.i = keyMax - 1;
            } else {
                node.i = y;
                node.j = x;
            }
            lotated.add(node);
        }
        return lotated;
    }
    public void addQueue(int [][]key, int [][]lock) {
        int keyLength = key.length;
        int lockLength = lock.length;

        for (int i = 0; i < lockLength; i++) {
            for (int j = 0; j < lockLength; j++) {
                if (i < keyLength && j < keyLength && key[i][j] == 1) {
                    keys.add(new Node(i, j));
                }
                if (lock[i][j] == 0)
                    locks.add(new Node(i, j));
            }
        }
    }
}

/*

key를 시계방향으로 90도 회전하고, 오른쪽 으로 한칸, 아래로 한칸 이동시 lock의 홈부분 채울 수 있음.

상, 하, 좌, 우 / 회전 가능
회전 => 각 x, y가 끝인경우는 last index -> first index로 바꾸고,

해결 : 저 index 쌍만 가지고 하면 될듯.
아닌경우는 (x, y) -> (y, x)로
{1, 0, -1, 0 }
{0, 1, 0, -1}

자물쇠의 홈과 열쇠의 돌기가 정확히 맞아야함.
자물쇠의 돌기와 열쇠의 돌기가 만나면 안됨.
모든 자물쇠의 홈을 채워야 자물쇠를 열 수 있음.

0은 홈, 1은 돌기
  [key]        [lock]
[0, 0, 0]    [(1,1), (1,2), (1,3)]    [1, 1, 1]
[1, 0, 0]    [(2,1), (2,2), (2,3)]    [1, 1, 0]
[0, 1, 1]    [(3,1), (3,2), (3,3)]    [1, 0, 1]

[0, 1, 0]    [1, 1, 1]
[1, 0, 0]    [1, 1, 0]
[1, 0, 0]    [1, 0, 1]

 */