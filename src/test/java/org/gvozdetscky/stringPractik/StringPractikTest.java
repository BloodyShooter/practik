package org.gvozdetscky.stringPractik;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringPractikTest {



    private final StringPractik stringPractik = new StringPractik();

    @Test
    public void lengthStrTest() {
        final String startStr = "Hello";
        final int finalLength = 5;

        int result = stringPractik.getLengthStr(startStr);

        assertEquals(result, finalLength);

        System.out.println("test for Task1 done.");
    }



    @Test
    public void compareStrTest() {
        final String firstStr = "Александр";
        final String secondStr = "александр";

        boolean result = stringPractik.compareStr(firstStr, secondStr);

        assertTrue(result);

        System.out.println("test for Task2 done.");
    }

    @Test
    public void createNewStrTest() {
        String result = stringPractik.createNewStr();

        assertNotNull(result);

        System.out.println("test for Task3 done.");
    }

    @Test
    public void getCharsTest() {
        final String str = "Hello";
        final char[] charArray = {'H', 'e', 'l', 'l', 'o'};

        char[] result = stringPractik.getChars(str);

        assertArrayEquals(result, charArray);

        System.out.println("test for Task6 done.");
    }

    @Test
    public void getBytesTest() {
        final String str = "Hello";
        final byte[] byteArray = {'H', 'e', 'l', 'l', 'o'};

        byte[] result = stringPractik.getBytes(str);

        assertArrayEquals(result, byteArray);

        System.out.println("test for Task7 done.");
    }

    @Test
    public void getUpperCaseTest() {
        final String str = "Hello";
        final String actualString = "HELLO";

        String result = stringPractik.getUpperCase(str);

        assertEquals(result, actualString);

        System.out.println("test for Task9 done.");
    }

    @Test
    public void getFirstPositionCharATest() {
        final String str = "Banana";
        final int actual = 1;

        int result = stringPractik.getFirstPositionCharA(str);

        assertEquals(result, actual);

        System.out.println("test for Task9 done.");
    }

    @Test
    public void getLastPositionCharATest() {
        final String str = "Banana";
        final int actual = 5;

        int result = stringPractik.getLastPositionCharA(str);

        assertEquals(result, actual);

        System.out.println("test for Task10 done.");
    }

    @Test
    public void isContainsSunTest() {
        final String str = "Praise the Sun";

        boolean result = stringPractik.isContainsSun(str);

        assertTrue(result);

        System.out.println("test for Task11 done.");
    }

    @Test
    public void isEndsOracleTest() {
        final String str = "Java belongs to Oracle";

        boolean result = stringPractik.isEndsOracle(str);

        assertTrue(result);

        System.out.println("test for Task12 done.");
    }

    @Test
    public void isStartsJavaTest() {
        final String str = "Java belongs to Oracle";

        boolean result = stringPractik.isStartsJava(str);

        assertTrue(result);

        System.out.println("test for Task13 done.");
    }

    @Test
    public void replaceAndGetStringTest() {
        final String str = "Banana";
        final String actualString = "Bonono";

        String result = stringPractik.replaceAndGetString(str);

        assertEquals(result, actualString);

        System.out.println("test for Task14 done.");
    }

    @Test
    public void getSubstringTest() {
        final String str = "Java is a general-purpose computer-programming language";
        final String actualString = " is a";

        String result = stringPractik.getSubstring(str);

        assertEquals(result, actualString);

        System.out.println("test for Task15 done.");
    }

    @Test
    public void splitStringTest() {
        final String str = "cat,dog,house";
        final String[] actualArrayString = {"cat", "dog", "house"};

        String[] result = stringPractik.splitString(str);

        assertArrayEquals(result, actualArrayString);

        System.out.println("test for Task16 done.");
    }

    @Test
    public void createAndGetStringBuilderTest() {
        final String str = "Create StringBuilder";

        StringBuilder result = stringPractik.createAndGetStringBuilder(str);

        assertTrue(result instanceof StringBuilder);

        System.out.println("test for Task17 done.");
    }

    @Test
    public void addSymbolAndGetStringBuilderTest() {
        final StringBuilder str = new StringBuilder("Hello");
        final StringBuilder actualString = new StringBuilder("Hello1");

        StringBuilder result = stringPractik.addSymbolAndGetStringBuilder(str, '1');

        assertEquals(result.toString(), actualString.toString());

        System.out.println("test for Task18 done.");
    }

    @Test
    public void deleteOracleAndGetBuilderTest() {
        final StringBuilder str = new StringBuilder("Java belongs to Oracle");
        final StringBuilder actualString = new StringBuilder("Java belongs to");

        StringBuilder result = stringPractik.deleteOracleAndGetString(str);

        assertEquals(result.toString(), actualString.toString());

        System.out.println("test for Task19 done.");
    }

    @Test
    public void reversStringTest() {
        final String str = "Hello";
        final String actualString = "olleH";

        String result = stringPractik.reversString(str);

        assertEquals(result, actualString);

        System.out.println("test for Task20 done.");
    }

}