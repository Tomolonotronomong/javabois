package org.bt.javashop.controller;

import javafx.stage.Stage;
import org.bt.javashop.view.CreateAccountFields;
import org.bt.javashop.view.CreateAccountView;
import org.bt.javashop.view.LoginView;

public class CreateAccountController {

    private CreateAccountFields createAccountFields;
    private Stage stage;
    private ScreenController screenController;

    public CreateAccountController(CreateAccountView createAccountView, ScreenController screenController) {
        this.createAccountFields = createAccountView.getCreateAccountFields();
        this.screenController = screenController;
        //this.attachHandlers();
    }
    //private void attachHandlers(){
      //  this.createAccountFields.addCustomerHandler(e -> screenController.activate("customerView"));

}
