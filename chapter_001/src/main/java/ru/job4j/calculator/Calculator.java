package ru.job4j.calculator;

/**
 * Primitive calculator task
 * with four basic funcs: + - / *
 */
public class Calculator {
    private double result;

    public double getResult() {
        return result;
    }

    /**
     * Adds second to first and
     * writes result to this.result field.
     *
     * @param first
     * @param second
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Substracts second from first
     * and writes result to this.result field
     *
     * @param first
     * @param second
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Divides first by second
     * and writes result to this.result field
     *
     * @param first
     * @param second
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Multiplies first and second
     * and writes result to this.result field
     *
     * @param first
     * @param second
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }
}
