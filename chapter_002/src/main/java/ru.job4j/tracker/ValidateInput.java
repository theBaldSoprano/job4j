package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int result = -1;
        do {
            try {
                result = this.input.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid number -> Must be a number of action from menu");
            } catch (MenuOutException moe) {
                System.out.println("No such number in menu");
            }
        } while (invalid);
        return result;
    }
}
