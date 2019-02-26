package org.bt.javashop.controller;
import javafx.stage.Stage;
import org.bt.javashop.view.LoginButtons;
import org.bt.javashop.view.LoginView;

public class LoginController {

    private LoginButtons loginButtons;
    private Stage stage;
    private ScreenController screenController;

    public LoginController(LoginView loginView, ScreenController screenController){
        this.loginButtons = loginView.getButtons();
        this.screenController = screenController;
        this.attachHandlers();
    }

    private void attachHandlers(){
        this.loginButtons.addCustomerHandler(e -> screenController.activate("customerView"));
        this.loginButtons.addAdminHandler(e -> screenController.activate("adminView"));
    }

}
