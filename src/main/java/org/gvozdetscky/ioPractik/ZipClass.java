package org.gvozdetscky.ioPractik;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipClass {
    public void doZip(String nameZip, String pathFile) {
        try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(nameZip));
            FileInputStream fis = new FileInputStream(pathFile)) {

            File fileObj = new File(pathFile);

            zos.putNextEntry(new ZipEntry(fileObj.getName()));
            byte[] buffer = new byte[fis.available()];

            fis.read(buffer);

            zos.write(buffer);

            zos.closeEntry();

            //Удаляем файл
            fileObj.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void unZip(String nameZip) {
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(nameZip))) {

            ZipEntry entry = zis.getNextEntry();

            if (entry == null) {
                throw new RuntimeException("В архиве нету файла");
            }

            String name = entry.getName();
            long size = entry.getSize();

            System.out.println(getParentCatalog(nameZip) + name);

            try(FileOutputStream fos = new FileOutputStream(getParentCatalog(nameZip) + name)) {
                for (int c = zis.read(); c != -1; c = zis.read()) {
                    fos.write(c);
                }

                fos.flush();
            }

            zis.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getParentCatalog(String fileName) {

        File file = new File(fileName);

        File parentFolder = new File(file.getAbsolutePath()
                .substring(0, file.getAbsolutePath().lastIndexOf(
                        File.separator)));

        return parentFolder.getAbsolutePath();
    }
}
