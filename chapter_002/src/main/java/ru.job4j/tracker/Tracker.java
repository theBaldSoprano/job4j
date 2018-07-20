package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Tracker {
    /**
     * Array to hold requests.
     */
    private ArrayList<Item> items = new ArrayList<>();

    private long currentId = 1;

    /**
     * Adds new request to the array.
     *
     * @param item
     * @return
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    /**
     * Replaces request with one passed to method.
     *
     * @param id   - id of request to be replaced.
     * @param item - item to replace with.
     */
    public void replace(String id, Item item) {
        items
                .stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .get()
                .replace(item);
    }

    /**
     * Deletes item by passed ID.
     *
     * @param id
     */
    public void delete(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                break;
            }
        }
    }

    /**
     * Returns only items with specified name.
     *
     * @param name
     * @return
     */
    public ArrayList<Item> findByName(String name) {
        ArrayList<Item> result = new ArrayList<>();
        this.items
                .stream()
                .forEach(item -> {
                    if (item.getName().contains(name)) {
                        result.add(item);
                    }
                });
        return result;
    }

    /**
     * Returns request by its ID.
     *
     * @param id
     * @return
     */
    public Item findById(String id) {
        return items
                .stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Just returns whole array of requests.
     *
     * @return
     */
    public ArrayList<Item> getAll() {
        return this.items;
    }

    /**
     * Generates ID by current time in millis.
     *
     * @return ID.
     */
    private String generateId() {
        return Long.toString(currentId++);
    }
}