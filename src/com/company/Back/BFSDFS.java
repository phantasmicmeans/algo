package com.company.Back;

import java.util.*;

public class BFSDFS {

        static int N;
        static int d[][];
        static int dx[] = {0, 1, 0, -1};
        static int dy[] = {-1, 0, 1, 0};
        static int Graph[][];
        static int count = 0;
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine().trim());
        Graph = new int[N+1][N+1];
        d = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            char[] list = sc.nextLine().toCharArray();
            for (int j = 0; j < list.length; j++) {
                Graph[i][j+1] = list[j] - '0';
            }
        }
        search();

    }*/

        public static void search() {
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (Graph[i][j] == 1 && d[i][j] == 0) {
                        count = 0;
                        BFS(i, j);
                        if (count != 0)
                            result.add(count);
                    }
                }
            }
            Collections.sort(result);
            System.out.println(result.size());
            result.forEach(System.out::println);
        }

        public static int BFS(int i, int j) {
            d[i][j]= 1;
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(i, j));
            count++;

            while(!queue.isEmpty()) {
                Node polls = queue.poll();
                for(int a = 0; a < 4; a++) {
                    int x = polls.i + dx[a];
                    int y = polls.j + dy[a];
                    if (x <= N && y <= N && x >= 1 && y >= 1 && d[x][y] == 0 && Graph[x][y] == 1) { //방문 한적 없고 1이면
                        queue.add(new Node(x, y));
                        d[x][y] = 1;
                        count ++;
                    }
                }
            }
            return count;
        }

        public static void DFS(int i, int j) {
            d[i][j] = 1;
            count++;

            for (int a = 0; a < 4; a++) {
                int x = i + dx[a];
                int y = j + dy[a];
                if (x <= N && y <= N && x >= 1 && y >= 1 && d[x][y] == 0 && Graph[x][y] == 1) { //방문 한적 없고 1이면
                    d[x][y] = 1;
                    DFS(x, y);
                }
            }

        }
    }
    class Node {
        int i;
        int j;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

