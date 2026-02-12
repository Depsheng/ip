package lala.task;

import lala.exception.NoDescriptionException;

public class ToDo extends Task {


    public ToDo(String description) throws NoDescriptionException { //calls super constructor
        super(extractDesc(description));
    }

    public ToDo(String description, boolean b, String tag) throws NoDescriptionException { //calls super constructor
        super(description, b);
        this.tagTask(tag);
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
