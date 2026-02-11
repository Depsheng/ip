package lala.task;

import lala.exception.NoDescriptionException;

public class ToDo extends Task {


    public ToDo(String description) throws NoDescriptionException { //calls super constructor
        super(extractDescription(description));
    }

    public ToDo(String description, boolean isDone) throws NoDescriptionException { //calls super constructor
        super(description, isDone);
    }

    private static String extractDescription(String input) throws NoDescriptionException {
        String description = input.substring("todo".length()).trim();

        if (description.isEmpty()) {
            throw new NoDescriptionException("Description for ToDo cannot be empty!");
        }
        return description;
    }

    @Override
    public String getDescription() { //get Description of ToDo Task
        String type = "[T]";
        return type + super.getDescription();
    }

    public String toPrint() { //toPrint function
        return "Got it. I've added this task:" + "\n"
                    + " " + this.getDescription();

    }

    @Override
    public String toFileString() {
        String type = "T | ";
        return type + super.toFileString();
    }


}
