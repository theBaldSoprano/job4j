package ru.job4j.tracker;

import java.io.IOException;

/**
 * Start point to lauch all program modules, such as:
 * Tracker, Input module and Menu module.
 *
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    private int[] menuRange;
    MenuTracker menuTracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        menuTracker = new MenuTracker(this.input, this.tracker);
        menuTracker.fillActions();
        menuRange = menuTracker.getMenuRange();
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        while (true){
            menuTracker.show();
            menuTracker.select(input.ask("enter submenu number", menuRange));
        }
    }

    /**
     * Clears CMD screen. Only for windows pc.
     * Executes win command line with cls command.
     */
    private void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}