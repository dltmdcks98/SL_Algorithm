package org.example.chap09;

//https://www.acmicpc.net/problem/1541

/*
 100-40+50+74-30+29-45+43+11
 최소값을 구하려면 +가 포함되어 있으면 ()를 친다.
 즉 - 바로 뒤에 괄호를 친다.
 */

import java.util.Arrays;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/1541
public class 그리디02 {
    public static void main(String[] args) {
        //문자열 분리 함수
        //split, StringTokenizer => Tokenizer 가 성능이 더 좋음
        String str = "100-40+50+74-30+29-45+43+11";

        /*String[] sArr = str.split("-");
        System.out.println(Arrays.toString(sArr));*/

        /*
        @param 2 = 어떤 기준으로 나눌건지, 없으면 공백 기준
         */
        StringTokenizer st = new StringTokenizer(str,"-");

        int answer = 0;//연산결과 저장
        for(int i=0; st.hasMoreTokens(); i++){
            String s = st.nextToken();
            int sum = makeSum(s);
            if(i==0){
                answer += sum;
            }else {
                answer -= sum;
            }
        }
        System.out.println(answer);



    }

    //토큰 문자열(ex:50+20+30)을 받아서 총합을 구해주는 메서드
    private static int makeSum(String s) {
        int total = 0;
        StringTokenizer st = new StringTokenizer(s, "+");
        while(st.hasMoreTokens()){
            total+= Integer.parseInt(st.nextToken());
        }
        return total;
    }
}
