package org.gvozdetscky.exceptionPractik;

public class MyRuntimeException extends RuntimeException {

    MyRuntimeException() {
        super();
        System.out.println("Внутри ошибки runtimeException");
    }
}
