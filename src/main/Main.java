package main;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Example 2-21
        Circle circle = new Circle();
        Group root = new Group(circle);
        Scene scene = new Scene(root, 300, 300);

        // bind the Circle properties to window sizes
        circle.centerXProperty().bind(scene.widthProperty().divide(2));
        circle.centerYProperty().bind(scene.heightProperty().divide(2));
        circle.radiusProperty().bind(Bindings.min(scene.widthProperty(), scene.heightProperty()).divide(2));

        // set scene to stage and show scene
        primaryStage.setTitle("Property Binding JavaFx");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
