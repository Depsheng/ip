package lala.task;

import lala.exception.NoDescriptionException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    LocalDate from;
    LocalTime fromTime;
    LocalDate to;
    LocalTime toTime;

    public Event(String description) throws NoDescriptionException { //calls super constructor
        super(extractDescription(description));
        String[] str = description.split("/from ");
        String fromString = str[1].split("/to ")[0].trim();
        String toString = str[1].split("/to ")[1].trim();

        this.from = extractDeadline(fromString);
        this.fromTime = extractDeadlineTime(fromString);
        this.to = extractDeadline(toString);
        this.toTime = extractDeadlineTime(toString);
    }

    public Event(String description, String from, String dl, boolean b) throws NoDescriptionException { //calls super constructor
        super(description, b);

        String[] fromParts = from.split(", ");
        this.from = LocalDate.parse(fromParts[0], DateTimeFormatter.ofPattern("MMM d yyyy"));
        this.fromTime = LocalTime.parse(fromParts[1], DateTimeFormatter.ofPattern("HH:mm"));

        String[] toParts = dl.split(", ");
        this.to = LocalDate.parse(toParts[0], DateTimeFormatter.ofPattern("MMM d yyyy"));
        this.toTime = LocalTime.parse(toParts[1], DateTimeFormatter.ofPattern("HH:mm"));
    }

    public static String extractDescription(String input) throws NoDescriptionException { //extract the description from input
        String rest = input.substring("event".length());
        String[] str = rest.split("/from ");
        String desc = str[0].trim();

        if (desc.isEmpty()) {
            throw new NoDescriptionException("Description for Event cannot be empty!");
        }
        return desc;
    }

    private static LocalDate extractDeadline(String input) { // extract the deadline from input
//        String rest = input.substring("event ".length());
//        String[] str = rest.split(" /from ");
//        String[] parts = str[1].split(" /to ");
//        return " to: " + parts[1].trim() + ")";
        String[] parts = input.split(" ");
        String deadlineString = parts[0];//should be in DD-MM-YYYY
        assert deadlineString.length() == 10 : "Date not properly trimmed!";
        return LocalDate.parse(deadlineString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    private static LocalTime extractDeadlineTime(String input) { // extract the deadline from input
        String[] parts = input.split(" ");
        String deadlineString = parts[1].trim();//should be in HR:MN
        assert deadlineString.length() == 5 : "Time not properly trimmed!";
        return LocalTime.parse(deadlineString, DateTimeFormatter.ofPattern("HH:mm"));
    }


    @Override
    public String getDescription() { //get Description of Event Task
        String type = "[E]";
        return type + super.getDescription() + " (from: " + this.from.format(DateTimeFormatter.ofPattern("MMM d yyyy"))
                + " " + this.fromTime.format(DateTimeFormatter.ofPattern("HH:mm")) +
                    " to: " + this.to.format(DateTimeFormatter.ofPattern("MMM d yyyy"))
                            + " " + this.toTime.format(DateTimeFormatter.ofPattern("HH:mm"))+ ")";
        }

    public String toPrint() { // print the action of adding the task
        return "Got it. I've added this task:" + "\n"
                + " " + this.getDescription();
    }

    @Override
    public String toFileString() {
        String type = "E | ";
        String by = " | " + this.from.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        String byTime = ", " + this.fromTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        String to = " | " + this.to.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        String toTime = ", " + this.toTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        return type + super.toFileString() + by + byTime + to + toTime;
    }
}
