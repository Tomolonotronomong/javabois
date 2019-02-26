package org.bt.javashop.view;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AdminStockView extends BorderPane {

	private AdminButtonPane buttonPane;
	private ProductInputPane inputPane;
	private ProductListPane productListPane;
	private RegisterMenuBar menuBar;
	
	public AdminStockView() {
		//background
		this.setStyle("-fx-background-color: #ff4500;");
		
		inputPane = new ProductInputPane();
		productListPane = new ProductListPane();
		buttonPane = new AdminButtonPane();
		menuBar = new RegisterMenuBar();
		
		VBox topContainer = new VBox(inputPane, buttonPane);
		topContainer.setSpacing(20); //spacing between inputPane and buttonPane
		topContainer.setPadding(new Insets(0,0,20,0)); //bottom padding between this container and productListPane
		
		BorderPane rootContainer = new BorderPane();
		rootContainer.setTop(topContainer);
		rootContainer.setCenter(productListPane);
		rootContainer.setPadding(new Insets(20,20,20,20)); //padding around the entire root container
		
		this.setTop(menuBar);
		this.setCenter(rootContainer);
	}

	/* These methods provide a public interface for the root pane and allow
	 * each of the sub-containers to be accessed by the org.bt.javashop.controller.
	 */
	public AdminButtonPane getButtonPane() {
		return buttonPane;
	}

	public ProductInputPane getProductPane() {
		return inputPane;
	}

	public ProductListPane getViewPane() {
		return productListPane;
	}
	
	public RegisterMenuBar getMenuBar() {
		return menuBar;
	}
}
