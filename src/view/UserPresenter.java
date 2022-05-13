package view;

import model.User;
import services.DataService;

public class UserPresenter {
    private UserView view;
    private User model;
    private DataService dataService;

    public UserPresenter(User model, UserView view) {
        this.model = model;
        this.view = view;
        this.dataService = new DataService();
        this.view.saveButton.setOnAction(e -> save());
        this.view.editButton.setOnAction(e -> edit());
    }

    private void edit() {
        this.view.nameTextField.setDisable(false);
        this.view.emailTextField.setDisable(false);
        this.view.saveButton.setDisable(false);
    }

    private void save() {
        this.model.setName(this.view.nameTextField.getText());
        this.model.setEmail(this.view.emailTextField.getText());
        this.model.save();
        this.view.nameTextField.setDisable(true);
        this.view.emailTextField.setDisable(true);
        this.view.saveButton.setDisable(true);
    }
}