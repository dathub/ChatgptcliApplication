package com.dtcode.chatgptcli.service;

import com.dtcode.chatgptcli.model.ChatGptRequest;
import com.dtcode.chatgptcli.model.ChatGptResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ChatGptService {

    @Value("${openai.api.key}")
    private String apiKey;

    public String ask(String prompt) throws IOException, InterruptedException {
        ChatGptRequest chatGptRequest = new ChatGptRequest("text-davinci-001", prompt, 1, 100);

        ObjectMapper mapper = new ObjectMapper();
        String input = mapper.writeValueAsString(chatGptRequest);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/completions"))
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(input))
                .build();

        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() == 200) {
            ChatGptResponse chatGptResponse = mapper.readValue(response.body(), ChatGptResponse.class);
            String answer = chatGptResponse.choices()[chatGptResponse.choices().length-1].text();
            if(!answer.isEmpty()) {
                return answer.replace("\n","").trim();
            }
        }

        return response.body();

    }
}
