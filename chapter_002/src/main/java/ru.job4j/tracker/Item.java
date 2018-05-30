package ru.job4j.tracker;

/**
 * This class describes one Request
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private long created;
    private String[] comments;

    public Item(String id, String name, String description, long created, String[] comments) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
        this.comments = comments;
    }

    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }
}
