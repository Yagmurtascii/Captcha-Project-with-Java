module com.example.captchaproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires voicerss.tts;
    requires jsapi;
    requires freetts;


    opens com.example.captchaproject to javafx.fxml;
    exports com.example.captchaproject;
}