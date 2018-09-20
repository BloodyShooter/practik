package org.gvozdetscky.collectionPractik;

public class Task implements Comparable<Task> {
    private int priority;

    public Task(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void done() {
        System.out.println("Done.");
    }

    @Override
    public String toString() {
        return "Task{" +
                "priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(Task o) {
        return Integer.compare(this.priority, o.priority);
    }
}
