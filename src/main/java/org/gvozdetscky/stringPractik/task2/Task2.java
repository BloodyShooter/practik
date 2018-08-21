package org.gvozdetscky.stringPractik.task2;

/**
 * class for Compare 2 strings with ignore case
 */
public class Task2 {

    /**
     *
     * @param str1 first str
     * @param str2 second str
     * @return true if strings equal ignore case
     */
    public boolean compareStr(String str1, String str2) {
        return str1.toLowerCase().equals(str2.toLowerCase());
    }
}
