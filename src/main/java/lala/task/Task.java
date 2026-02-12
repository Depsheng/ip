package lala.task;

public class Task {
    private final String description; //description of Task
    private boolean isDone; //whether the Task is marked as Done
    private String tag;

    public Task(String description) { //Constructor of Task
        this.description = description;
        this.isDone = false;
        this.tag = "";
    }
    public Task(String description, boolean b) { //Constructor of Task
        this.description = description;
        isDone = b;
    }

    public String getDescription() { // To print out description of task and whether it is done
        return this.getBoolean() + this.getTag() + this.description;
    }

    public String getTag() {
        if (this.tag.isEmpty()) {
            return "";
        } else {
            return "(" + this.tag + ") ";
        }
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
        String tag = this.tag.isEmpty() ? " | " + "NO TAG" + " | " : " | " + this.tag + " | ";
        return b + tag + this.description;
    };

    //checks if Description contains the keyword
    public boolean hasKey(String key) {
        return this.description.contains(key);
    }

    //tagging feature to add a tag to task
    public void tagTask(String tag) {
        this.tag = tag;
    }

    public void deleteTag(){
        this.tag = "";
    }
}
