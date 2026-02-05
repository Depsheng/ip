package lala;

import lala.exception.NoDescriptionException;
import lala.task.Task;


import java.io.*;
import java.util.*;

public class List {
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
    public static String mark(int n) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (n > 0 && n <= list.size()) {
            Task t =  list.get(n - 1);
            t.set(true);
            sb.append("Nice! I've marked this task as done:\n");
            sb.append(t.getDescription()).append("\n");
        } else {
            sb.append("Sorry! There is no such task.\n");
        }
        Storage.saveAll(list);
        return sb.toString();
    }

    // to mark task as not done and display message
    public static String unmark(int n) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (n > 0 && n <= list.size()) {
            Task t =  list.get(n - 1);
            t.set(false);
            sb.append("OK, I've marked this task as not done yet:\n");
            sb.append(t.getDescription()).append("\n");
        } else {
            sb.append("Sorry! There is no such task.\n");
        }
        Storage.saveAll(list);
        return sb.toString();
    }

    // to delete task
    public static String delete(int n) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (n > 0 && n <= list.size()) {
            Task t =  list.get(n - 1);
            list.remove(n - 1);
            sb.append("Noted. I've removed this task:\n");
            sb.append(t.getDescription()).append("\n");
            sb.append(getNum());
        } else {
            sb.append("Sorry! There is no such task.\n");
        }
        Storage.saveAll(list);
        return  sb.toString();
    }

    public static String toPrint() { //print the list of tasks
        StringBuilder sb = new StringBuilder();
        int len = list.size();
        for (int i = 0; i < len ; i++) {
            Task t = list.get(i);
            sb.append(i + 1).append(". ").append(t.getDescription()).append("\n");
        }
        sb.append(List.getNum()).append("\n");
        return sb.toString();
    }


    public static String getNum() {
        String num = Integer.toString(list.size());
        return "Now you have" + " " + num + " " + "tasks in the list.";
    }


    // finds all Task containing the keyword key
    public static ArrayList<Task> findAll(String key) {
        ArrayList<Task> keyList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).hasKey(key)) {
                keyList.add(list.get(i));
            }
        }
        return keyList;
    }
}
