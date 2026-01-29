package lala.task;

import lala.exception.NoDescriptionException;

public class ToDo extends Task {
    public ToDo(String description) throws NoDescriptionException { //calls super constructor
        super(extractDesc(description));
    }

    public ToDo(String description, boolean b) throws NoDescriptionException { //calls super constructor
        super(description, b);
    }

    private static String extractDesc(String input) throws NoDescriptionException {
        String desc = input.substring("todo".length()).trim();

        if (desc.isEmpty()) {
            throw new NoDescriptionException();
        }
        return desc;
    }

    @Override
    public String getDescription() { //get Description of ToDo Task
        String type = "[T]";
        return type + super.getDescription();
    }

    public void toPrint() { //to Print when the input for todo is entered
        System.out.println("____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + this.getDescription());
        System.out.println("____________________________________________________________");
    }

    @Override
    public String toFileString() {
        String type = "T | ";
        return type + super.toFileString();
    }


}
