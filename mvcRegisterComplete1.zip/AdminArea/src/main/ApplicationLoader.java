
package main;

import controller.RegisterController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Cart;
import view.AdminProductPane;

public class ApplicationLoader extends Application {

	private AdminProductPane view;
	
	@Override
	public void init() {
		//create model and view and pass their references to the controller
		Cart model = new Cart();
		view = new AdminProductPane();
		new RegisterController(view, model);	
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Registration form - MVC");
		stage.setScene(new Scene(view));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
