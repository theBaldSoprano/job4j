package ru.job4j;

public class Teacher extends Profession {
    public void teach(Student student) {
        student.isSmart = true;
    }
}
