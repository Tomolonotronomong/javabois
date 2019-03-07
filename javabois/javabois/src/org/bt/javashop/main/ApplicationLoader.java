
package org.bt.javashop.main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bt.javashop.controller.*;
import org.bt.javashop.model.Order;
import org.bt.javashop.model.Stock;
import org.bt.javashop.view.Authentication.AdminAuthView;
import org.bt.javashop.view.Authentication.AuthView;
import org.bt.javashop.view.Checkout.CheckoutView;
import org.bt.javashop.view.admin.AdminStockView;
import org.bt.javashop.view.create.CreateAccountView;
import org.bt.javashop.view.customer.CustomerView;
import org.bt.javashop.view.login.Landing;

public class ApplicationLoader extends Application {

	private AdminStockView adminView;
	private CustomerView customerView;
	private Landing landing;
	private ScreenController screenController;
	private CreateAccountView createAccountView;
	private AuthView authView;
	private AdminAuthView adminAuthView;
	private CheckoutView checkoutView;

	@Override
	public void start(Stage stage) throws Exception {
		//create the models
		Stock stock = new Stock();
		Order order = new Order();

		//create the views
		customerView = new CustomerView();
		adminView = new AdminStockView();
		landing = new Landing();
		createAccountView = new CreateAccountView();
		authView = new AuthView();
		adminAuthView = new AdminAuthView();
		checkoutView = new CheckoutView();


		//add the root node
		Group root = new Group(landing);
		Scene main = new Scene(root);
		stage.setScene(main); //TODO fix login
		screenController = new ScreenController(main);

		//add the available views to the controller
		screenController.addScreen("customerView", customerView);
		screenController.addScreen("adminView", adminView);
		screenController.addScreen("landing", landing);
		screenController.addScreen("createAccountView", createAccountView );
		screenController.addScreen("authView", authView);
		screenController.addScreen("adminAuthView", adminAuthView);
		screenController.addScreen("checkoutView", checkoutView);
	//	screenController.addScreen("about, AboutView);

		stage.setTitle("B-Bay");
		stage.setMinHeight(500);
		stage.setMinWidth(500);

		//create the controller
		new CustomerController(customerView, order, screenController, stock);
		new LoginController(landing, screenController);
		new AdminController(adminView, stock);
		new CreateAccountController(createAccountView, screenController);
		new AuthController(authView, screenController);
		new AdminAuthController(adminAuthView, screenController);
		new CheckoutController (checkoutView, screenController);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
