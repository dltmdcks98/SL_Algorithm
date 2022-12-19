package org.example.chap12;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2023
public class 신기한소수 {
    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

    }

    /**
     * DFS 메서드
     *
     * @param number - 소수 판별할 숫자
     * @param level  - 재귀 깊이 레벨
     */
    static void DFS(int number, int level) {

        if (level == N) {
            if (isPrime(number)) {
                System.out.println(number);
            }
            return;
        }

        // 자리수가 올라갈수록 홀수들만 뒤에 이어붙여서 DFS 반복 수행
        for (int i = 1; i < 10; i += 2) {
            int newNumber = number * 10 + i; // 자리수 증가
            if (isPrime(newNumber)) { // 소수면 DFS 추가진행
                DFS(newNumber, level + 1);
            }
        }
    }


    // 어떤 숫자가 소수인지 판별하는 메서드
    static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
