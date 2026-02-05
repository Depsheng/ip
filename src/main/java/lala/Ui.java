package lala;

import lala.exception.NoDescriptionException;
import lala.exception.NoSuchCommandException;
import lala.task.Deadline;
import lala.task.Event;
import lala.task.Task;
import lala.task.ToDo;

import java.util.ArrayList;

public class Ui {

    //prints Welcome message
    public String showWelcome() {
        return "Hello! I'm Lala \n"
            + "What can I do for you?";
    }

    //prints Bye message
    public String showBye() {
        return "Bye. Hope to see you again soon!\n" +
                "I will be exiting in the next 5 second";

    }

    // prints the NoSuchCommandException
    public String showErrorUnknownCommand() {
        return "☹ OOPS!!! I'm sorry, but I don't know what that means.";
    }

    // prints the NoDescription Exception
    public String showErrorEmptyDescription() {
        return "☹ OOPS!!! The description of a task cannot be empty.";
    }


    public String showErrorGeneric(String msg) {
        return "☹ OOPS!!! Something went wrong: " + msg;
    }

    public String toPrintKey(ArrayList<Task> TaskList) { //print the list of tasks
        StringBuilder sb = new StringBuilder();
        int len = TaskList.size();
        sb.append("Here are the matching tasks in your list:");
        sb.append("\n");

        if (len == 0) {
            return "You have no task with such key words :(.";
        }
        for (int i = 0; i < len ; i++) {
            Task t = TaskList.get(i);
            String num = Integer.toString(i + 1);
            sb.append(i + 1).append(". ").append(t.getDescription()).append("\n");
        }

        return sb.toString();
    }

    public String handleCommand(String input) {
        try {
            input.trim();
            String[] words = input.split("\\s+");
            if (input.equals("list")) {
                return List.toPrint();
            } else if (words[0].equals("mark")) {
                int n = Integer.parseInt(words[1]);
                return List.mark(n);
            } else if (words[0].equals("unmark")) {
                int n = Integer.parseInt(words[1]);
                return List.unmark(n);
            } else if (words[0].equals("todo")) {
                ToDo t = new ToDo(input);
                List.add(t);
                return t.toPrint();
            } else if (words[0].equals("deadline")) {
                Deadline t = new Deadline(input);
                List.add(t);
                return t.toPrint();
            } else if (words[0].equals("event")) {
                Event t = new Event(input);
                List.add(t);
                return t.toPrint();
            } else if (words[0].equals("delete")) {
                int n = Integer.parseInt(words[1]);
                return List.delete(n);
            } else if (words[0].equals("find")) {
                ArrayList<Task> keywordList = List.findAll(words[1]);
                return this.toPrintKey(keywordList);
            } else if (words[0].equals("bye")) {
                return this.showBye();
            } else {
                throw new NoSuchCommandException();
            }
        } catch (NoSuchCommandException e) { // command not recognised
             return this.showErrorUnknownCommand();
        } catch (NoDescriptionException e) { //catch exceptions where command is given with no description
            return this.showErrorEmptyDescription();
        } catch (Exception e) { //catch other exceptions
            return this.showErrorGeneric(e.getMessage());
        }
    }

}


