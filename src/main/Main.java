
// CoordinateConversion.java
package main;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    // An instance variable to store the reference of the circle

    private Circle marker;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        TextField fName = new TextField();
        TextField lName = new TextField();
        TextField salary = new TextField();

        // The Circle node is unmanaged
        marker = new Circle(5);
        marker.setManaged(false);
        marker.setFill(Color.RED);
        marker.setMouseTransparent(true);

        HBox hb1 = new HBox();
        HBox hb2 = new HBox();
        HBox hb3 = new HBox();
        hb1.getChildren().addAll(new Label("First Name:"), fName);
        hb2.getChildren().addAll(new Label("Last Name:"), lName);
        hb3.getChildren().addAll(new Label("Salary:"), salary);

        VBox root = new VBox();
        root.getChildren().addAll(hb1, hb2, hb3, marker);

        Scene scene = new Scene(root);

        // Add a focus change listener to the scene
        scene.focusOwnerProperty().addListener(
                (prop, oldNode, newNode) -> placeMarker(newNode));

        stage.setScene(scene);
        stage.setTitle("Coordinate Space Transformation");
        stage.show();
    }

    public void placeMarker(Node newNode) {
        double nodeMinX = newNode.getLayoutBounds().getMinX();
        double nodeMinY = newNode.getLayoutBounds().getMinY();
        Point2D nodeInScene = newNode.localToScene(nodeMinX, nodeMinY);
        Point2D nodeInMarkerLocal = marker.sceneToLocal(nodeInScene);
        Point2D nodeInMarkerParent = marker.localToParent(nodeInMarkerLocal);

        // Position the circle approperiately
        marker.relocate(nodeInMarkerParent.getX()
                + marker.getLayoutBounds().getMinX(),
                nodeInMarkerParent.getY()
                        + marker.getLayoutBounds().getMinY());
    }
}
// // MicroHelpApp.java
// package main;

// import javafx.application.Application;
// import javafx.application.Platform;
// import javafx.beans.value.ObservableValue;
// import javafx.geometry.VPos;
// import javafx.scene.Node;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.GridPane;
// import javafx.scene.paint.Color;
// import javafx.scene.text.Font;
// import javafx.scene.text.Text;
// import javafx.stage.Stage;

// public class Main extends Application {
// // An instance variable to store the Text node reference
// private Text helpText = new Text();

// public static void main(String[] args) {
// Application.launch(args);
// }

// @Override
// public void start(Stage stage) {
// TextField fName = new TextField();
// TextField lName = new TextField();
// TextField salary = new TextField();

// Button closeBtn = new Button("Close");
// closeBtn.setOnAction(e -> Platform.exit());

// fName.getProperties().put("microHelpText", "Enter the first name");
// lName.getProperties().put("microHelpText", "Enter the last name");
// salary.getProperties().put("microHelpText",
// "Enter a salary greater than $2000.00.");

// // The help text node is unmanaged
// helpText.setManaged(false);
// helpText.setTextOrigin(VPos.TOP);
// helpText.setFill(Color.RED);
// helpText.setFont(Font.font(null, 9));
// helpText.setMouseTransparent(true);

// // Add all nodes to a GridPane
// GridPane root = new GridPane();

// root.add(new Label("First Name:"), 1, 1);
// root.add(fName, 2, 1);
// root.add(new Label("Last Name:"), 1, 2);
// root.add(lName, 2, 2);

// root.add(new Label("Salary:"), 1, 3);
// root.add(salary, 2, 3);
// root.add(closeBtn, 3, 3);
// root.add(helpText, 4, 3);

// Scene scene = new Scene(root, 300, 100);

// // Add a change listener to the scene, so we know when
// // the focus owner changes and display the micro help
// scene.focusOwnerProperty().addListener(
// (ObservableValue<? extends Node> value, Node oldNode, Node newNode) ->
// focusChanged(value, oldNode,
// newNode));
// stage.setScene(scene);
// stage.setTitle("Showing Micro Help");
// stage.show();
// }

// public void focusChanged(ObservableValue<? extends Node> value,
// Node oldNode, Node newNode) {
// // Focus has changed to a new node
// String microHelpText = (String) newNode.getProperties().get("microHelpText");

// if (microHelpText != null && microHelpText.trim().length() > 0) {
// helpText.setText(microHelpText);
// helpText.setVisible(true);

// // Position the help text node
// double x = newNode.getLayoutX() +
// newNode.getLayoutBounds().getMinX() -
// helpText.getLayoutBounds().getMinX();
// double y = newNode.getLayoutY() +
// newNode.getLayoutBounds().getMinY() +
// newNode.getLayoutBounds().getHeight() -
// helpText.getLayoutBounds().getMinX();

// helpText.setLayoutX(x);
// helpText.setLayoutY(y);
// helpText.setWrappingWidth(newNode.getLayoutBounds().getWidth());
// } else {
// helpText.setVisible(false);
// }
// }
// }