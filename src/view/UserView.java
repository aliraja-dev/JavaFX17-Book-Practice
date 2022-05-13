package view;

import model.User;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class UserView extends GridPane {
    private final User model;
    // Create labels
    Label nameLabel = new Label("Name:");
    Label emailLabel = new Label("Email:");

    // TextFields
    TextField nameTextField = new TextField();
    TextField emailTextField = new TextField();

    // Create buttons
    Button saveButton = new Button("Save");
    Button editButton = new Button("Edit");

    public UserView(User model) {
        this.model = model;
        layoutForm();

    }

    private void layoutForm() {
        this.setHgap(5);
        this.setVgap(5);
        this.add(nameLabel, 1, 1);
        this.add(nameTextField, 2, 1);
        this.add(emailLabel, 1, 2);
        this.add(emailTextField, 2, 2);
        this.add(saveButton, 1, 3);
        this.add(editButton, 2, 3);
    }

}