package view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
//import model.Name;
import model.Product;


public class ViewPane extends StackPane {

	private ListView<Product> listView;
	private ObservableList<Product> products;
	
	public ViewPane() {
		products = FXCollections.observableArrayList();
		listView = new ListView<>(products);
		
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		listView.setPrefSize(200, 150);
		
		this.getChildren().add(listView);
	}
	
	//public interface for this pane
	public void addProduct(Product product) {
		products.add(product);
		this.clearSelection();
	}
	
	public ObservableList<Product> getContents() {
		return products;
	}
	
	public void clearNames() {
		products.clear();
	}
	
	public Product getSelectedItem() {
		return listView.getSelectionModel().getSelectedItem();
	}
	
	public ObservableList<Product> getSelectedItems() {
		return listView.getSelectionModel().getSelectedItems();
	}
	
	public void removeSelectedNames() {
		int index = listView.getSelectionModel().getSelectedIndex();
		
		if (index != -1) {
			products.removeAll(this.getSelectedItems());
			this.clearSelection();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Selection Error");
			alert.setContentText("Please select an item to remove.");
			alert.showAndWait();
		}
	}
	
	public void clearSelection() {
		listView.getSelectionModel().clearSelection();
	}
	
}
