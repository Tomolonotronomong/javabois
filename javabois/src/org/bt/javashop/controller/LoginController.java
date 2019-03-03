package org.bt.javashop.controller;
import javafx.stage.Stage;
import org.bt.javashop.view.login.LoginButtons;
import org.bt.javashop.view.login.Landing;

public class LoginController {

    private LoginButtons loginButtons;
    private Stage stage;
    private ScreenController screenController;

    public LoginController(Landing landing, ScreenController screenController){
        this.loginButtons = landing.getButtons();
        this.screenController = screenController;
        this.attachHandlers();
    }

    private void attachHandlers(){
        this.loginButtons.addCustomerHandler(e -> screenController.activate("authView"));
        this.loginButtons.addAdminHandler(e -> screenController.activate("adminAuthView"));
        this.loginButtons.addCreateHandler(e -> screenController.activate("createAccountView"));
    }

}
