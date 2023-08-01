package com.example.code_changer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import org.fxmisc.richtext.CodeArea;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private CodeArea inputTextArea;

    @FXML
    private CodeArea outputTextArea;

    @FXML
    private Button importButton;

    @FXML
    private Button translateButton;

    @FXML
    private ComboBox<String> inputLanguageComboBox;

    @FXML
    private ComboBox<String> outputLanguageComboBox;

    @FXML
    private TextField apiKeyField;

    @Override  //handles the Dropdown box for the languages
    public void initialize(URL url, ResourceBundle rb) {
        inputLanguageComboBox.getItems().addAll("Java", "Python", "Javascript","C++", "C", "Ruby");
        outputLanguageComboBox.getItems().addAll("Java", "Python", "Javascript","C++", "C", "Ruby");

        inputLanguageComboBox.setValue("None");
        outputLanguageComboBox.setValue("Choose");

        // Now use the TextFields.bindAutoCompletion method to make the ComboBoxes searchable
        AutoCompletionBinding<String> autoCompletionBindingInput = TextFields.bindAutoCompletion(inputLanguageComboBox.getEditor(), inputLanguageComboBox.getItems());
        AutoCompletionBinding<String> autoCompletionBindingOutput = TextFields.bindAutoCompletion(outputLanguageComboBox.getEditor(), outputLanguageComboBox.getItems());
    }

    @FXML //handles the file input
    private void importFile(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt", "*.java", "*.py", "*.js", "*.c", "*.cpp", "*.rb"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            String content = "";
            try {
                content = new String(Files.readAllBytes(selectedFile.toPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            inputTextArea.replaceText(content);
        }
    }

    @FXML
    private void translateCode() {
        String inputCode = inputTextArea.getText();
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

        outputTextArea.replaceText(translatedCode);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
