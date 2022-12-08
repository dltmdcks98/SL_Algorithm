package org.example.chap04;

import java.util.Arrays;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1253
public class 좋다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수의 개수
        int count = 0; // 좋은 수의 개수

        // 수를 담을 배열
//        long[] A = {-3, -5, 1, 15, 4, 0, 7, 9, -2, 3};
        long[] A = new long[N];

        // 배열 초기화
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }
        sc.close();

        // 배열 정렬
        Arrays.sort(A);

//        모든 수를 순회하여 좋은 수인지 판단
//        좋은 수 판단을 위한 숫자 타겟팅
        for (int i = 0; i < A.length; i++) {
            long target = A[i];//좋은 수 인지 판단하는 숫자
//            투 포인터 초기화
            int start = 0;
            int end = N-1;
//            투포인터 알고리즘
            while (start < end) {
                long M = A[start] + A[end];
                if(target==M){
//                    좋은 수
                    if(start==i){//좋은 수인데 타겟을 포함 했는지?
                        start++;
                    }else if(end == i){
                        end--;
                    }else {
                        count++;
                        break;
                    }
                } else if (M < target) {//두 수의 합이 타겟보다 작으면
                    start++;
                }else {
                    end--;
                }
            }
        }
    }
}
