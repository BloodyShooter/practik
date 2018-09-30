package org.gvozdetscky.ioPractik;

public class Main {
    public static void main(String[] args) {
        IOClass io = new IOClass("D:\\test.my", 0);

        SerialTest serialTest = new SerialTest();

        serialTest.age = 47;
        serialTest.name = "ферст нэйм";

        System.out.println("====1obj====");
        System.out.println(serialTest);

        io.writeObject(serialTest);

        serialTest.age = 0;
        serialTest.name = "Секонд нэйм";

        System.out.println("====editobj====");
        System.out.println(serialTest);

        serialTest = (SerialTest) io.readObject();

        System.out.println("====loadobj====");
        System.out.println(serialTest);
    }
}
