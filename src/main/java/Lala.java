import java.io.IOException;
import java.util.Scanner;

public class Lala {
    public static void main(String[] args) throws NoSuchCommandException, NoDescriptionException, IOException {
        Scanner sc = new Scanner(System.in);
        Welcome.printWelcome();
        String input;
        try {
            List.loadFromTxt();
            System.out.println(List.getNum());
        } catch (Exception e) {
            System.out.println("Failed to load tasks: " + e.getMessage());
            e.printStackTrace();
        }
        while (true) {
            input = sc.nextLine();
            if (input.equals("bye")) {
                break;
            }

            try {
                String[] words = input.split(" ");
                if (input.equals("list")) {
                    List.toPrint();
                } else if (words[0].equals("mark")) {
                    int n = Integer.parseInt(words[1]);
                    List.mark(n);
                } else if (words[0].equals("unmark")) {
                    int n = Integer.parseInt(words[1]);
                    List.unmark(n);
                } else if (words[0].equals("todo")) {
                    ToDo t= new ToDo(input);
                    List.add(t);
                    t.toPrint();
                } else if (words[0].equals("deadline")) {
                    Deadline t = new Deadline(input);
                    List.add(t);
                    t.toPrint();
                } else if (words[0].equals("event")) {
                    Event t = new Event(input);
                    List.add(t);
                    t.toPrint();
                } else if (words[0].equals("delete")) {
                    int n = Integer.parseInt(words[1]);
                    List.delete(n);
                } else {
                    throw new NoSuchCommandException();
                }
            } catch (NoSuchCommandException e) { // command not recognised
                System.out.println("____________________________________________________________");
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means.");
                System.out.println("____________________________________________________________");
            } catch (NoDescriptionException e) { //catch exceptions where command is given with no description
                System.out.println("____________________________________________________________");
                System.out.println("☹ OOPS!!! The description of a task cannot be empty.");
                System.out.println("____________________________________________________________");
            } catch (Exception e) { //catch other exceptions
                System.out.println("____________________________________________________________");
                System.out.println("☹ OOPS!!! Something went wrong: " + e.getMessage());
                System.out.println("____________________________________________________________");
            }

        }
        Bye.printBye();
    }
}
