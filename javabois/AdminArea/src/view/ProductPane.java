package view;

import javafx.beans.binding.BooleanBinding;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import model.Product;

public class ProductPane extends GridPane {

	private TextField description;
    private TextField unitPrice;
    private TextField productCode;

	public ProductPane() {
		//styling
		this.setPadding(new Insets(20, 20, 20, 20));
		this.setVgap(15);
		this.setHgap(20);
		this.setStyle("-fx-background-color: #EBF6FF;");
		this.setBorder(new Border(new BorderStroke(Color.web("#DADADA"), BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
		this.setAlignment(Pos.CENTER);
		
		ColumnConstraints column0 = new ColumnConstraints();
		column0.setHalignment(HPos.RIGHT);

		ColumnConstraints column1 = new ColumnConstraints();
		column1.setHgrow(Priority.ALWAYS);

		this.getColumnConstraints().addAll(column0, column1);

		//create labels
		Label lblproductCode = new Label("ProductCode");
		Label lblDescription = new Label("Description");
		Label lblunitPrice = new Label("Price");

		// setup text fields
		description = new TextField();
		productCode = new TextField();
		unitPrice = new TextField();

		//add controls and labels to container
		this.add(lblproductCode, 0, 0);
		this.add(productCode, 1, 0);

		this.add(lblDescription, 0, 1);
		this.add(description, 1, 1);

		this.add(unitPrice, 1, 2);
		this.add(lblunitPrice, 0, 2);
	}

	/* a method that returns a boolean binding based upon either textfield being empty */
	public BooleanBinding isEitherFieldEmpty() {
		return description.textProperty().isEmpty().or(unitPrice.textProperty().isEmpty());
	}

	// clear the input fields
	public void clear() {
		productCode.setText("");
		description.setText("");
		unitPrice.setText("");
	}

	//returns a name object based on the input fields
	public Product getProductInput() {
		String productCode = this.productCode.getText();
		String description =  this.description.getText();
		int unitPrice = Integer.parseInt(this.unitPrice.getText());
		return new Product(productCode, description, unitPrice);
	}

}
