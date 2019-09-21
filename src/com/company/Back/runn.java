package com.company.Back;

import java.util.*;

public class runn {
    static int N;
    static int graph[][];
    static int count = 0;
    static int cGraph[][];
    static int lastG[][];
    static int dx[] = {1, 0};
    static int dy[] = {0, 1};
    /*
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine().trim());
        graph = new int[N+1][N+1];
        cGraph = new int[N+1][N+1];
        lastG = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N ; j++) {
                int g = sc.nextInt();
                graph[i][j] = g;
                if (g == 1) {
                    cGraph[i][j] = -1;
                }
                else
                    cGraph[i][j] = Integer.MAX_VALUE;
            }
            sc.nextLine();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int k = graph[i][j];
                // 주변에 0이 있으면 들어가

                for (int a = 0; a < 2; a++) {
                    int x = i + dx[a];
                    int y = j + dy[a];
                    if (x <= N && y <= N && x > 0 && y > 0 &&
                            k == 1 && graph[x][y] == 0) {
                        search(x, y);
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(lastG[i][j] +" ");
            }
            System.out.println();
        }
    }*/
    public static void search(int i, int j) {
        Queue<Nodes> queue = new LinkedList<>();
        queue.add(new Nodes(i, j));
        cGraph[i][j] = 1;
        while (!queue.isEmpty()) {
            Nodes node = queue.poll();
            for (int k = 0; k < 2; k++) {
                int x = node.i + dx[k];
                int y = node.j + dy[k];

                if (x <= N && y <= N && x >= 1 && y >= 1) {
                    if (graph[x][y] == 1) {
                        lastG[node.i][node.j] = cGraph[node.i][node.j];
                        break;
                    }

                    if (graph[x][y] == 0 && cGraph[x][y] != -1){
                        int sum = cGraph[node.i][node.j] + 1;
                        if (sum < cGraph[x][y]) {
                            cGraph[x][y] = sum;
                            queue.add(new Nodes(x, y));
                        }
                    }
                }
            }
        }
    }
}

class Nodes {
    int i, j;
    public Nodes(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

