package org.gvozdetscky.stringPractik;

public class StringPractik {

    /**
     * method return length of str
     * @param str str for getting the length
     * @return length of str
     */
    public int getLengthStr(String str) {
        return str.length();
    }

    /**
     *
     * @param str1 first str
     * @param str2 second str
     * @return true if strings equal ignore case
     */
    public boolean compareStr(String str1, String str2) {
        return str1.toLowerCase().equals(str2.toLowerCase());
    }

    /**
     * create a new string use constructor
     * @return new string
     */
    public String createNewStr() {
        return new String("Новая строка");
    }

    /**
     * return from a string an array of characters
     * @param str string
     * @return array of characters
     */
    public char[] getChars(String str) {
        return str.toCharArray();
    }

    /**
     * return from a string to a byte array
     * @param str string
     * @return byte array
     */
    public byte[] getBytes(String str) {
        return str.getBytes();
    }

    /**
     * return the string with upper case
     * @param str string
     * @return string
     */
    public String getUpperCase(String str) {
        return str.toUpperCase();
    }

    /**
     * return the first position of the character "a"
     * @param str string
     * @return int
     */
    public int getFirstPositionCharA(String str) {
        return str.indexOf('a');
    }

    /**
     * return the last position of the character "a"
     * @param str string
     * @return int
     */
    public int getLastPositionCharA(String str) {
        return str.lastIndexOf('a');
    }

    /**
     * contains-if the string word "Sun"
     * @param str string
     * @return true if the string contains word "Sun"
     */
    public boolean isContainsSun(String str) {
        return str.contains("Sun");
    }

    /**
     * ends-if the string "Oracle"
     * @param str string
     * @return true if the string ends word "Oracle"
     */
    public boolean isEndsOracle(String str) {
        return str.endsWith("Oracle");
    }

    /**
     * starts-if the string "Java"
     * @param str string
     * @return true if the string starts word "Java"
     */
    public boolean isStartsJava(String str) {
        return str.startsWith("Java");
    }

    /**
     * Replace all characters "a" to "o"
     * @param str string
     * @return String where replace a to o
     */
    public String replaceAndGetString(String str) {
        return str.replace('a', 'o');
    }

    /**
     * To get a substring from 4 character 9 character
     * @param str string
     * @return String from 4 char to 9
     */
    public String getSubstring(String str) {
        return str.substring(4, 9);
    }

    /**
     * split str
     * @param str string
     * @return array String split ","
     */
    public String[] splitString(String str) {
        return str.split(",");
    }

    /**
     * creating String Builder from str
     * @param str string
     * @return StringBuilder from String
     */
    public StringBuilder createAndGetStringBuilder(String str) {
        return new StringBuilder(str);
    }

    /**
     * Add to the end of the string the StringBuilder character
     * @param str stringBuilder
     * @param ch symbol who add end
     * @return StringBuilder where add char of the end
     */
    public StringBuilder addSymbolAndGetStringBuilder(StringBuilder str, char ch) {
        return str.append(ch);
    }

    /**
     * Delete to ' Oracle' from StringBuilder
     * @param str stringBuilder
     * @return String where delete ' Oracle'
     */
    public StringBuilder deleteOracleAndGetString(StringBuilder str) {
        String pattern = " Oracle";
        int indexOfOracle = str.indexOf(pattern);

        return str.delete(indexOfOracle, indexOfOracle + pattern.length());
    }

    /**
     * reverse str
     * @param str string
     * @return reverse string
     */
    public String reversString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

}
