package org.example.chap12;

import org.example.chap11.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//인접 리스트 방식
public class GraphList {
    // 정점들을 저장할 리스트
    private List<Vertex> vertices;

    // 그래프들의 연결관계를 저장할 인접 리스트
    private List<List<Vertex>> adjList;

    public GraphList() {
        vertices = new LinkedList<>(); // 정점들이 저장될 1차원리스트
        adjList = new LinkedList<>(); // 정점의 관계들이 저장될 2차원리스트

    }

    // 정점 추가 메서드
    public void addVertex(Vertex v) {

        v.setId(vertices.size()); // 정점에 id부여
        vertices.add(v); // 정점을 정점리스트에 추가
        adjList.add(new LinkedList<>()); // 인접리스트에 1차원리스트 추가
    }

    // 간선 연결하기 (무방향 그래프)
    public void addEdge(Vertex departure, Vertex destination) {

        adjList.get(departure.getId()).add(destination);
        adjList.get(destination.getId()).add(departure);
    }

    // 인접 리스트 그래프 출력
    public void showGraph() {

        for (int i = 0; i < adjList.size(); i++) {
            System.out.printf("%s | ", vertices.get(i).getData());
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.printf("%s ", adjList.get(i).get(j).getData());
            }
            System.out.println();
        }

    }

    //깊이 우선 탐색 - 스택 방식 구현
    public void DFS(Vertex start){
        //정점들을 저장할 스택
        Stack<Vertex> stack = new Stack<>();
        //탐색 시작 정점을 스택에 저장
        stack.push(start);

        //스택이 빌 때까지 DFS 반복 수행
        while(!stack.isEmpty()){

            //스택에서 정점을 꺼낸다.
            Vertex current = stack.pop();
            //해당 정점에 방문 표시
            current.setVisitFlag(true);
            //방문한 정점의 데이터 꺼내오기
            System.out.printf("%s",current.getData());

            //해당 정점에 연경되어 있는 다른 정점들을 찾아서 모두 스택에 저장
            List<Vertex> list = adjList.get(current.getId());
            for (Vertex v : list) {
                //방문한 적 없는 정점만 스택에 추가
                if(!v.isVisitFlag()){
                    stack.push(v);
                }
            }
        }
        System.out.println();
    }

    // 깊이 우선 탐색 구현 - 재귀
    public void DFS2(Vertex current) {

        // 재귀 탈출 조건 - 이미 방문했으면 나오기
        if (current.isVisitFlag()) {
            System.out.println();
            return;
        }

        // 현재 정점에 방문처리
        current.setVisitFlag(true);
        // 현재 정점을 출력
        System.out.printf("%s ", current.getData());

        // 현재 정점에 연결된 모든 정점을 가져오기
        List<Vertex> connectedVertices = adjList.get(current.getId());

        for (int i = connectedVertices.size() - 1; i >= 0; i--) {
            // 연결된 정점하나 가져오기
            Vertex v = connectedVertices.get(i);
            if (!v.isVisitFlag()) {
                DFS2(v); // 방문되지 않은 정점 재귀호출
            }
        }
    }
}
