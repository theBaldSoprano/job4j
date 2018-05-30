package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Date;

public class Tracker {
    /**
     * Array to hold requests.
     */
    Item[] items = new Item[100];

    private int position = 0;

    /**
     * Adds new request to the array.
     *
     * @param item
     * @return
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Replaces request with one passed to method.
     *
     * @param id   - id of request to be replaced.
     * @param item - item to replace with.
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
            }
        }
    }

    /**
     * Deletes request by passed ID.
     *
     * @param id
     */
    void delete(String id) {
        int delete = 0;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                delete = i;
            }
        }
        System.arraycopy(
                this.items,
                delete + 1,
                this.items,
                delete,
                this.items.length - delete - 1
        );
        position--;
    }

    /**
     * Returns copy of items array
     * without null elements.
     *
     * @return
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, position);
    }

    /**
     * Returns only items with specified name.
     *
     * @param name
     * @return
     */
    public Item[] findByName(String name) {
        Item[] result = new Item[this.position];
        int position = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getName().equals(name)) {
                result[position++] = items[i];
            }
        }
        return Arrays.copyOf(result, position);
    }

    /**
     * Returns request by its ID.
     *
     * @param id
     * @return
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }

    /**
     * Just returns whole array of requests.
     *
     * @return
     */
    public Item[] getAll() {
        return this.items;
    }

    /**
     * Generates ID by current time in millis.
     *
     * @return ID.
     */
    private String generateId() {
        //Реализовать метод генерации.
        return Double.toString(new Date().getTime() * 1.139654);
    }
}


/*
добавление заявок - public Item add(Item item);
редактирование заявок - public void replace(String id, Item item);
удаление заявок - public void delete(String id);
получение списка всех заявок - public Item[] findAll();
получение списка по имени - public Item[] findByName(String key);
получение заявки по id - public Item findById(String id);
 */