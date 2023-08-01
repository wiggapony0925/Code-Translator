package com.example.code_changer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private TextArea inputTextArea;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private Button importButton;

    @FXML
    private Button translateButton;

    @FXML
    private ComboBox<String> inputLanguageComboBox;

    @FXML
    private ComboBox<String> outputLanguageComboBox;



    @Override  //handles the Dropdown box for the langues
    public void initialize(URL url, ResourceBundle rb) {
        inputLanguageComboBox.getItems().addAll("Java", "Python", "Javascript","C++", "C", "Ruby");
        outputLanguageComboBox.getItems().addAll("Java", "Python", "Javascript","C++", "C", "Ruby");

        inputLanguageComboBox.setValue("None");
        outputLanguageComboBox.setValue("Choose");
        // Now use the TextFields.bindAutoCompletion method to make the ComboBoxes searchable
        AutoCompletionBinding<String> autoCompletionBindingInput = TextFields.bindAutoCompletion(inputLanguageComboBox.getEditor(), inputLanguageComboBox.getItems());
        AutoCompletionBinding<String> autoCompletionBindingOutput = TextFields.bindAutoCompletion(outputLanguageComboBox.getEditor(), outputLanguageComboBox.getItems());
    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}