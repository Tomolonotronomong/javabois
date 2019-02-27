
package org.bt.javashop.main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bt.javashop.controller.*;
import org.bt.javashop.model.Order;
import org.bt.javashop.model.Stock;
import org.bt.javashop.view.admin.AdminStockView;
import org.bt.javashop.view.create.CreateAccountView;
import org.bt.javashop.view.customer.CustomerView;
import org.bt.javashop.view.login.LoginView;

public class ApplicationLoader extends Application {

	private AdminStockView adminView;
	private CustomerView customerView;
	private LoginView loginView;
	private ScreenController screenController;
	private CreateAccountView createAccountView;

	@Override
	public void start(Stage stage) throws Exception {
		//create the models
		Stock model = new Stock();
		Order order = new Order();

		//create the views
		customerView = new CustomerView();
		adminView = new AdminStockView();
		loginView = new LoginView();
		createAccountView = new CreateAccountView();


		//add the root node
		Group root = new Group(loginView);
		Scene main = new Scene(root);
		stage.setScene(main); //TODO fix login
		screenController = new ScreenController(main);
		//add the available views to the controller
		screenController.addScreen("customerView", customerView);
		screenController.addScreen("adminView", adminView);
		screenController.addScreen("loginView", loginView);
		screenController.addScreen("createAccountView", createAccountView );

		stage.setTitle("B-Bay");
		stage.setMinHeight(500);
		stage.setMinWidth(500);

		//create the controller
		new CustomerController(customerView, order, screenController);
		new LoginController(loginView, screenController);
		new AdminController(adminView, model);
		new CreateAccountController(createAccountView, screenController);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
