package org.gvozdetscky.stringPractik.task2;

import org.junit.Test;

import static org.junit.Assert.*;

public class Task2Test {

    final String firstStr = "Александр";
    final String secondStr = "александр";

    @Test
    public void compareStrTest() {
        boolean result = new Task2().compareStr(firstStr, secondStr);

        assertTrue(result);

        System.out.println("test for Task2 done.");
    }

}