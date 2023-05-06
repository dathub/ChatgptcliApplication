package com.dtcode.chatgptcli.command;

import com.dtcode.chatgptcli.service.ChatGptService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.IOException;

@ShellComponent
public class ChatGptCliCommands {

    private final String answerPrefix = "ANSWER: ";
    private final ChatGptService chatGptService;

    public ChatGptCliCommands(ChatGptService chatGptService) {
        this.chatGptService = chatGptService;
    }

    @ShellMethod(key = "ask", value = "Ask your question")
    public String ask(String question) {
        try {
            return answerPrefix + chatGptService.ask(question);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(answerPrefix + "I dont know.");
        return question;
    }

}
