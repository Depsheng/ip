public class Deadline extends Task{

    String deadline;

    public Deadline(String description) throws NoDescriptionException { //calls super constructor
        super(extractDes(description));
        this.deadline = extractDeadline(description);
    }

    public Deadline(String description, String dl, boolean b) throws NoDescriptionException { //calls super constructor
        super(description, b);
        this.deadline = "(by: " + dl + ")";
    }

    public static String extractDes(String input) throws NoDescriptionException { //extract the description from input
        String rest = input.substring("deadline".length());
        String[] str = rest.split("/by ");
        String desc = str[0].trim();

        if (desc.isEmpty()) {
            throw new NoDescriptionException();
        }
        return desc;
    }

    private static String extractDeadline(String input) { // extract the deadline from input
        String rest = input.substring("deadline ".length());
        String[] parts = rest.split(" /by ");
        return "(by: " + parts[1].trim() + ")";
    }

    @Override
    public String getDescription() { //get Description of ToDo Task
        String type = "[D]";
        return type + super.getDescription() + " " + this.deadline;
    }

    public void toPrint() { //toPrint function
        System.out.println("____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + this.getDescription());
        System.out.println("____________________________________________________________");
    }

    @Override
    public String toFileString() {
        String type = "T | ";
        String by = " | " + this.deadline;
        return type + super.toFileString() + by;
    }




}
