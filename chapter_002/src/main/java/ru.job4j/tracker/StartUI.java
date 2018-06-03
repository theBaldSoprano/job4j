package ru.job4j.tracker;

import java.io.IOException;
import java.util.Date;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Константа для вывода всех заявок.
     */
    private static final String SHOW_ALL = "1";

    /**
     * Константа для редактирования заявки.
     */
    private static final String EDIT_ITEM = "2";

    /**
     * Константа для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа для поиска записи по ID.
     */
    private static final String FIND_BY_ID = "4";

    /**
     * Константа для поиска записи по имени.
     */
    private static final String FIND_BY_NAME = "5";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        this.cls();
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Enter menu number : ");
            this.cls();
            switch (answer) {
                case ADD:
                    this.createItem();
                    break;
                case EXIT:
                    exit = true;
                    break;
                case SHOW_ALL:
                    this.showAllItems();
                    break;
                case EDIT_ITEM:
                    this.editItem();
                    break;
                case DELETE:
                    this.deleteItem();
                    break;
                case FIND_BY_ID:
                    this.findById();
                    break;
                case FIND_BY_NAME:
                    this.findByName();
                    break;
                default:
                    System.out.println("------------ Wrong menu number. Try again. ------------");
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Adding new task --------------");
        String name = this.input.ask("Enter task's name :");
        String desc = this.input.ask("Enter description :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("------------ New task id : " + item.getId() + "-----------");
    }

    /**
     * Prints all existing requests.
     */
    private void showAllItems() {
        Item[] allItems = this.tracker.findAllNotNull();
        System.out.println("------------ List of all tasks --------------");
        for (Item item : allItems) {
            System.out.println(item.toString());
        }
        System.out.println("------------ End of list --------------");
    }

    /**
     * Edits specified item.
     */
    private void editItem() {
        String id = this.input.ask("Enter ID of task you want to edit.");
        String name = this.input.ask("Enter new name.");
        String description = this.input.ask("Enter new description.");
        Item newItem = new Item(name, description);
        Item oldItem = this.tracker.findById(id);
        if (oldItem == null) {
            System.out.println("------------ No tasks with specified ID!!! --------------");
        } else {
            newItem.setCreated(oldItem.getCreated());
            this.tracker.replace(id, newItem);
            System.out.println("------------ Done! --------------");
        }
    }

    /**
     * Deletes the specified by ID task.
     */
    public void deleteItem() {
        String id = this.input.ask("Enter ID of task you want to delete.");
        this.tracker.delete(id);
        System.out.println("------------ Done! --------------");
    }

    /**
     * Prints the specified by ID task.
     */
    public void findById() {
        String id = this.input.ask("Enter ID of task you want to find.");
        Item item = this.tracker.findById(id);
        System.out.println("------------ TASK --------------");
        System.out.println(item.toString());
        System.out.println("Description: " + item.getDescription());
        System.out.println("Date created: " + new Date(item.getCreated()).toString());
        System.out.println("------------ END --------------");
    }

    /**
     * Prints all tasks that match passed name pattern.
     */
    private void findByName() {
        String name = this.input.ask("Enter search word.");
        Item[] items = this.tracker.findByName(name);
        System.out.println("------------ TASKS LIST --------------");
        for (Item item : items) {
            System.out.println(item.toString());
        }
        System.out.println("------------ END --------------");
    }

    private void showMenu() {
        System.out.println("------------ Menu. ------------");
        System.out.println("--------- 0. Add task.");
        System.out.println("--------- 1. Show all tasks.");
        System.out.println("--------- 2. Edit task.");
        System.out.println("--------- 3. Delete task.");
        System.out.println("--------- 4. Find task by ID.");
        System.out.println("--------- 5. Find task by name.");
        System.out.println("--------- 6. Exit.");
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
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}