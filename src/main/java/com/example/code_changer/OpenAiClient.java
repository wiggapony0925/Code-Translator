package com.example.code_changer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class OpenAiClient {
    private static final String API_BASE_URL = "https://api.openai.com/v1/";
    private static final String API_ENDPOINT_TRANSLATE = "engines/davinci-codex/completions";

    private String apiKey;

    public OpenAiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public String translateCode(String inputCode, String inputLanguage, String outputLanguage) {
        try {
            // Construct the API URL
            URL url = new URL(API_BASE_URL + API_ENDPOINT_TRANSLATE);

            // Set up the HTTP connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);

            // Construct the request payload
            String payload = "{\"prompt\": \"" + inputCode + "\", \"max_tokens\": 150, \"temperature\": 0.7, \"stop\": [\"\\n\"], \"language\": \"" + inputLanguage + "\", \"target_language\": \"" + outputLanguage + "\"}";
            byte[] postData = payload.getBytes(StandardCharsets.UTF_8);

            // Send the request
            connection.setDoOutput(true);
            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.write(postData);
            }

            // Read the response
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
