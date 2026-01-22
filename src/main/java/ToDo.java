public class ToDo extends Task{
    public ToDo(String description) throws NoDescriptionException { //calls super constructor
        super(extractDesc(description));
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

    public void toPrint() { //to Print when the input for todo is entered
        System.out.println("____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        List.add(this);
        System.out.println("  " + this.getDescription());
        System.out.println(List.getNum());
        System.out.println("____________________________________________________________");
    }




}
