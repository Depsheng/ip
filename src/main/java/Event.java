public class Event extends Task{

    String from;
    String deadline;

    public Event(String description) { //calls super constructor
        super(extractDes(description));
        this.from = extractFrom(description);
        this.deadline = extractDeadline(description);
    }

    public static String extractDes(String input) { //extract the description from input
        String rest = input.substring("event ".length());
        String[] str = rest.split("/from ");
        return str[0];
    }

    private static String extractFrom(String input) { // extract the deadline from input
        String rest = input.substring("deadline ".length());
        String[] str = rest.split(" /from ");
        String[] parts = str[1].split(" /to ");
        return "(from: " + parts[0].trim();
    }

    private static String extractDeadline(String input) { // extract the deadline from input
        String rest = input.substring("deadline ".length());
        String[] str = rest.split(" /from ");
        String[] parts = str[1].split(" /to ");
        return " to: " + parts[1].trim() + ")";
    }


    @Override
    public String getDescription() { //get Description of ToDo Task
        String type = "[E]";
        return type + super.getDescription() + this.from + this.deadline;
    }

    public void toPrint() {
        System.out.println("____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        List.add(this);
        System.out.println("  " + this.getDescription());
        System.out.println(List.getNum());
        System.out.println("____________________________________________________________");
    }




}
