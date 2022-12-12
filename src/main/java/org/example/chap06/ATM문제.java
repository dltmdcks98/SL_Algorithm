package org.example.chap06;

import java.util.Scanner;

//https://www.acmicpc.net/problem/11399
public class ATM문제{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N]; // 수를 저장할 배열
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 삽입 정렬 => 실제로 문제 풀때는 Array.sort로 풀이
        for (int i = 1; i < N; i++) {
            int temp = A[i];

            int j = i;
            while (j > 0 && A[j - 1] >= temp) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = temp;
        }

        // 구간 합배열 생성
        int[] S = new int[N + 1];

        for (int i = 1; i < S.length; i++) {
            S[i] = S[i - 1] + A[i - 1];
        }

        // 합배열 총합 구하기
        int total = 0;
        for (int i = 1; i < S.length; i++) {
            total += S[i];
        }
        System.out.println(total);
    }
}
