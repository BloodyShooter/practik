package org.gvozdetscky.exceptionPractik;

import org.junit.Test;

public class ExceptionTest {

    @Test
    public void testException() {
        try {
            throw new MyException("Моя ошибка");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRuntimeException() {
        try {
            throw new MyRuntimeException();
        } catch (MyRuntimeException e) {
            e.printStackTrace();
        }
    }

}