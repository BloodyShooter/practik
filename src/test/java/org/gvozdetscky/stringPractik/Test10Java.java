package org.gvozdetscky.stringPractik;

import org.junit.Test;

import java.util.ArrayList;

public class Test10Java {
    @Test
    public void test10Java() throws Exception {
        var list = new ArrayList<>();
        list.add("New Features Java 10");

        list.forEach(System.out::println);
    }
}
