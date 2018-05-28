package ru.job4j;

public class Doctor extends Profession{
    public Diagnose treat (Patient patient){
        return new Diagnose();
    }
}
