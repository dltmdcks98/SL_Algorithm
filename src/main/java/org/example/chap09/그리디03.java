package org.example.chap09;

import java.util.PriorityQueue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1715
public class 그리디03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 카드 묶음 수
        
        //우선 눙위 큐는 큐의 정렬을 지정한 우선순위에 따라 자동 정렬하는 자료구조
        PriorityQueue<Integer> cardList = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            cardList.add(sc.nextInt());
        }

        int total = 0;
        while (cardList.size() != 1) {
            int data1 = cardList.poll();
            int data2 = cardList.poll();
            total += data1 + data2;
            cardList.offer(data1 + data2);
        }
        System.out.println(total);

    }
}
