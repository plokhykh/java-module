package multithreading.countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Student extends Thread {
    private Integer idStudent;
    private List<Task> taskList;
    private CountDownLatch countDown;

    public Student(Integer idStudent, int numberTasks) {
        this.idStudent = idStudent;
        this.taskList = new ArrayList<>(numberTasks);
        this.countDown = new CountDownLatch(numberTasks);
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public CountDownLatch getCountDown() {
        return countDown;
    }

    public void addTask (Task task){
        taskList.add(task);
    }

    @Override
    public void run() {
        int i = 0;
        for (Task inWork : taskList) {
            try{
                Thread.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            inWork.setAnswer("Answer #" + ++i);
            System.out.println("Answer #" + i + " from " + idStudent);
        }

        try {
            countDown.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        double averageMark = 0;
        for (Task task : taskList) {
            averageMark += task.getMark();
        }
        averageMark /= taskList.size();
        System.out.println("Student " + idStudent + ": Average mark = " + averageMark);
    }
}
