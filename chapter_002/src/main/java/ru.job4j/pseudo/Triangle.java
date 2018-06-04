package ru.job4j.pseudo;

public class Triangle implements Shape {
    public static void main(String[] args) {
        System.out.println(new Triangle().draw());
    }
    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("   /\\");
        sb.append(System.lineSeparator());
        sb.append("  /  \\");
        sb.append(System.lineSeparator());
        sb.append(" /    \\");
        sb.append(System.lineSeparator());
        sb.append("/______\\");
        return sb.toString();
    }
}
