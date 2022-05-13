
// Main file
package main;

import view.UserView;
import view.UserPresenter;
import model.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        User model = new User();
        UserView view = new UserView(model);
        Scene scene = new Scene(view);
        UserPresenter presenter = new UserPresenter(model, view);
        view.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        primaryStage.setScene(scene);
        primaryStage.setTitle("User MVP Pattern");
        primaryStage.show();
    }
}