package com.example.code_changer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private ComboBox<String> inputLanguageComboBox;

    @FXML
    private ComboBox<String> outputLanguageComboBox;

    @FXML
    private TextField apiKeyField;

    @FXML
    private void importFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt", "*.java", "*.py", "*.js", "*.c", "*.cpp", "*.rb"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            String content = "";
            try {
                content = new String(Files.readAllBytes(selectedFile.toPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Replace the CodeArea code with your desired text processing here
            // For example, you can use a simple TextArea or any other control
        }
    }

    @FXML
    private void translateCode() {
        String inputCode = ""; // Replace this with your desired input text
        String inputLanguage = inputLanguageComboBox.getValue();
        String outputLanguage = outputLanguageComboBox.getValue();
        String apiKey = apiKeyField.getText(); // Access API key from the TextField

        // Ensure the API key is not empty before proceeding with translation
        if (apiKey.isEmpty()) {
            // Show an error message or handle the situation where the API key is missing
            return;
        }

        // Make your request to the Web API with 'inputCode', 'inputLanguage', 'outputLanguage', and 'apiKey' here
        // Parse the response to a String
        String translatedCode = ""; // Replace this with the response from your API

        // Replace the CodeArea code with your desired text processing here
        // For example, you can use a simple TextArea or any other control
        // outputTextArea.replaceText(translatedCode);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inputLanguageComboBox.getItems().addAll("Java", "Python", "Javascript", "C++", "C", "Ruby");
        outputLanguageComboBox.getItems().addAll("Java", "Python", "Javascript", "C++", "C", "Ruby");

        inputLanguageComboBox.setValue("None");
        outputLanguageComboBox.setValue("Choose");
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
