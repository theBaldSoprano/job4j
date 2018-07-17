package ru.job4j.userconvert;

public class User {
    private int id;
    private String user;
    private String city;

    public User(int id, String user, String city) {
        this.id = id;
        this.user = user;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
