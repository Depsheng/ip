import java.util.*;

public class List {
    private static ArrayList<Task> list =  new ArrayList<>(); // List to keep the list of Tasks

    public static void add(Task t) { // Add new Task depending on the description
        list.add(t);
    }

    public static void mark(int n) { //to mark task as done and display message
        if (n >= 0 && n <= list.size()) {
            Task t =  list.get(n - 1);
            System.out.println("____________________________________________________________");
            System.out.println("Nice! I've marked this task as done:");
            t.set(true);
            System.out.println(t.getDescription());
            System.out.println("____________________________________________________________");
        } else {
            System.out.println("__________________________________________________________");
            System.out.println("Sorry! There is no such task.");
            System.out.println("____________________________________________________________");
        }
    }

    public static void unmark(int n) {//to mark task as not done and display message
        if (n >= 0 && n <= list.size()) {
            Task t =  list.get(n - 1);
            System.out.println("____________________________________________________________");
            System.out.println("OK, I've marked this task as not done yet:");
            t.set(false);
            System.out.println(t.getDescription());
        } else {
            System.out.println("__________________________________________________________");
            System.out.println("Sorry! There is no such task.");
            System.out.println("____________________________________________________________");
        }
    }

    public static void toPrint() { //print the list of tasks
        int len = list.size();
        System.out.println("____________________________________________________________");
        for (int i = 0; i < len ; i++) {
            Task t = list.get(i);
            String num = Integer.toString(i + 1);
            System.out.println(num + "." + t.getDescription());
        }
        System.out.println("____________________________________________________________");
    }

    public static String getNum() {
        String num = Integer.toString(list.size());
        return "Now you have" + " " + num + " " + "tasks in the list.";
    }

}
