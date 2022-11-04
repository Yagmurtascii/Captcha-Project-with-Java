package com.example.captchaproject;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class ShapeItems {
    void shapeRandomTextLabel(Label label, float x, float y)
    {
        label.setTranslateX(x);
        label.setTranslateY(y);
        label.setStyle("-fx-background-color: linear-gradient(to bottom,yellow,orange);-fx-border-color:black;-fx-border-radius:4");
        label.setMinHeight(80);
        label.setMinWidth(235);
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font("Chiller",34));
    }
    void shapeTextField(TextField textField, float x, float y)
    {
        textField.setPromptText("Type the characters above");
        textField.setMinWidth(235);
        textField.setMinHeight(45);
        textField.setFont(new Font("Verdana",16));
        textField.setTranslateX(x);
        textField.setTranslateY(y);
    }
    void shapeButton(Button button, float x, float y)
    {
        button.setTranslateX(x);
        button.setTranslateY(y);
        button.setStyle("-fx-border-color:#00A7FF");
        button.setMinWidth(50);
        button.setMinHeight(50);
    }

    void shapeInfoTextLabel(Label label, float x, float y)
    {
        label.setTranslateX(x);
        label.setTranslateY(y);
        label.setMinHeight(20);
        label.setMinWidth(100);
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font("Verdana",14));
    }

}
