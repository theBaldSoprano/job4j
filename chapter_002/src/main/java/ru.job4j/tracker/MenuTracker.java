package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents menu of the program.
 * It can draw menu and perform actions.
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    //private UserAction[] userActions = new UserAction[7];
    private ArrayList<UserAction> userActions = new ArrayList<UserAction>();
    public boolean exit = false;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public List<Integer> getMenuRange() {
        return userActions.stream()
                .map(UserAction::getKey)
                .collect(Collectors.toList());
    }

    /**
     * Inits available actions.
     */
    public void fillActions() {
        this.userActions.add(this.new AddItem(0, "Add item."));
        this.userActions.add(new MenuTracker.ShowItems(1, "Show all items."));
        this.userActions.add(new EditItem(2, "Edit item."));
        this.userActions.add(new DeleteItem(3, "Delete item."));
        this.userActions.add(new FindById(4, "Find item by id."));
        this.userActions.add(new FindByName(5, "Find item by name."));
        this.userActions.add(new Exit(6, "Exit."));
    }

    public void select(int key) {
        this.userActions.get(key).execute(this.input, this.tracker);
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
    private class AddItem extends BaseAction {
        public AddItem(int key, String info) {
            super(key, info);
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
    }

    /**
     * Prints all items to console.
     */
    private static class ShowItems extends BaseAction {
        public ShowItems(int key, String info) {
            super(key, info);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ List of all tasks --------------");
            for (Item item : tracker.getAll()) {
                System.out.println(item.toString());
            }
            System.out.println("------------ End of list --------------");
        }
    }

    /**
     * Deletes specified (by id) item.
     */
    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String info) {
            super(key, info);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter ID of task you want to delete.");
            tracker.delete(id);
            System.out.println("------------ Done! --------------");
        }
    }

    /**
     * Prints the specified by ID task.
     */
    private class FindById extends BaseAction {
        public FindById(int key, String info) {
            super(key, info);
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

    }

    /**
     * Prints all tasks that match passed name pattern.
     */
    private class FindByName extends BaseAction {
        public FindByName(int key, String info) {
            super(key, info);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter search word.");
            System.out.println("------------ TASKS LIST --------------");
            for (Item item : tracker.findByName(name)) {
                System.out.println(item.toString());
            }
            System.out.println("------------ END --------------");
        }
    }

    /**
     * Mock for Exit menu line.
     */
    private class Exit extends BaseAction {
        public Exit(int key, String info) {
            super(key, info);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            //System.out.println("do you really want to exit?");
            exit = true;
        }
    }
}

/**
 * Edits specified (by id) item.
 */
class EditItem extends BaseAction {
    public EditItem(int key, String info) {
        super(key, info);
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
}
