package com.example.captchaproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloApplication extends Application {
    Pane root = new Pane();
    GeneralController generalController = new GeneralController();
    ShapeItems shapeItems = new ShapeItems();
    FileInputStream fileInputStream = new FileInputStream("src/main/resources/icons8_approval_30px.png");
    Image verify = new Image(fileInputStream);
    ImageView imageViewVerify = new ImageView(verify);
    FileInputStream fileInputStream2 = new FileInputStream("src/main/resources/icons8_refresh_32px.png");
    Image refresh = new Image(fileInputStream2);
    ImageView imageViewRefresh = new ImageView(refresh);

    FileInputStream fileInputStream3 = new FileInputStream("src/main/resources/icons8_sound_32px.png");
    Image sound = new Image(fileInputStream3);
    ImageView imageViewSound = new ImageView(sound);
    Label randomText = new Label("Random");
    Label infoLabel = new Label();
    Button refreshRandomText = new Button("", imageViewRefresh);
    Button check = new Button("", imageViewVerify);
    Button soundButton = new Button("",imageViewSound);
    TextField text = new TextField("");
    String word = "";
    TextToSound textToSound =new TextToSound();

    public HelloApplication() throws FileNotFoundException {
    }

    @Override
    public void start(Stage stage) throws IOException {
        generalController.createRandomText(randomText);
        word = randomText.getText();
        shapeItems.shapeTextField(text, 135, 240);
        shapeItems.shapeRandomTextLabel(randomText, 135, 125);
        shapeItems.shapeButton(check, 305, 300);
        shapeItems.shapeInfoTextLabel(infoLabel, 235, 90);
        shapeItems.shapeButton(refreshRandomText, 145, 300);
        shapeItems.shapeButton(soundButton, 225, 300);

        refreshRandomText.setOnAction(e ->
        {
            generalController.createRandomText(randomText);
            text.clear();
            infoLabel.setText(" ");
            word = randomText.getText();
        });

        check.setOnAction(e ->
        {
            generalController.checkRandomText(randomText, text);
            if (generalController.checkRandomText(randomText, text) == true)
            {
                infoLabel.setText("Well Done...");
                generalController.createRandomText(randomText);
                text.clear();
            }
            else {
                if (text.getText() == "")
                    infoLabel.setText("Please type any character...");
                else {
                    infoLabel.setText("Please Try Again...");
                    text.clear();

                }
            }
        });

        soundButton.setOnAction(e -> textToSound.converToText(randomText.getText()));
        root.getChildren().addAll(randomText, check, text, refreshRandomText, infoLabel, soundButton);
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("CAPTCHA");
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/main/resources/icons8_captcha_50px.png"));
        stage.show();
    }

}