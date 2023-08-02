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

import java.util.Objects;


public class HelloController implements Initializable {


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

        OpenAiClient openAiClient = new OpenAiClient(apiKey);
        String translatedCode = openAiClient.translateCode(inputCode, inputLanguage, outputLanguage);

        outputTextArea.setText(Objects.requireNonNullElse(translatedCode, "Translation failed. Please try again"));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inputLanguageComboBox.getItems().addAll("Java", "Python", "Javascript", "C++", "C", "Ruby");
        outputLanguageComboBox.getItems().addAll("Java", "Python", "Javascript", "C++", "C", "Ruby");

        inputLanguageComboBox.setValue("None");
        outputLanguageComboBox.setValue("Choose");
    }

}
