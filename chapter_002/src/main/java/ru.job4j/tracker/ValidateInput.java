package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int result = -1;
        do {
            try {
                result = super.ask(question, range);
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
