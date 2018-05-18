package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {
    private int rublesInDollar;
    private int rublesInEuro;

    /**
     * When creating the Converter object,
     * pass up-to-date currency rates to constructor.
     * First rubles in dollar, second rubles in euro.
     *
     * @param rublesInDollar
     * @param rublesInEuro
     */
    public Converter(int rublesInDollar, int rublesInEuro) {
        this.rublesInDollar = rublesInDollar;
        this.rublesInEuro = rublesInEuro;
    }

    /**
     * Конвертируем рубли в евро.
     *
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / this.rublesInEuro;
    }

    /**
     * Конвертируем рубли в доллары.
     *
     * @param value рубли.
     * @return Доллоры
     */
    public int rubleToDollar(int value) {
        return value / this.rublesInDollar;
    }

    /**
     * Concert dollar to rubles.
     *
     * @param value
     * @return
     */
    public int dollarToRuble(int value) {
        return value * rublesInDollar;
    }

    /**
     * Convert euro to rubles.
     *
     * @param value
     * @return
     */
    public int euroToRuble(int value) {
        return value * rublesInEuro;
    }

}
