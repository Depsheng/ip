public class ToDo extends Task{
    public ToDo(String description) { //calls super constructor
        super(description.substring("todo ".length()));
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
