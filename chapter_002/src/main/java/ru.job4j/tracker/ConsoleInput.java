package ru.job4j.tracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

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

    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exists = false;
        if (range.contains(key)) {
            exists = true;
        }
        if (!exists) {
            throw new MenuOutException("Yo dude! Here you were out of menu number range");
        }
        return key;
    }
}
