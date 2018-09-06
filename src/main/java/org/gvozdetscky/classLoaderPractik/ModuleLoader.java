package org.gvozdetscky.classLoaderPractik;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

public class ModuleLoader extends ClassLoader {

    /**
     * Здесь хранятся загруженные классы
     */
    private HashMap<String, Class<?>> cache = new HashMap<>();

    /**
     * Путь к jar
     */
    private String jarFilePath;

    private String packageName;

    public ModuleLoader(String jarFilePath, String packageName) {
        this.jarFilePath = jarFilePath;
        this.packageName = packageName;

        anotherCacheClasses();
    }

    private void cacheClasses() {
        try {
            JarFile jarFile = new JarFile(jarFilePath);
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = entries.nextElement();
                System.out.println(jarEntry.getName());
                if (match(normalize(jarEntry.getName()), packageName)) {
                    byte[] classData = loadClassData(jarFile, jarEntry);
                    if (classData != null) {
                        Class<?> clazz = defineClass(
                                stripClassName(normalize(jarEntry.getName())),
                                classData, 0, classData.length
                        );
                        if (!clazz.isInterface()) {
                            cache.put(clazz.getName(), clazz);
                            System.out.println("== class " + clazz.getName() + " loaded in cache");
                        }

                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void anotherCacheClasses() {
        try {
            JarFile jarFile = new JarFile(jarFilePath);
            JarEntry entry = jarFile.getJarEntry("org/gvozdetscky/classLoaderPractik/ModulePrinter.class");
            if (match(normalize(entry.getName()), packageName)) {
                byte[] classData = loadClassData(jarFile, entry);
                if (classData != null) {
                    Class<?> clazz = defineClass(
                            stripClassName(normalize(entry.getName())),
                            classData, 0, classData.length
                    );
                    cache.put(clazz.getName(), clazz);
                    System.out.println("== class " + clazz.getName() + " loaded in cache");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> result = cache.get(name);

        if (result == null) {
            result = cache.get(packageName + "." + name);
        }

        if (result == null) {
            result = super.findSystemClass(name);
        }

        System.out.println("== loadClass(" + name + ")");

        return result;
    }

    public boolean deleteClassInCache(String name) {
        Class<?> removeClass = cache.remove(name);

        if (removeClass == null) {
            removeClass = cache.get(packageName + "." + name);
        }

        System.out.println("== remove " + removeClass.getName());

        return removeClass == null;


    }

    /**
     * Получаем каноническое имя класса
     *
     * @param className
     * @return
     */
    private String stripClassName(String className) {
        return className.substring(0, className.length() - 6);
    }

    /**
     * Преобразуем имя в файловой системе в имя класса
     * (заменяем слэши на точки)
     *
     * @param className
     * @return
     */

    private String normalize(String className) {
        return className.replace('/', '.');
    }

    /**
     * Валидация класса - проверят принадлежит ли класс заданному пакету и имеет ли
     * он расширение .class
     *
     * @param className
     * @param packageName
     * @return
     */
    private boolean match(String className, String packageName) {
        return className.startsWith(packageName) && className.endsWith(".class");
    }

    private byte[] loadClassData(JarFile jarFile, JarEntry jarEntry) throws IOException {
        long size = jarEntry.getSize();
        if (size == -1 || size == 0) {
            return null;
        }

        byte[] data = new byte[(int) size];
        InputStream in = jarFile.getInputStream(jarEntry);
        in.read(data);

        return data;
    }

}