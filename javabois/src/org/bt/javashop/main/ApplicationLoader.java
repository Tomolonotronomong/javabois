
package org.bt.javashop.main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bt.javashop.controller.AdminController;
import org.bt.javashop.controller.CustomerController;
import org.bt.javashop.controller.LoginController;
import org.bt.javashop.controller.ScreenController;
import org.bt.javashop.model.Order;
import org.bt.javashop.model.Stock;
import org.bt.javashop.view.AdminStockView;
import org.bt.javashop.view.CreateAccountView;
import org.bt.javashop.view.CustomerView;
import org.bt.javashop.view.LoginView;

public class ApplicationLoader extends Application {

	private AdminStockView adminView;
	private CustomerView customerView;
	private LoginView loginView;
	private ScreenController screenController;
	private CreateAccountView createAccountView;

	@Override
	public void start(Stage stage) throws Exception {
		Stock model = new Stock();
		Order order = new Order();

		customerView = new CustomerView();
		adminView = new AdminStockView();
		loginView = new LoginView();
		createAccountView = new CreateAccountView();


		Group root = new Group(createAccountView);
		Scene main = new Scene(root);
		stage.setScene(main); //TODO fix login
		screenController = new ScreenController(main);
		screenController.addScreen("customerView", customerView);
		screenController.addScreen("adminView", adminView);
		screenController.addScreen("loginView", loginView);
		screenController.addScreen("createAccountView", createAccountView );

		stage.setTitle("B-Bay");
		stage.setMinHeight(500);
		stage.setMinWidth(500);

		new CustomerController(customerView, order, screenController);
		new LoginController(loginView, screenController);
		new AdminController(adminView, model);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
