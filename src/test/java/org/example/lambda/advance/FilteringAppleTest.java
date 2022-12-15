package org.example.lambda.advance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static org.example.lambda.advance.Apple.Color.GREEN;
import static org.example.lambda.advance.Apple.Color.RED;
import static org.example.lambda.advance.Book.Genre.*;
import static org.example.lambda.advance.FilteringApple.*;
import static org.junit.jupiter.api.Assertions.*;

class FilteringAppleTest {

    @Test
    void ttt(){
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(80, GREEN));
        inventory.add(new Apple(155, GREEN));
        inventory.add(new Apple(120, RED));
        inventory.add(new Apple(90, GREEN));
        inventory.add(new Apple(110, RED));
        inventory.add(new Apple(50, RED));

        //녹색 사과만 필터링
//        List<Apple> list = filterGreenApples(inventory);

        //색깔을 지정 ->무게 지정 x
//        List<Apple> list = filterApplesByColor(inventory,RED);

        ///필터 조건을 지정
/*        List<Apple> list = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor()==GREEN;//이곳만 바꾸면 무게나 색의 조건을 마음대로 할 수 있다.
            }
        });*/
        List<Apple> list = filterApples(inventory,
                apple -> apple.getWeight()>100 && apple.getColor()==RED); // 파라미터 타입, return  생략 가능

        for (Apple apple : list) {
            System.out.println(apple);
        }


        //범용 메서드  filter  사용
        List<Book> bookList = new ArrayList<>();
        bookList.addAll(
                Arrays.asList(
                        new Book(10000, HISTORY)
                        , new Book(20000, ESSAY)
                        , new Book(15000, HISTORY)
                        , new Book(14000, BIBLE)
                        , new Book(17000, COMICS)
                        , new Book(13000, COMICS)
                )
        );

        List<Book> books = filter(bookList, b -> b.getGenre() == COMICS);
        List<Apple> apples = filter(inventory, a -> a.getWeight() < 100);

        // 정수 리스트
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);




        // 홀수만 필터링
        List<Integer> integers = filter(numbers, n -> n % 3 == 0);
        for (Integer n : integers) {
            System.out.println(n);
        }


        //java에서 생성한 filter
        List<Integer> integerList = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());//List로만 전달하는게 아니라 다른 자료구조 형태로 전달 가능
        System.out.println(integerList);

    }


    @Test
    void sortTest(){
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(80, GREEN));
        inventory.add(new Apple(155, GREEN));
        inventory.add(new Apple(120, RED));
        inventory.add(new Apple(90, GREEN));
        inventory.add(new Apple(110, RED));
        inventory.add(new Apple(50, RED));

        //정렬 (정수를 정렬하는 것이 객체를 정렬하려면 기준이 있어야한다.)
/*        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight(); //양수면 뒤로 음수가 나오면 그 자리에서 대기 즉 무게 오름차순
            }
        });*/
        //import static java.util.Comparator.*;
        //무게 오름차 정렬
        /*inventory.sort(comparing(apple -> apple.getWeight()));*/
        inventory.sort(comparing(Apple::getWeight));

        //무게 내림차 정렬
        inventory.sort(comparing(Apple::getWeight).reversed());
        inventory.forEach(System.out::println);

    }
}