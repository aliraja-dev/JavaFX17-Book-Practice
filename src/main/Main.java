package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        // root.getChildren().addAll(new Button("Button 1"), new Button("Button 2"), new
        // Text("Hello from JavaFX17"));
        Button exitBtn = new Button("Exit");
        exitBtn.setOnAction(event -> System.exit(0));
        root.getChildren().add(exitBtn);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("JavaFX17 Book Chap01");
        primaryStage.show();

    }
}
