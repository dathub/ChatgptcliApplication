package com.dtcode.chatgptcli.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ChatGptResponseChoice {
    private String text;
    private int index;
    private Object logprobs;
    private String finish_reason;

    public ChatGptResponseChoice(){

    }

    public ChatGptResponseChoice(
            String text,
            int index,
            Object logprobs,
            String finish_reason) {
        this.text = text;
        this.index = index;
        this.logprobs = logprobs;
        this.finish_reason = finish_reason;
    }

    public String text() {
        return text;
    }

    public int index() {
        return index;
    }

    public Object logprobs() {
        return logprobs;
    }

    public String finish_reason() {
        return finish_reason;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ChatGptResponseChoice) obj;
        return Objects.equals(this.text, that.text) &&
                this.index == that.index &&
                Objects.equals(this.logprobs, that.logprobs) &&
                Objects.equals(this.finish_reason, that.finish_reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, index, logprobs, finish_reason);
    }

    @Override
    public String toString() {
        return "ChatGptResponseChoice[" +
                "text=" + text + ", " +
                "index=" + index + ", " +
                "logprobs=" + logprobs + ", " +
                "finish_reason=" + finish_reason + ']';
    }

}
