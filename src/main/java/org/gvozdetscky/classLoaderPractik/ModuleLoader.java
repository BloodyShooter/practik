package org.gvozdetscky.classLoaderPractik;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Этот класс был написан по примеру
 * @see <a href="http://samolisov.blogspot.com/2008/01/java.html">Пишем свой загручик java-классов</a>
 */
public class ModuleLoader extends ClassLoader {

    /**
     * Здесь хранятся загруженные классы
     */
    private HashMap<String, Class<?>> cache = new HashMap<>();

    /**
     * Путь к jar
     */
    private String jarFilePath;

    /**
     * Пакеты
     */
    private String packageName;

    /**
     * Собственно конструктор
     * @param jarFilePath путь к jar файлу
     * @param packageName корневые пакеты
     */
    public ModuleLoader(String jarFilePath, String packageName) {
        this.jarFilePath = jarFilePath;
        this.packageName = packageName;

    }

    /**
     * Загружает класс в кеш по имени класса
     * @param name имя класса без указания пакета
     * @return если загрузка прошла успешно, то вернет класс. Иначе null
     */
    private Class<?> loadClassInCache(String name) {
        try {
            JarFile jarFile = new JarFile(jarFilePath);
            JarEntry entry = jarFile.getJarEntry(normalizeFS(packageName) + "/" + name + ".class");
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

        return cache.get(packageName + "." + name);
    }

    /**
     * Переопределенный метод для получения класса
     * Проверяет кэш, еслип не найден идет спрашивать загрузчика чином повыше,
     * В случае провала сам подргружает класс
     * @param name имя класса
     * @return возврашает загружанный класс
     * @throws ClassNotFoundException выбрасывается если класс не найден
     */
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> result = cache.get(name);

        if (result == null) {
            result = cache.get(packageName + "." + name);
        }

        if (result == null) {
            try {
                result = super.findSystemClass(name);
            } catch (ClassNotFoundException e) {
                result = loadClassInCache(name);
                System.out.println(result);
                if (result == null) throw new ClassNotFoundException("класс не был найден");
            }
        }

        System.out.println("== loadClass(" + name + ")");

        return result;
    }

    /**
     * Получаем каноническое имя класса
     * (убираем .class в конце)
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
     * Преобразуем имя класса в имя в файловой системе
     * (заменяем точки на слэши)
     *
     * @param className
     * @return
     */
    private String normalizeFS(String className) {
        return className.replace('.', '/');
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

    /**
     * Загружаем класс из jar архива по ссылки на класс
     * @param jarFile путь к архиву
     * @param jarEntry путь к классу внутри архива
     * @return массив байтов, которые представляют класс
     * @throws IOException произошли ошибки чтения
     */
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