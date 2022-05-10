package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Example 1-5
        VBox root = new VBox();
        root.setSpacing(10);
        Label nameLabel = new Label("Name");
        TextField nameField = new TextField();
        Label msgLabel = new Label();
        msgLabel.setStyle("-fx-font-size: 20");
        Button submitBtn = new Button("Submit");
        Button exitBtn = new Button("Exit");

        // ! When we click submitBtn we want to take the text in the nameField and
        // display it in the msgLabel, but check for empty strings.
        submitBtn.setOnAction(e -> {
            String name = nameField.getText();
            if (name.isEmpty()) {
                msgLabel.setText("Please enter a name.");
            } else {
                msgLabel.setText("Hello " + name + "!");
            }
        });
        exitBtn.setOnAction(e -> {
            System.exit(0);
        });
        root.getChildren().addAll(nameLabel, nameField, submitBtn, msgLabel, exitBtn);
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }
}
