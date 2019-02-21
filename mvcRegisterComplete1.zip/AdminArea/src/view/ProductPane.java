package view;

import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
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

	// private ComboBox<String> cboproductCode;
	private TextField txtdescription, txtunitPrice ,txtproductCode;

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

		// setup combobox
		//ObservableList<String> titles = FXCollections.observableArrayList("Mr", "Mrs", "Miss", "Ms", "Dr");
		//cboproductCode = new ComboBox<String>(titles);
		//cboproductCode.getSelectionModel().select(0);
		//cboproductCode.setVisibleRowCount(4);
		
		// setup text fields
		txtdescription = new TextField();
		txtproductCode = new TextField();
		txtunitPrice = new TextField();

		//add controls and labels to container
		this.add(lblproductCode, 0, 0);
		this.add(txtproductCode, 1, 0);

		this.add(lblDescription, 0, 1);
		this.add(txtdescription, 1, 1);

		this.add(txtunitPrice, 1, 2);
		this.add(lblunitPrice, 0, 2);
	}

	/* a method that returns a boolean binding based upon either textfield being empty */
	public BooleanBinding isEitherFieldEmpty() {
		return txtdescription.textProperty().isEmpty().or(txtunitPrice.textProperty().isEmpty());
	}

	// clear the input fields
	public void clear() {
		txtproductCode.setText("");
		txtdescription.setText("");
		txtunitPrice.setText("");
	}
	public static void main(String[] args){
		String txtunitPrice = "100";
		try
		{
			int i = Integer.parseInt(txtunitPrice);
		}
		catch (NumberFormatException nfe)
		{
			System.out.println("NumberFormatException: "+ nfe.getMessage());
		}
	}

	//returns a name object based on the input fields
	public Product getProductInput() {
		String productCode = txtproductCode.getText();
		String description =  txtdescription.getText();
		int unitPrice = 100; //hardcoded
		return new Product(productCode, description, unitPrice);
	}

}
