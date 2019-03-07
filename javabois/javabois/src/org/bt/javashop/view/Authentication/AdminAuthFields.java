package org.bt.javashop.view.Authentication;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AdminAuthFields extends VBox {

    private TextField username;
    private PasswordField password;
    private Button login;

    public AdminAuthFields() {

        username = new TextField("Username");
        password = new PasswordField();
        login = new Button("Login");
        
        login.setMinWidth(100);
        login.setMinHeight(35);

        this.setAlignment(Pos.BASELINE_CENTER);
        this.setLayoutX(200);
        this.setLayoutY(200);
        this.getChildren().addAll(username, password, login);
        

    }

    public void addAuthHandler(EventHandler<ActionEvent> handler) { login.setOnAction(handler);
    }
}
