package org.gvozdetscky.ioPractik;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class IOTest {

    final String pathFile = "D:\\test.my";
    final String pathZip = "D:\\myzip.zip";

    final IOClass io = new IOClass();
    final ZipClass zip = new ZipClass();

    @Test
    public void writeTest() {

        SerialTest serialTest = new SerialTest();

        serialTest.age = 47;
        serialTest.name = "ферст нэйм";

        System.out.println("====1obj====");
        System.out.println(serialTest);

        io.writeObject(serialTest, pathFile);

        assertTrue(new File(pathFile).exists());

        System.out.println("File " + pathFile + " exists!");
    }

    @Test
    public void doZipTest() {
        zip.doZip(pathZip, pathFile);

        assertTrue(new File(pathZip).exists());

        System.out.println("File " + pathZip + " exists!");

        File file = new File(pathFile);

        if (file.exists()) {
            file.delete();
            System.out.println("Delete file " + pathFile);
        }
    }

    @Test
    public void unZipTest() {

        zip.unZip(pathZip);

        assertTrue(new File(pathFile).exists());

        System.out.println("File " + pathFile + " exists!");
    }

    @Test
    public void readTest() {
        SerialTest serialTest = (SerialTest) io.readObject(pathFile);

        assertNotNull(serialTest);

        System.out.println(serialTest);
    }

}