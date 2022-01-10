package org.example.jdk11;

import java.util.List;

public class Hello {

    public static void main(String[] args) {
        var listImmutable = List.of("a", "b", "c");
        var listImmutableCopy = List.copyOf(listImmutable);
        System.out.println(listImmutableCopy.add("s"));
    }

}
