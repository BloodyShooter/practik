package org.gvozdetscky.exceptionPractik;

/**
 * Этот класс был написан по примеру
 * @see <a href="http://javastudy.ru/interview/exceptions/">Собеседование по Java</a>
 */
public class LoseException {
    public static void main(String[] args) {
        Exception ex = twoExceptionsMethod();
        System.out.println(ex.getClass());
    }

    public static Exception twoExceptionsMethod() {
        try {
            return new IndexOutOfBoundsException();
        } finally {
            return new NullPointerException();
        }
    }
}
