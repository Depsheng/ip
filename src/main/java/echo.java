public class echo {

    String echo_msg;

    public echo(String msg) {
        this.echo_msg = msg;
        List.add(msg);
    }

    public void toPrint() {
        System.out.println("____________________________________________________________");
        System.out.println("added: " + this.echo_msg);
        System.out.println("____________________________________________________________");
    }
}
