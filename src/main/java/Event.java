public class Event extends Task{

    String from;
    String deadline;

    public Event(String description) throws NoDescriptionException { //calls super constructor
        super(extractDes(description));
        this.from = extractFrom(description);
        this.deadline = extractDeadline(description);
    }

    public Event(String description, String from, String dl, boolean b) throws NoDescriptionException { //calls super constructor
        super(description, b);
        this.from = "(from: " + from;
        this.deadline = " to: " + dl + ")";
    }

    public static String extractDes(String input) throws NoDescriptionException { //extract the description from input
        String rest = input.substring("event".length());
        String[] str = rest.split("/from ");
        String desc = str[0].trim();

        if (desc.isEmpty()) {
            throw new NoDescriptionException();
        }
        return desc;
    }

    private static String extractFrom(String input) { // extract the deadline from input
        String rest = input.substring("event ".length());
        String[] str = rest.split(" /from ");
        String[] parts = str[1].split(" /to ");
        return "(from: " + parts[0].trim();
    }

    private static String extractDeadline(String input) { // extract the deadline from input
        String rest = input.substring("event ".length());
        String[] str = rest.split(" /from ");
        String[] parts = str[1].split(" /to ");
        return " to: " + parts[1].trim() + ")";
    }


    @Override
    public String getDescription() { //get Description of ToDo Task
        String type = "[E]";
        return type + super.getDescription() + " " + this.from + this.deadline;
    }

    public void toPrint() { // print the action of adding the task
        System.out.println("____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + this.getDescription());
        System.out.println("____________________________________________________________");
    }

    @Override
    public String toFileString() {
        String type = "T | ";
        String from = " | " + this.from;
        String by = " | " + this.deadline;
        return type + super.toFileString() + from + by;
    }



}
