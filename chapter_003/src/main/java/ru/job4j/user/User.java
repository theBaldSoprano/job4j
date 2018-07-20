package ru.job4j.user;

public class User implements Comparable<User> {
    private int id;
    private String name;
    private String city;

    @Override
    public int compareTo(User o) {
        if (this.age < o.age){
            return -1;
        }else if (this.age == o.age){
            return 0;
        }else return 1;
    }

    private int age;

    public User(int id, String name, String city, int age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
