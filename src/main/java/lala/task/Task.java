package lala.task;

public class Task {
    private final String description;
    private boolean isDone;
    private String tag;

    /**
     * Creates a new task with the given description and an empty tag.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.tag = "";
    }

    /**
     * Creates a new task with the given description and completion state.
     */
    public Task(String description, boolean b) {
        this.description = description;
        this.isDone = b;
    }

    /**
     * Returns a display string including completion status, tag, and description.
     */
    public String getDescription() {
        return this.getBoolean() + this.getTag() + this.description;
    }

    /**
     * Returns a formatted tag prefix for display, or an empty string if no tag exists.
     */
    public String getTag() {
        if (this.tag.isEmpty()) {
            return "";
        } else {
            return "(" + this.tag + ") ";
        }
    }

    /**
     * Returns the completion marker for display.
     */
    public String getBoolean() {
        if (this.isDone) {
            return "[X] ";
        } else {
            return "[ ] ";
        }
    }

    /**
     * Marks or unmarks the task as done.
     */
    public void set(boolean b) {
        this.isDone = b;
    }

    /**
     * Serializes the task to a file-friendly string format.
     */
    public String toFileString() {
        String b = this.isDone ? "1" : "0";
        String tag = this.tag.isEmpty() ? " | " + "NO TAG" + " | " : " | " + this.tag + " | ";
        return b + tag + this.description;
    }

    /**
     * Returns true if the description contains the given keyword.
     */
    public boolean hasKey(String key) {
        return this.description.contains(key);
    }

    /**
     * Assigns a tag to the task.
     */
    public void tagTask(String tag) {
        this.tag = tag;
    }

    /**
     * Clears the task tag.
     */
    public void deleteTag() {
        this.tag = "";
    }
}
