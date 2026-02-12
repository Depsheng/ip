package lala.task;

import lala.exception.NoDescriptionException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    LocalDate deadline;
    LocalTime deadlineTime;

    public Deadline(String description) throws NoDescriptionException { //calls super constructor
        super(extractDescription(description));
        this.deadline = extractDeadline(description);
        this.deadlineTime = extractDeadlineTime(description);
    }

    public Deadline(String description, String dl, boolean b) throws NoDescriptionException { //calls super constructor
        super(description, b);
        String[] str = dl.split(", ");
        this.deadline = LocalDate.parse(str[0], DateTimeFormatter.ofPattern("MMM d yyyy"));
        this.deadlineTime = LocalTime.parse(str[1], DateTimeFormatter.ofPattern("HH:mm"));
    }

    public static String extractDescription(String input) throws NoDescriptionException { //extract the description from input
        String rest = input.substring("deadline".length());
        assert input.contains("/by") : "There is no /by to put deadline";
        String[] str = rest.split("/by ");
        String description = str[0].trim();

        if (description.isEmpty()) {
            throw new NoDescriptionException("Description for Deadline cannot be empty!");
        }
        return description;
    }

    private static LocalDate extractDeadline(String input) { // extract the deadline from input
        String rest = input.substring("deadline ".length());
        String[] parts = rest.split(" /by ");
        String deadlineString = parts[1].trim().split(" ")[0];//should be in DD-MM-YYYY HR:MN
        assert deadlineString.length() == 16 : "Date and time not properly trimmed!";
        return LocalDate.parse(deadlineString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    private static LocalTime extractDeadlineTime(String input) { // extract the deadline from input
        String rest = input.substring("deadline ".length());
        String[] parts = rest.split(" /by ");
        String deadlineString = parts[1].trim().split(" ")[1];//should be in DD-MM-YYYY HR:MN
        assert deadlineString.length() == 16 : "Date and time not properly trimmed!";
        return LocalTime.parse(deadlineString, DateTimeFormatter.ofPattern("HH:mm"));
    }

    @Override
    public String getDescription() { //get Description of ToDo Task
        String type = "[D]";
        return type + super.getDescription() + " (by: " + this.deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy"))
                + " " + this.deadlineTime.format(DateTimeFormatter.ofPattern("HH:mm")) + ")";
    }

    public String toPrint() { //toPrint function
        return "Got it. I've added this task:" + "\n"
                    + " " + this.getDescription();
    }

    @Override
    public String toFileString() {
        String type = "D | ";
        String by = " | " + this.deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        String byTime = ", " + this.deadlineTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        return type + super.toFileString() + by + byTime;
    }




}
