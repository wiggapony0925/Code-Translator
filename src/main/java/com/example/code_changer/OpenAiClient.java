package com.example.code_changer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
public class OpenAiClient {
    private static final String API_BASE_URl = "";
    private static final String APi_ENDPOINT_TRANSLATE = "";

    private String apiKey;

    public OpenAiClient(String apiKey) {
        this.apiKey = apiKey;
    }


}
