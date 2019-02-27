package org.bt.javashop.controller;

import javafx.stage.Stage;
import org.bt.javashop.view.create.CreateAccountFields;
import org.bt.javashop.view.create.CreateAccountView;

public class CreateAccountController {

    private CreateAccountFields createAccountFields;
    private Stage stage;
    private ScreenController screenController;

    public CreateAccountController(CreateAccountView createAccountView, ScreenController screenController) {
        this.createAccountFields = createAccountView.getCreateAccountFields();
        this.screenController = screenController;
        this.attachHandlers();
    }

    private void attachHandlers() {
        this.createAccountFields.addCreateHandler(e -> System.out.println("Account Created"));

    }
}
