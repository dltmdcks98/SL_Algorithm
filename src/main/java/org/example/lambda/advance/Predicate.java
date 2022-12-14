package org.example.lambda.advance;

public interface Predicate<T> {

    //Type을 범용적으로 만들려면 Generic Type을 T로 한다.
    boolean test(T t);
}
