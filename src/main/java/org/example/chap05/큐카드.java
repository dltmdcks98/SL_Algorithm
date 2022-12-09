package org.example.chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//백준2164
public class 큐카드 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        카드의 수
        int N = Integer.parseInt(br.readLine());;

//        큐 생성
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);//큐 이므로 자동으로 뒤에서 삽입
        }

//        카드 조작(맨 위 한장 버리고, 그 다음장 버리고 맨 아래에 추가 반복
        while(queue.size()>1){
            queue.poll();//맨 위 한장 버림
            queue.add(queue.poll());//한장 더 버리고 맨 뒤에 추가
        }
        System.out.println(queue.peek());//마지막 한장 출력
    }
}
