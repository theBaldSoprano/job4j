package ru.job4j.tracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {
    @Override
    public String ask(String question) {
        System.out.println(question);
        String response = null;
        try {
            response = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
