package org.bt.javashop.controller;

import javafx.stage.Stage;
import org.bt.javashop.view.Authentication.AdminAuthFields;
import org.bt.javashop.view.Authentication.AdminAuthView;

public class AdminAuthController {

    private AdminAuthFields adminAuthFields;
    private Stage stage;
    private ScreenController screenController;

    public AdminAuthController(AdminAuthView adminAuthView, ScreenController screenController){
        this.adminAuthFields = adminAuthView.getAdminAuthFields();
        this.screenController = screenController;
        this.attachHandlers();
        
        
    }

    private void attachHandlers() { this.adminAuthFields.addAuthHandler(e -> screenController.activate("adminView") );}
}
