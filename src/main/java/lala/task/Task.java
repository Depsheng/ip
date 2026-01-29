package lala.task;

public class Task {
    private final String description; //description of Task
    private boolean isDone; //whether the Task is marked as Done

    public Task(String description) { //Constructor of Task
        this.description = description;
        isDone = false;
    }
    public Task(String description, boolean b) { //Constructor of Task
        this.description = description;
        isDone = b;
    }

    public String getDescription() { // To print out description of task and whether it is done
        return this.getBoolean() + this.description;
    }

    public String getBoolean() { //Responsible for printing the [ ] whether done or not
        if (this.isDone) {
            return "[X] ";
        } else {
            return "[ ] ";
        }
    }

    public void set(boolean b) { // mark/unmark
        this.isDone = b;
    }

    public String toFileString() {
        String b = this.isDone ? "1" : "0";
        return b + " | " + this.description;
    };

}
