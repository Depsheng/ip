package lala;

public class Ui {
    private static final String LINE = "____________________________________________________________";

    //prints Welcome message
    public void showWelcome() {
        System.out.println(LINE);
        System.out.println("Hello! I'm Lala");
        System.out.println("What can I do for you?");
        System.out.println(LINE);
    }

    //prints Bye message
    public void showBye() {
        System.out.println(LINE);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    public void showLine() {
        System.out.println(LINE);
    }

    // prints the NoSuchCommandException
    public void showErrorUnknownCommand() {
        System.out.println(LINE);
        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means.");
        System.out.println(LINE);
    }

    // prints the NoDescription Exception
    public void showErrorEmptyDescription() {
        System.out.println(LINE);
        System.out.println("☹ OOPS!!! The description of a task cannot be empty.");
        System.out.println(LINE);
    }


    public void showErrorGeneric(String msg) {
        System.out.println(LINE);
        System.out.println("☹ OOPS!!! Something went wrong: " + msg);
        System.out.println(LINE);
    }

    public void showMessage(String msg) {
        System.out.println(LINE);
        System.out.println(msg);
        System.out.println(LINE);
    }
}
