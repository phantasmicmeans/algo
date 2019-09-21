package com.company.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS2252 {
    static ArrayList<Integer>[] student = new ArrayList[32001];
    static int indegree[] = new int[32001];
    static int N,M ;
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringTokenizer s;
        for (int i = 0; i < N; i++) {
            student[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            s = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(s.nextToken()) - 1;
            int b = Integer.parseInt(s.nextToken()) - 1;
            student[a].add(b); // from a to b
            indegree[b]++;
            s = null;
        }
        sort();
    }

    static void sort() {
        Queue<Integer> searchQ = new LinkedList<>(); // 탐색 큐
        /* 초기 진입 차수가 0인 노드 탐색 큐에 삽임 */
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) searchQ.offer(i);
        }

        while (!searchQ.isEmpty()) {
            int zeroIndegreeNode = searchQ.poll(); // 진입 차수가 0인 노드
            System.out.print(zeroIndegreeNode + 1 + " ");
            //resultQ.offer(zeroIndegreeNode); // 결과 큐에 저장, 차수가 0이면 정렬완료임.

            // 0인 노드와 인접한 노드들 중
            for (int link : student[zeroIndegreeNode]) {
                indegree[link]--; // 차수를 1 빼준다.
                if (indegree[link] == 0) { // 진입차수가 0일때, 즉 정렬 완료일때
                    searchQ.offer(link); // 탐색 큐에 삽입.
                }
            }
        }
    }
}