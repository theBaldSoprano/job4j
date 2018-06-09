package ru.job4j.tracker;

import java.io.IOException;

public interface Input {
    /**
     * Suppose to ask question and
     * return answer.
     * @param question
     * @return
     */
    String ask(String question);

    int ask(String question, int[] range);
}
