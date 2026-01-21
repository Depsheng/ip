public class echo {

    String echo_msg;

    public echo(String msg) {
        this.echo_msg = msg;
    }

    public void toPrint() {
        System.out.println("____________________________________________________________");
        System.out.println(this.echo_msg);
        System.out.println("____________________________________________________________");
    }
}
