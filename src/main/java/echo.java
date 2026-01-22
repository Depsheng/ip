public class echo {

    String echo_msg;

    public echo(String msg) { //constructor of echo and add the description into List
        this.echo_msg = msg;
        List.add(new Task(msg));
    }

    public void toPrint() { //Print for task adding
        System.out.println("____________________________________________________________");
        System.out.println("added: " + this.echo_msg);
        System.out.println("____________________________________________________________");
    }
}
