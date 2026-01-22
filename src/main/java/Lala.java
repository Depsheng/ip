import java.util.Scanner;

public class Lala {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Welcome.printWelcome();
        String input = "";
        while (true) {
            input = sc.nextLine();
            if(input.equals("bye")) {
                break;
            }
            String[] words = input.split(" ");
            if (input.equals("list")) {
                List.toPrint();
                continue;
            } else if (words[0].equals("mark")) {
                int n =  Integer.parseInt(words[1]);
                List.mark(n);
                continue;
            } else if (words[0].equals("unmark")){
                int  n = Integer.parseInt(words[1]);
                List.unmark(n);
                continue;
            } else if (words[0].equals("todo")) {
                ToDo todo = new ToDo(input);
                todo.toPrint();
                continue;
            } else if (words[0].equals("deadline")) {
                Deadline dl = new Deadline(input);
                dl.toPrint();
                continue;
            } else if (words[0].equals("event")) {
                Event e = new Event(input);
                e.toPrint();
                continue;
            }
            echo echomsg =  new echo(input);
            echomsg.toPrint();
        }

        Bye.printBye();

    }

    public static void wordCheck(String input) {}
}
