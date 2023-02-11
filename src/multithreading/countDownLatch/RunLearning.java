package multithreading.countDownLatch;

import java.util.ArrayList;

public class RunLearning {
    public static void main(String[] args) {
        final int NUMBER_TASKS_1 = 5;
        Student student1 = new Student(123, NUMBER_TASKS_1);
        for (int i = 0; i < NUMBER_TASKS_1; i++) {
            student1.addTask(new Task("Task #" + i));
        }

        final int NUMBER_TASKS_2 = 4;
        Student student2 = new Student(345, NUMBER_TASKS_2);
        for (int i = 0; i < NUMBER_TASKS_2; i++) {
            student2.addTask(new Task("Task #" + i));
        }

        ArrayList<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        Tutor tutor = new Tutor(list);
        student1.start();
        student2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tutor.start();
    }
}
