package queueExcercise;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExercise {
    public static void main(String[] args) {
        Queue<String> queuedCustomers = new LinkedList<>();

        queuedCustomers.add("1");
        queuedCustomers.add("2");
        queuedCustomers.add("3");
        queuedCustomers.add("4");

        while (!queuedCustomers.isEmpty()){
            System.out.println("Customer " + queuedCustomers.poll() + " is getting helped!");
        }
    }
}
