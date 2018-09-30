package org.gvozdetscky.ioPractik;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class IOClass {

    String filePath;
    int lvlCompression;

    public IOClass(String filePath, int lvlCompression) {
        this.filePath = filePath;
        this.lvlCompression = lvlCompression;
    }

    public void writeObject(Serializable object) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object readObject() {
        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filePath))) {
             return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
