package lala;

import lala.exception.NoDescriptionException;
import lala.task.Task;


import java.io.*;
import java.util.*;

public class List {
    private static final String LINE = "____________________________________________________________";
    private static ArrayList<Task> list =  new ArrayList<>(); // List to keep the list of Tasks

    // Add new Task depending on the description
    public static void add(Task t) throws IOException {
        list.add(t);
        Storage.saveAll(list);
    }

    public static ArrayList<Task> getList() {
        return list;
    }

    // load the tasks into list
    public static void loadFromTxt() throws NoDescriptionException {
        try {
            list = Storage.load();
        } catch (IOException e) {
            list = new ArrayList<>();
        }
    }
    private static void saveToTxT() {}

    //to mark task as done and display message
    public static void mark(int n) throws IOException {
        if (n >= 0 && n <= list.size()) {
            Task t =  list.get(n - 1);
            System.out.println(LINE);
            System.out.println("Nice! I've marked this task as done:");
            t.set(true);
            System.out.println(t.getDescription());
            System.out.println(LINE);
        } else {
            System.out.println(LINE);
            System.out.println("Sorry! There is no such task.");
            System.out.println(LINE);
        }
        Storage.saveAll(list);
    }

    // to mark task as not done and display message
    public static void unmark(int n) throws IOException{
        if (n >= 0 && n <= list.size()) {
            Task t =  list.get(n - 1);
            System.out.println(LINE);
            System.out.println("OK, I've marked this task as not done yet:");
            t.set(false);
            System.out.println(t.getDescription());
        } else {
            System.out.println(LINE);
            System.out.println("Sorry! There is no such task.");
            System.out.println(LINE);
        }
        Storage.saveAll(list);
    }

    // to delete task
    public static void delete(int n) {
        if (n >= 0 && n <= list.size()) {
            Task t =  list.get(n - 1);
            System.out.println(LINE);
            System.out.println("Noted. I've removed this task:");
            list.remove(n - 1);
            System.out.println(t.getDescription());
            System.out.println(getNum());
            System.out.println(LINE);
        } else {
            System.out.println(LINE);
            System.out.println("Sorry! There is no such task.");
            System.out.println(LINE);
        }
    }

    public static void toPrint() { //print the list of tasks
        int len = list.size();
        System.out.println(LINE);
        for (int i = 0; i < len ; i++) {
            Task t = list.get(i);
            String num = Integer.toString(i + 1);
            System.out.println(num + "." + t.getDescription());
        }
        System.out.println(List.getNum());
        System.out.println(LINE);
    }

    public static String getNum() {
        String num = Integer.toString(list.size());
        return "Now you have" + " " + num + " " + "tasks in the list.";
    }

}
