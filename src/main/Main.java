//Listing 9-13
//! Switchin between windows i.e. stages and how to show and hide windows and how Window class events can be used
package main;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import static javafx.stage.WindowEvent.WINDOW_CLOSE_REQUEST;

public class Main extends Application {
    private CheckBox canCloseCbx = new CheckBox("Can Close Window");

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button closeBtn = new Button("Close");
        closeBtn.setOnAction(e -> stage.close());

        Button hideBtn = new Button("Hide");
        hideBtn.setOnAction(e -> {
            showDialog(stage);
            stage.hide();
        });

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(canCloseCbx, closeBtn, hideBtn);

        // Add window event handlers to the stage
        stage.setOnShowing(e -> handle(e));
        stage.setOnShown(e -> handle(e));
        stage.setOnHiding(e -> handle(e));
        stage.setOnHidden(e -> handle(e));
        stage.setOnCloseRequest(e -> handle(e));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Window Events");
        stage.show();
    }

    public void handle(WindowEvent e) {
        // Consume the event if the CheckBox is not selected
        // thus preventing the user from closing the window
        EventType<WindowEvent> type = e.getEventType();
        if (type == WINDOW_CLOSE_REQUEST && !canCloseCbx.isSelected()) {
            e.consume();
        }

        System.out.println(type + ": Consumed=" + e.isConsumed());
    }

    public void showDialog(Stage mainWindow) {
        Stage popup = new Stage();

        Button closeBtn = new Button("Click to Show Main Window");
        closeBtn.setOnAction(e -> {
            popup.close();
            mainWindow.show();
        });

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(closeBtn);

        Scene scene = new Scene(root);
        popup.setScene(scene);
        popup.setTitle("Popup");
        popup.show();
    }
}
// ! Listing 9-11
// * Key events and their handling
// package main;

// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.scene.Scene;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.input.KeyCode;
// import javafx.scene.input.KeyEvent;
// import static javafx.scene.input.KeyEvent.KEY_PRESSED;
// import javafx.scene.layout.HBox;
// import javafx.scene.text.Text;
// import javafx.stage.Stage;

// public class Main extends Application {
// public static void main(String[] args) {
// Application.launch(args);
// }

// @Override
// public void start(Stage stage) {
// Label nameLbl = new Label("Name:");
// TextField nameTfl = new TextField();

// HBox root = new HBox();
// root.setPadding(new Insets(20));
// root.setSpacing(20);
// root.getChildren().addAll(nameLbl, nameTfl);

// // Add key pressed and released events to the TextField
// nameTfl.setOnKeyPressed(e -> handle(e));
// nameTfl.setOnKeyReleased(e -> handle(e));

// Scene scene = new Scene(root);
// stage.setScene(scene);
// stage.setTitle("Key Pressed and Released Events");
// stage.show();
// }

// public void handle(KeyEvent e) {
// String type = e.getEventType().getName();
// KeyCode keyCode = e.getCode();
// System.out.println(type + ": Key Code=" + keyCode.getName() +
// ", Text=" + e.getText());

// // Show the help window when the F1 key is pressed
// if (e.getEventType() == KEY_PRESSED && e.getCode() == KeyCode.F1) {
// displayHelp();
// e.consume();
// }
// }

// public void displayHelp() {
// Text helpText = new Text("Please enter a name.");
// HBox root = new HBox();
// root.setStyle("-fx-background-color: yellow;");
// root.getChildren().add(helpText);

// Scene scene = new Scene(root, 200, 100);
// Stage helpStage = new Stage();
// helpStage.setScene(scene);
// helpStage.setTitle("Help");
// helpStage.show();
// }
// }

// // Main.java
// package main;

// import javafx.application.Application;
// import javafx.event.EventHandler;
// import javafx.scene.Scene;
// import javafx.scene.input.MouseEvent;
// import javafx.scene.layout.HBox;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.Circle;
// import javafx.stage.Stage;
// // Listing 9-6 : Getting Mouse Event Locations pg 254
// // Listing 9-11 Key events

// public class Main extends Application {
// public static void main(String[] args) {
// Application.launch(args);
// }

// private Circle circle;

// @Override
// public void start(Stage stage) {
// circle = new Circle(100, 100, 50);
// circle.setFill(Color.CORAL);

// // Create a MouseEvent filter
// EventHandler<MouseEvent> mouseEventFilter = e -> System.out.println("Mouse
// event filter has been called.");

// // Create a MouseEvent handler
// EventHandler<MouseEvent> mouseEventHandler = e -> System.out.println("Mouse
// event handler has been called.");

// // Register the MouseEvent filter and handler to the Circle
// // for mouse-clicked events
// // circle.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventFilter);
// // circle.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandler);

// // Registering using the onXXX Methods

// circle.setOnMouseClicked(mouseEventHandler);

// HBox root = new HBox();
// root.getChildren().add(circle);
// Scene scene = new Scene(root);
// stage.setScene(scene);
// stage.setTitle("Registering Event Filters and Handlers");
// stage.show();
// stage.sizeToScene();
// }

// public void stop() {
// circle.setOnMouseClicked(null);
// System.out.println("Application is stopping." + circle.toString());
// }
// }