package com.example.code_changer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    private Label OpenaiText;
    @FXML
    private ComboBox<String> inputLanguageComboBox;

    @FXML
    private ComboBox<String> outputLanguageComboBox;

    @FXML
    private TextField apiKeyField;

    @FXML
    private TextArea outputTextArea; // Add this declaration

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
        // For example, if you have a method that makes the API call and returns the translated code as a String:
        String translatedCode = makeAPICall(inputCode, inputLanguage, outputLanguage, apiKey);

        // Replace the CodeArea code with your desired text processing here
        // For example, you can use a simple TextArea or any other control
        outputTextArea.setText(translatedCode);
    }

    // This is just a placeholder method, you should implement your own API call logic
    private String makeAPICall(String inputCode, String inputLanguage, String outputLanguage, String apiKey) {
        // Implement your API call here using the provided 'inputCode', 'inputLanguage', 'outputLanguage', and 'apiKey'
        // Send the request to the API endpoint and parse the response to a String
        // For the sake of this example, let's assume we are returning a sample translated code
        return "Translated code: " + inputCode + " to " + outputLanguage;
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
