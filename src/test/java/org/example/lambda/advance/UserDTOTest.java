package org.example.lambda.advance;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {

    @Test
    void ttss(){
        // DB에서 가져온 회원정보 리스트
        List<User> userList = Arrays.asList(
                new User("1", "aaa@naver.com", "123", "딸긔겅듀"),
                new User("2", "bbb@naver.com", "444", "관종겅듀"),
                new User("3", "ccc@naver.com", "555", "그지겅듀"),
                new User("4", "ddd@naver.com", "666", "핑크겅듀")
        );

        //클라이언트에게 전체를 보내지 말고 지정된 항목만 보냄
        /*
        List<UserDTO> response = new ArrayList<>();
        for (User user : userList) {
            UserDTO dto = new UserDTO(user);
            response.add(dto);
        }
         => 람다 이용
         */
        /*
            List<UserDTO> response = userList.stream()
                .map(user -> new UserDTO(user))
                .collect(Collectors.toList());
                => 개선
                */
        List<UserDTO> response = userList.stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
        response.forEach(System.out::println);

        /*
            .stream 연계 메서드
            1. forEach : 컬렉션의 내부 요소들 하나씩 소비
            2. filter : 컬렉션 내부 요소들을 하나씩 검사하여 필터링한 새로운 컬렉션 반환 (컬렉션은 자료구조라고 생각)
            3. map : 컬렉션 내부 요소들을 하나씩 주어진 조건대로 맵핑하여 새로운 컬렉션 반환

            EX)arr.filter(n -> n % 2 ==0)
                => 숫자배열에서 짝수들만 뽑아서 새배열 리턴

                arr.map(n -> n * 2)
                => 숫자배열의 모든 원소들을 2배씩 늘려놓은 새 배열 리턴
                [1 2 3 4 5] => [2 4 6 8 10]
         */

    }

}