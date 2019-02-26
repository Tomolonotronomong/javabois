package org.bt.javashop.controller;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.util.HashMap;

public class ScreenController {

    private HashMap<String, Pane> screens = new HashMap<>();
    private Scene main;

    public ScreenController(Scene main) {
        this.main = main;
    }

    public void addScreen(String name, Pane pane){
        screens.put(name, pane);
    }

    public void removeScreen(String name){
        screens.remove(name);
    }

    public void activate(String name){
        main.setRoot(screens.get(name) );
    }
}
