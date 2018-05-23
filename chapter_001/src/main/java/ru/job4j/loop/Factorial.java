package ru.job4j.loop;

public class Factorial {
    /**
     * Returns the factorial of passed number(  n).
     *
     * @param n
     * @return
     */
    public int calc(int n) {
        if (n < 0) throw new IllegalArgumentException();
        else if (n == 0 || n == 1) return 1;
        int result = 1;
        for (int i = 1; i < n + 1; i++) {
            result = result * i;
        }
        return result;
    }

    /*  this is beutiful solution
        public int calc(int n) {
        if (n < 0) throw new IllegalArgumentException();
        else if (n == 0 || n == 1) return 1;
        return n * calc(n - 1);
    }*/
}
