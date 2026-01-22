import java.util.Scanner;

public class Lala {
    public static void main(String[] args) throws NoSuchCommandException, NoDescriptionException {
        Scanner sc = new Scanner(System.in);
        Welcome.printWelcome();
        String input = "";
        while (true) {
            input = sc.nextLine();
            if (input.equals("bye")) {
                break;
            }

            try {
                String[] words = input.split(" ");
                if (input.equals("list")) {
                    List.toPrint();
                    continue;
                } else if (words[0].equals("mark")) {
                    int n = Integer.parseInt(words[1]);
                    List.mark(n);
                    continue;
                } else if (words[0].equals("unmark")) {
                    int n = Integer.parseInt(words[1]);
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
