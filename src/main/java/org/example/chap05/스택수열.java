package org.example.chap05;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

//백준 1874

/*
 * Scanner, String 을 사용하면 메모리 초과가 이용하는이유
 * String에 +=를 하면 기존에 있는것을 지우는것이 아니라 새로운 String 객체를 생성 => StringBuilder를 사용 StringBuffered의 발전된게 StringBuilder
 * Scanner는 운영체제를 한번 거쳐서 내부의 Scanner를 사용하는데 BufferedReader는 직접 접근
 */
public class 스택수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());//readLine = 한 줄당 한번의 입력 반환형은 String

        /*
        한 줄에 여러 숫자 입력받기
         EX)5 3
         StringTokenizer = String을 Token화 => 공백을 기준으로 자른다.
         즉 Token 5 하나 Token 3 하나
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
         */



        //만들어야 할 수열
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] =Integer.parseInt(br.readLine()) ;
        }


        Stack<Integer> stack = new Stack<>();

        //자연수 변수
        int num = 1;

        //기호를 저장할 문자열 변수
        StringBuilder s = new StringBuilder("");


        //수열 배열 A에서 값을 하나씩 타겟팅해서 push,pop 여부 확인
        for (int i = 0; i <N; i++) {
            int targetNum = A[i];//현재 타겟 값

            //push인 경우
            if(targetNum >= num){
                while(targetNum>=num){
                    stack.push(num++);
                    s.append("+\n");
                }
                //타겟 넘버에 도달하는 순간 해당 숫자를 pop
                Integer k = stack.pop();
                s.append("-\n");
            }
            //pop인 경우
            else{
                Integer n = stack.pop();
                if(n > targetNum){
                    //스택 수열 실패 케이스
                    s = new StringBuilder("NO");
                    break;
                }else {
                    s.append("-\n");
                }
            }
        }//for문 끝
        System.out.println(s);

    }
}
