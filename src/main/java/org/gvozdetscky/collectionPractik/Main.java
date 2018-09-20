package org.gvozdetscky.collectionPractik;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();

        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            tasks.add(new Task(rnd.nextInt(5)));
        }

        Collections.sort(tasks);

        tasks.forEach(System.out::println);

        tasks.forEach(task -> task.done());
    }
}
