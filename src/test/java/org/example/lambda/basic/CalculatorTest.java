package org.example.lambda.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void test(){
/*        Calculator casio = new CasioCalculator();
        casio.add(10,20);*/
        /*
        짜증 나는 점 :
        Sharp 계산기를 쓰고 싶은데 한번만 쓰고 안쓸 계산기인데 => 지역에서만 사용하는데
        새로 만들어야 Sharp 계산기를 사용할 수 있다. => 익명 클래스를 사용 하여 해결

        익명 클래스 만드는 법
         */
/*        Calculator sharp = new Calculator(){
            @Override
            public int add(int n1, int n2) {
                System.out.println("샤프 계산기로 더하기");
                return n1+n2;
            }

            @Override
            public int sub(int n1, int n2) {
                return 0;
            }
        };

        sharp.add(30,40);*/

        Calculator addCalc = new Calculator() {
            @Override
            public int calc(int n1, int n2) {
                return n1+n2;
            }
        };
        addCalc.calc(10,20);

        /*
        람다식을 쓰기 위한 전제 조건 : 해당 인터페이스에 추상메서드가 반드시 단 한개일 것
        스크립트에서는 함수를 생성하지만
        java에서는 개체를 생성해서 객체를 return 해준다.
         */
        Calculator addCalcLambda = (n1, n2) -> n1 + n2;

        int rq= addCalcLambda.calc(10,20);
        Calculator multiCalc = (n1, n2) -> n1*n2;
        int r2= multiCalc.calc(10,20);


        Operator op = new Operator(10,20);

        op.operate(addCalc);

        int r3 = op.operate((n1,n2) -> n1 -n2);
        System.out.println("r3 ="+r3);

        int r4 = op.operate((n1,n2)->n1%n2);
        System.out.println("r4 ="+r4 );



    }

}