package lala;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lala.exception.NoDescriptionException;
import lala.exception.NoSuchCommandException;
import java.io.IOException;

/**
 * A GUI for Duke using FXML.
 */

public class Main extends Application {

    private Lala lala;

    @Override
    public void start(Stage stage) throws NoSuchCommandException, NoDescriptionException, IOException {
        try {
            lala = new Lala();

            // Assert that lala is not null
            assert lala != null : "Lala is null!"; // Assertion to check lala is initialized

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = loader.load();

            MainWindow controller = loader.getController();
            controller.setLala(lala);   // inject BEFORE showing

            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
