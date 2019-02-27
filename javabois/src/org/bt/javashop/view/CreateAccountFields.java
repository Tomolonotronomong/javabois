package org.bt.javashop.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreateAccountFields extends VBox {

    private TextField username;
    private TextField firstname;
    private TextField surname;
    private PasswordField password1;
    private Button create;


    public CreateAccountFields(){

        username = new TextField("Username");
        firstname = new TextField("First Name");
        surname = new TextField("Surname");
        password1 = new PasswordField();
        create = new Button("Create Account");


        this.setAlignment(Pos.BASELINE_CENTER);
        this.setLayoutX(200);
        this.setLayoutY(200);


        this.getChildren().addAll(username,firstname,surname,password1,create);
    }
}
