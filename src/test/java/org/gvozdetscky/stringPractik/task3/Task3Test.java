package org.gvozdetscky.stringPractik.task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Task3Test {

    @Test
    public void createNewStrTest() {
        String result = new Task3().createNewStr();

        assertNotNull(result);

        System.out.println("test for Task2 done.");
    }
}