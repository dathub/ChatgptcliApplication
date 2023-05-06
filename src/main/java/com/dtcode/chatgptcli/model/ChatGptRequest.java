package com.dtcode.chatgptcli.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ChatGptRequest {
    private String model;
    private String prompt;
    private int temperature;
    private int max_tokens;

    public ChatGptRequest(String model, String prompt, int temperature, int max_tokens) {
        this.model = model;
        this.prompt = prompt;
        this.temperature = temperature;
        this.max_tokens = max_tokens;
    }

    public String model() {
        return model;
    }

    public String prompt() {
        return prompt;
    }

    public int temperature() {
        return temperature;
    }

    public int max_tokens() {
        return max_tokens;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ChatGptRequest) obj;
        return Objects.equals(this.model, that.model) &&
                Objects.equals(this.prompt, that.prompt) &&
                this.temperature == that.temperature &&
                this.max_tokens == that.max_tokens;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, prompt, temperature, max_tokens);
    }

    @Override
    public String toString() {
        return "ChatGptRequest[" +
                "model=" + model + ", " +
                "prompt=" + prompt + ", " +
                "temperature=" + temperature + ", " +
                "max_tokens=" + max_tokens + ']';
    }

}
