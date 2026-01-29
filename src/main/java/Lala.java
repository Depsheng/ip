import java.io.IOException;
import java.util.Scanner;

public class Lala {
    private Storage storage;
    private List list;
    private Ui ui;

    public Lala() throws IOException {
        this.storage = storage;
        list = new List();
        ui = new Ui();

        try {
            list.loadFromTxt();
            System.out.println(List.getNum());
        } catch (Exception e) {
            System.out.println("Failed to load tasks: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void run() throws NoSuchCommandException, NoDescriptionException, IOException {
        Scanner sc = new Scanner(System.in);
        ui.showWelcome();
        String input;
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
                    ToDo t = new ToDo(input);
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
                ui.showErrorUnknownCommand();
            } catch (NoDescriptionException e) { //catch exceptions where command is given with no description
                ui.showErrorEmptyDescription();
            } catch (Exception e) { //catch other exceptions
                ui.showErrorGeneric(e.getMessage());
            }

        }
        ui.showBye();
    }

    public static void main(String[] args) throws NoSuchCommandException, NoDescriptionException, IOException {
        new Lala().run();
    }
}
