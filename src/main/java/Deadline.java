public class Deadline extends Task{

    String deadline;

    public Deadline(String description) { //calls super constructor
        super(extractDes(description));
        this.deadline = extractDeadline(description);
    }

    public static String extractDes(String input) { //extract the description from input
        String rest = input.substring("deadline ".length());
        String[] str = rest.split("/by ");
        return str[0];
    }

    private static String extractDeadline(String input) { // extract the deadline from input
        String rest = input.substring("deadline ".length());
        String[] parts = rest.split(" /by ");
        return "(by: " + parts[1].trim() + ")";
    }

    @Override
    public String getDescription() { //get Description of ToDo Task
        String type = "[D]";
        return type + super.getDescription() + this.deadline;
    }

    public void toPrint() { //toPrint function
        System.out.println("____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        List.add(this);
        System.out.println("  " + this.getDescription());
        System.out.println(List.getNum());
        System.out.println("____________________________________________________________");
    }




}
