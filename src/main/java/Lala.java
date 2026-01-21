import java.util.Scanner;

public class Lala {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Welcome.printWelcome();
        String input = "";
        while (!input.equals("bye")) {
            input = sc.nextLine();
            echo echomsg =  new echo(input);
            echomsg.toPrint();
        }

        Bye.printBye();

    }
}
