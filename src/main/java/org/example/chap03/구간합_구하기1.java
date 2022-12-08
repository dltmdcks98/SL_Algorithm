package org.example.chap03;

import java.util.Arrays;

//https://www.acmicpc.net/problem/11659
public class 구간합_구하기1 {

    public static void main(String[] args) {
        int N= 5; //배열에 저장할 숫자 개수
        int M= 3; //테스트 케이스 숫자(합을 몇번 구할건지)

        int[] A = {5,4,3,2,1};
        System.out.println(Arrays.toString(A));

        //합배열 S 구하기
        //S[i] = S[i-1] + A[i]
        int[] S = new int[A.length];

        S[0] = A[0];//index outOfBound를 피하기 위함
        for(int i=1 ; i<S.length;i++){
            S[i] = S[i-1]+A[i];
        }
        System.out.println(Arrays.toString(S));

        // 1 ~ 3번째 = 인덱스 (0~2) 의 누적합
        int a1 = S[2];
        //2~4 (1~3)
        int a2 = S[3] - S[0];
        //5~5 (4~4)
        int a3 = S[4]-S[3];
        System.out.printf("%d %d %d \n",a1,a2,a3);
    }
}
