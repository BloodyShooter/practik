package org.gvozdetscky.ioPractik;

import java.io.Serializable;

public class SerialTest implements Serializable {
    public String name;
    public int age;

    @Override
    public String toString() {
        return "SerialTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
