package lala;

import lala.exception.NoDescriptionException;
import lala.exception.NoSuchCommandException;
import java.io.IOException;

public class Lala {
    private Storage storage;
    private Ui ui;

    public Lala() throws NoSuchCommandException, NoDescriptionException, IOException {
        this.storage = new Storage();
        ui = new Ui();

    }


    public String run() throws NoSuchCommandException, NoDescriptionException, IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(ui.showWelcome()).append("\n");
        try {
            List.loadFromTxt();
            sb.append(List.getNum());
        } catch (Exception e) {
            sb.append("Failed to load tasks: ").append(e.getMessage());
        }
        return sb.toString();
    }


    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) throws NoSuchCommandException, NoDescriptionException, IOException {
        return ui.handleCommand(input);
    }

}
