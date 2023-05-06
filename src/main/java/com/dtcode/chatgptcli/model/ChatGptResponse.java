package com.dtcode.chatgptcli.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ChatGptResponse {
    private String id;
    private String object;
    private int created;
    private String model;
    private ChatGptResponseChoice[] choices;
    private ChatGptResponseUsage usage;

    public ChatGptResponse(){

    }

    public ChatGptResponse(
            String id,
            String object,
            int created,
            String model,
            ChatGptResponseChoice[] choices,
            ChatGptResponseUsage usage) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.choices = choices;
        this.usage = usage;
    }

    public String id() {
        return id;
    }

    public String object() {
        return object;
    }

    public int created() {
        return created;
    }

    public String model() {
        return model;
    }

    public ChatGptResponseChoice[] choices() {
        return choices;
    }

    public ChatGptResponseUsage usage() {
        return usage;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ChatGptResponse) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.object, that.object) &&
                this.created == that.created &&
                Objects.equals(this.model, that.model) &&
                Objects.equals(this.choices, that.choices) &&
                Objects.equals(this.usage, that.usage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, object, created, model, choices, usage);
    }

    @Override
    public String toString() {
        return "ChatGptResponse[" +
                "id=" + id + ", " +
                "object=" + object + ", " +
                "created=" + created + ", " +
                "model=" + model + ", " +
                "choices=" + choices + ", " +
                "usage=" + usage + ']';
    }

}
