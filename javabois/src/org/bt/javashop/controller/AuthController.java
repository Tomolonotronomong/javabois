package org.bt.javashop.controller;


import javafx.stage.Stage;
import org.bt.javashop.view.Authentication.AuthFields;
import org.bt.javashop.view.Authentication.AuthView;

public class AuthController {

    private AuthFields authFields;
    private Stage stage;
    private ScreenController screenController;

    public AuthController(AuthView authView, ScreenController screenController){
        this.authFields = authView.getAuthFields();
        this.screenController = screenController;
        this.attachHandlers();
    }

    private void attachHandlers(){
        this.authFields.addAuthHandler(e -> screenController.activate("customerView"));
    }
}
