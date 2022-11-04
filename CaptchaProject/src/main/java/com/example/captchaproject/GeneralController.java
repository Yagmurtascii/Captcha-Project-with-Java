package com.example.captchaproject;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class GeneralController {

    ArrayList <Character> characterArrayList=new ArrayList<>();
    String value="";
    public void createRandomText(Label label)
    {
        clearText();
        Random random = new Random();
        for(int i=0;i<8;i++)
        {
            char randomLetter = (char)(random.nextInt(26) + 'a');
            characterArrayList.add(randomLetter);
        }
        for(int i=0;i<8;i++)
        {
            int randomNumbers=random.nextInt(2);
            if(randomNumbers==0)
              value+=characterArrayList.get(i).toString().toLowerCase(Locale.ROOT);

           else
                value+=characterArrayList.get(i).toString().toUpperCase(Locale.ROOT);

        }
        label.setText(value);

    }

    public void clearText()
    {
        characterArrayList.clear();
        value="";
    }

    public boolean checkRandomText(Label label, TextField textField)
    {
        if(label.getText().equals(textField.getText()))
            return true;
        else
            return false;
    }
}
