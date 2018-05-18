package ru.job4j.calculator;

/**
 * Программа расчета идеального веса.
 * Расчет ведется по следующим формулам:
 * Идеальный вес для мужчин = (рост в сантиметрах – 100) · 1,15.
 * Идеальный вес для женщин = (рост в сантиметрах – 110) · 1,15.
 */
public class Fit {

    /**
     * Идеальный вес для мужщины.
     *
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        return (height - 100D) * 1.15D;
    }

    /**
     * Идеальный вес для женщины.
     *
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        return (height - 110D) * 1.15D;
    }
}