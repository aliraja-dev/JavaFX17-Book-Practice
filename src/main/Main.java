package main;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<Screen> screenList = Screen.getScreens();
        System.out.println("screens: " + screenList.size());

        // Print to console details of screens attached to the system
        for (Screen screen : screenList) {
            print(screen);
        }
        System.exit(0);
    }

    public void print(Screen s) {
        System.out.println("DPI: " + s.getDpi());
        Rectangle2D bounds = s.getBounds();
        print(bounds);
        System.out.println("Screen Visual Bounds:");
        Rectangle2D visualBounds = s.getVisualBounds();
        print(visualBounds);
        System.out.println("-----------------------------------------------------");
    }

    public void print(Rectangle2D r) {
        System.out.println("minX: " + r.getMinX() + " minY: " + r.getMinY() + " Width: " + r.getWidth() + " Height: "
                + r.getHeight());
    }
}
