package org.example.chap5.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void stackTest(){
        Stack<String> foodStack = new Stack<>();
        foodStack.push("짜장면");
        foodStack.push("볶음밥");
        foodStack.push("짬뽕");
        foodStack.push("깐풍기");

        String r1 = foodStack.pop();
        System.out.println("r1 = "+r1);

        assertEquals("깐풍기", r1);

        foodStack.pop();
        foodStack.pop();
        foodStack.pop();
        foodStack.pop();
    }

}