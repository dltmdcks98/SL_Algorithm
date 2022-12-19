package org.example.chap12;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//https://www.acmicpc.net/problem/13023
public class ABCDE {
    static List<List<Integer>> adjList = new LinkedList<>(); // 그래프 인접 리스트
    static boolean[] visited;  // 방문 배열

    static boolean arrive; // 재귀 5레벨 이상 도착했는지 여부

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //  정점 수
        int M = sc.nextInt(); //  간선 수

        // 정점 수만큼 인접 리스트 초기화
        for (int i = 0; i < N; i++) {
            adjList.add(new LinkedList<>());
        }
        // 정점 수만큼 방문 배열 초기화
        visited = new boolean[N];

        // 간선 수만큼 인접 리스트에 연결정보 추가
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt(); // 시작점
            int e = sc.nextInt(); // 끝점
            // 단, 무방향 그래프이므로 양쪽 다 추가한다.
            adjList.get(s).add(e);
            adjList.get(e).add(s);
        }

        // 모든 정점 노드를 돌면서 DFS 수행
        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if (arrive) break; // 5벨에 도달하면 DFS 종료
        }

        if (arrive) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    static void DFS(int num, int level) {
        // 재귀가 5레벨에 도달하면 재귀 종료
        if (level == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[num] = true; // 방문처리

        List<Integer> connectedList = adjList.get(num);
        for (Integer n : connectedList) {
            if (!visited[n]) {
                DFS(n, level + 1); // 재귀 레벨을 늘려가며 DFS 수행
            }
        }
        visited[num] = false; // 재귀 전 단계로 복귀시에 방문기록을 리셋
    }
}
