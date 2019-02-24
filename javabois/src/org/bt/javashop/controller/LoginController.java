package org.bt.javashop.controller;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bt.javashop.view.AdminStockView;
import org.bt.javashop.view.CustomerView;
import org.bt.javashop.view.LoginButtons;
import org.bt.javashop.view.LoginView;

public class LoginController {

    private LoginButtons loginButtons;
    private Stage stage;
    private AdminStockView adminStockView;
    private CustomerView customerView;

    public LoginController(LoginView loginView, Stage stage, AdminStockView adminStockView, CustomerView customerView){
        this.loginButtons = loginView.getButtons();
        this.stage = stage;
        this.adminStockView = adminStockView;
        this.customerView = customerView;
    }

    private void attachHandlers(){
        this.loginButtons.addCustomerHandler(e -> stage.setScene(new Scene(customerView)));
        this.loginButtons.addAdminHandler(e -> stage.setScene(new Scene(adminStockView)));
    }
}
