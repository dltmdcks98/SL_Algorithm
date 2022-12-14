package org.example.lambda.basic;

@FunctionalInterface //람다식을 쓸 수 있는 인터페이스인지 컴파일라인에서 체크
public interface Calculator {
/*
    int add(int n1, int n2);
    int sub(int n1, int n2);

    //오버라이딩 강요 X => default 메소드
    default int multi(int n1, int n2){
        return 0;
    }*/

    //calc를 호출할때 호출자가 직접 구현하여 사용
    int calc(int n1, int n2);

    //default 메소드는 추가해도 람다식을 사용할 수 있다.
    default void lamvd(){};

}
