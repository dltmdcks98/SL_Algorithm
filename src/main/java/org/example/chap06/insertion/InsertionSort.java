package org.example.chap06.insertion;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] arr){

        //[6,3,15,7,2]
        //2번째 데이터부터 타겟팅해서 시작
        for (int i = 1; i < arr.length; i++) {
            //타겟 데이터 백업
            int temp = arr[i];
            int j =i;

            //삽입 위치를 찾는 while문
            while(j>0 && arr[j - 1]>= temp){//j>0 => out of boundException 방지
                //타겟의 왼쪽데이터가 타겟보다 크면
                //왼쪽 데이터를 우츨으로 한칸 이동
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;//찾은 위치에 타겟데이터 삽입
        }
    }

    public static void main(String[] args) {
        int[] arr = {33, 11, 99, 1, 22, 88, 55, 44, 66, 77};

        sort(arr); // 삽입 정렬

        System.out.println("정렬 후: " + Arrays.toString(arr));
    }
}
