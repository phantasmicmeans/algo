package com.company.Back;


import java.util.*;

public class Line {
    static int N, M;
    static LinkedList<Integer> linkedList;
    static List<node> list;
    static boolean visited[];
    /*
    public static void main(String[] args) {

        int i[][] = {
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        int j[][] = {
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 0, 1, 1},
                {1, 1, 1, 0}
        };
        Second s = new Second();
       System.out.println( s.solution(i, j));
        //first f = new first();
        //System.out.println(f.solution("aabbaccc"));

//        Scanner sc = new Scanner(System.in);
//        linkedList = new LinkedList<>();
//        list = new ArrayList<>();
//        StringTokenizer st = new StringTokenizer(sc.nextLine().trim(), " ");
//        while(st.hasMoreTokens()) {
//            N = Integer.parseInt(st.nextToken());
//            M = Integer.parseInt(st.nextToken());
//        }
//        visited = new boolean[N+1];
//        for (int a = 0; a < M; a++ ) {
//            StringTokenizer stk = new StringTokenizer(sc.nextLine().trim(), " ");
//            int i = Integer.parseInt(stk.nextToken());
//            int j = Integer.parseInt(stk.nextToken());
//            list.add(new node(i, j));
//        }
//
//        //Collections.sort(list);
//        //list.forEach(ele -> System.out.println(ele.i + ", " + ele.j));
//
//
//        bruteForce();
//        linkedList.forEach(ele -> System.out.println(ele));

    } */
    public static void bruteForce() {
        node first = list.get(0);
        linkedList.add(first.i);
        linkedList.add(first.j);

        visited[first.i] = true;
        visited[first.j] = true;
        first.visited = true;

        for (int k = 0; k < M; k++) {
            node nd = list.get(k);
            int i = nd.i;
            int j = nd.j;
            if (!nd.visited) {
                if (!isVisited(i)) {
                    linkedList.add(i);
                    visited[i] = true;
                }
                if (!isVisited(j)) {
                    linkedList.add(j);
                    visited[j] = true;
                }
            }

            for (int v = k + 1; v < M; v++) {
                node nd2 = list.get(v);
                int i2 = nd2.i;
                int j2 = nd2.j;

                if (j == j2) {
                    if (!isVisited(i2)) {
                        linkedList.add(v-1, i2);
                        visited[i2] = true;
                    }
                    if (isVisited(i2)) {

                    }
                }
            }
        }
    }
    public static boolean isVisited(int i) {
        return visited[i];
    }
}
class node implements Comparable<node> {
    int i, j;
    boolean visited;
    public node (int i, int j) {
        this.i = i;
        this.j = j;
        visited = false;
    }

    @Override
    public int compareTo(node o) {
        if (this.j >= o.j) {
            return 1;
        }
        return -1;
    }
}

/*
       /*
        1, 10    2, 1  [ 2, 1]
        4, 2     4, 2  [ 4, 2, 1], [5,4,2,1], [5,6,4,2,1]
        5, 3     5, 3   [6, 4, 2, 1, 5, 3]
                 5, 4   [6, 4, 2, 1, 5, 8]
        6, 4     6, 4  x
        2, 1     8, 5  [6, 4, 2, 1, 5, 3, 7, 9]
        7, 9     9, 4   [6, 4, 2, 1, 5, 3, 7, 9, 10]
        7, 5

6 5
1 2
2 5
3 5
4 5
5 6

6 6
1 4
2 3
3 4
4 6
5 6
1 6
 */
