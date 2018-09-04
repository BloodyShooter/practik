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

    static class A {

    }

    static class B extends A {

    }

    static class C extends B {

    }

    @Test
    public void test() {
        C c = new C();
        B b = new B();
        A a = new A();
    }

    public static void main(String[] args) {
        C c = new C();
        B b = new B();
        A a = new A();
    }
}
