package org.gvozdetscky.stringPractik.task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class Task1Test {

    private final String startStr = "Hello";
    private final int finalLength = 5;

    @Test
    public void lengthStrTest() {
        int result = new Task1().getLengthStr(startStr);

        assertEquals(result, finalLength);

        System.out.println("test for Task1 done.");
    }
}