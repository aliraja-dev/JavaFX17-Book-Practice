package main;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import javafx.stage.Modality;
import static javafx.stage.Modality.NONE;
import static javafx.stage.Modality.WINDOW_MODAL;
import static javafx.stage.Modality.APPLICATION_MODAL;

//! Listing 4-7
//* To Show Popups / Dialogs using new Stage class and Modality Enums. 

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub
        /* Buttons to display each kind of modal stage */
        Button ownedNoneButton = new Button("Owned None");
        ownedNoneButton.setOnAction(e -> showDialog(stage, NONE));

        Button nonOwnedNoneButton = new Button("Non-owned None");
        nonOwnedNoneButton.setOnAction(e -> showDialog(null, NONE));

        Button ownedWinButton = new Button("Owned Window Modal");
        ownedWinButton.setOnAction(e -> showDialog(stage, WINDOW_MODAL));

        Button nonOwnedWinButton = new Button("Non-owned Window Modal");
        nonOwnedWinButton.setOnAction(e -> showDialog(null, WINDOW_MODAL));

        Button ownedAppButton = new Button("Owned Application Modal");
        ownedAppButton.setOnAction(e -> showDialog(stage, APPLICATION_MODAL));

        Button nonOwnedAppButton = new Button("Non-owned Application Modal");
        nonOwnedAppButton.setOnAction(e -> showDialog(null, APPLICATION_MODAL));

        VBox root = new VBox();
        root.getChildren().addAll(ownedNoneButton, nonOwnedNoneButton,
                ownedWinButton, nonOwnedWinButton,
                ownedAppButton, nonOwnedAppButton);
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("The Primary Stage");
        stage.show();
    }

    private void showDialog(Window owner, Modality modality) {
        // Create a Stage with specified owner and modality
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label modalityLabel = new Label(modality.toString());
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> stage.close());

        VBox root = new VBox();
        root.getChildren().addAll(modalityLabel, closeButton);
        Scene scene = new Scene(root, 200, 100);
        stage.setScene(scene);
        stage.setTitle("A Dialog Box");
        stage.show();
    }
}
// //! Listing 4-4
// public class Main extends Application {
// public static void main(String[] args) {
// Application.launch(args);
// }

// public void start(Stage primaryStage) {
// primaryStage.setScene(new Scene(new Group(new Button("Hello World!")), 400,
// 300));
// primaryStage.setTitle("Empty Stage");
// primaryStage.show();
// primaryStage.centerOnScreen();
// }
// }
// ! Listing 4-1
// public class Main extends Application {
// public static void main(String[] args) {
// Application.launch(args);
// }

// @Override
// public void start(Stage primaryStage) throws Exception {
// ObservableList<Screen> screenList = Screen.getScreens();
// System.out.println("screens: " + screenList.size());

// // Print to console details of screens attached to the system
// for (Screen screen : screenList) {
// print(screen);
// }
// System.exit(0);
// }

// public void print(Screen s) {
// System.out.println("DPI: " + s.getDpi());
// Rectangle2D bounds = s.getBounds();
// print(bounds);
// System.out.println("Screen Visual Bounds:");
// Rectangle2D visualBounds = s.getVisualBounds();
// print(visualBounds);
// System.out.println("-----------------------------------------------------");
// }

// public void print(Rectangle2D r) {
// System.out.println("minX: " + r.getMinX() + " minY: " + r.getMinY() + "
// Width: " + r.getWidth() + " Height: "
// + r.getHeight());
// }
// }
