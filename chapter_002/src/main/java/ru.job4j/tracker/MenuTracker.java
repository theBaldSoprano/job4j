package ru.job4j.tracker;

import java.util.Date;

/**
 * This class represents menu of the program.
 * It can draw menu and perform actions.
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] userActions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int[] getMenuRange() {
        int[] result = new int[userActions.length];
        for (int i = 0; i < userActions.length; i++) {
            result[i] = userActions[i].key();
        }
        return result;
    }

    /**
     * Inits available actions.
     */
    public void fillActions() {
        this.userActions[0] = this.new AddItem();
        this.userActions[1] = new MenuTracker.ShowItems();
        this.userActions[2] = new EditItem();
        this.userActions[3] = new DeleteItem();
        this.userActions[4] = new FindById();
        this.userActions[5] = new FindByName();
        this.userActions[6] = new Exit();
    }

    public void select(int key) {
        this.userActions[key].execute(this.input, this.tracker);
    }

    /**
     * Prints menu.
     */
    public void show() {
        System.out.println("------------ MENU --------------");
        for (UserAction useraction : this.userActions) {
            if (useraction != null) {
                System.out.println(useraction.info());
            }
        }
        System.out.println("------------ **** --------------");
    }

    /**
     * Adds item to tracker.
     */
    private class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new task --------------");
            String name = input.ask("Enter task's name :");
            String desc = input.ask("Enter description :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New task id: " + item.getId() + "-----------");
        }

        @Override
        public String info() {
            return String.format("%s. Add new item.", this.key());
        }
    }

    /**
     * Prints all items to console.
     */
    private static class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ List of all tasks --------------");
            for (Item item : tracker.getAllNotNull()) {
                System.out.println(item.toString());
            }
            System.out.println("------------ End of list --------------");
        }

        @Override
        public String info() {
            return String.format("%s. Show all items.", this.key());
        }
    }

    /**
     * Deletes specified (by id) item.
     */
    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter ID of task you want to delete.");
            tracker.delete(id);
            System.out.println("------------ Done! --------------");
        }

        @Override
        public String info() {
            return String.format("%s. Delete item.", this.key());
        }
    }

    /**
     * Prints the specified by ID task.
     */
    private class FindById implements UserAction {
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter ID of task you want to find.");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("------------ no task with such ID --------------");
                return;
            }
            System.out.println("------------ TASK --------------");
            System.out.println(item.toString());
            System.out.println("|| Description: " + item.getDescription());
            System.out.println("|| Date created: " + new Date(item.getCreated()).toString());
            System.out.println("------------ END --------------");
        }

        @Override
        public String info() {
            return String.format("%s. Find item by id.", this.key());
        }
    }

    /**
     * Prints all tasks that match passed name pattern.
     */
    private class FindByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter search word.");
            Item[] items = tracker.findByName(name);
            System.out.println("------------ TASKS LIST --------------");
            for (Item item : items) {
                System.out.println(item.toString());
            }
            System.out.println("------------ END --------------");
        }

        @Override
        public String info() {
            return String.format("%s. Find item by name.", this.key());
        }
    }

    /**
     * Mock for Exit menu line.
     */
    private class Exit implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }

        @Override
        public String info() {
            return String.format("%s. Exit menu.", this.key());
        }
    }
}

/**
 * Edits specified (by id) item.
 */
class EditItem implements UserAction {

    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter ID of task you want to edit.");
        Item oldItem = tracker.findById(id);
        if (oldItem == null) {
            System.out.println("------------ No tasks with specified ID!!! --------------");
            return;
        }
        String name = input.ask("Enter new name.");
        String description = input.ask("Enter new description.");
        Item newItem = new Item(name, description);
        newItem.setCreated(oldItem.getCreated());
        tracker.replace(id, newItem);
        System.out.println("------------ Done! --------------");
    }

    @Override
    public String info() {
        return String.format("%s. Edit item.", this.key());
    }
}
