package com.dtcode.chatgptcli.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ChatGptResponseUsage {
    private int prompt_tokens;
    private int completion_tokens;
    private int total_tokens;

    public ChatGptResponseUsage() {

    }

    public ChatGptResponseUsage(int prompt_tokens, int completion_tokens, int total_tokens) {
        this.prompt_tokens = prompt_tokens;
        this.completion_tokens = completion_tokens;
        this.total_tokens = total_tokens;
    }

    public int prompt_tokens() {
        return prompt_tokens;
    }

    public int completion_tokens() {
        return completion_tokens;
    }

    public int total_tokens() {
        return total_tokens;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ChatGptResponseUsage) obj;
        return this.prompt_tokens == that.prompt_tokens &&
                this.completion_tokens == that.completion_tokens &&
                this.total_tokens == that.total_tokens;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prompt_tokens, completion_tokens, total_tokens);
    }

    @Override
    public String toString() {
        return "ChatGptResponseUsage[" +
                "prompt_tokens=" + prompt_tokens + ", " +
                "completion_tokens=" + completion_tokens + ", " +
                "total_tokens=" + total_tokens + ']';
    }

}
