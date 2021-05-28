package ru.evant.calculator_attempt_02;

/*
 * Автор: Евсеев Антон
 * Создано:27 мая 2021 года
 */

/**
 * Класс содержит boolean методы различных проверок
 */

public class Check {

    /**
     * Проверить инициализирована ли числовая переменная
     * Если переменная не инициализирована, то при приведении переменной числового типа к типу String, значение  длинны строки не может быть равно 0
     * Следовательно. Нужно:
     * Передать в метод проверяемую переменную.
     * Привести ее к типу String
     * Проверить равна ли длинна строки нулю.
     * Метод возвращает:
     * true - если переменная проинициализирована
     * false - если переменная не проинициализирована
     * <p>
     * Переменная типа String может быть проинициализирована
     * Этим методом мы можем лишь проверить, пустая ли строка.
     * true - строка пустая
     * false - в строке содержатся символы
     */
    public static boolean isNotEmpty(char n) {
        return String.valueOf(n).length() != 0;
    }

    public static boolean isNotEmpty(byte n) {
        return String.valueOf(n).length() != 0;
    }

    public static boolean isNotEmpty(short n) {
        return String.valueOf(n).length() != 0;
    }

    public static boolean isNotEmpty(int n) {
        return String.valueOf(n).length() != 0;
    }

    public static boolean isNotEmpty(long n) {
        return String.valueOf(n).length() != 0;
    }

    public static boolean isNotEmpty(double n) {
        return String.valueOf(n).length() != 0;
    }

    public static boolean isNotEmpty(String n) {
        return n.length() != 0;
    }


    /**
     * Проверить равно ли число нулю (0)
     * Возвращает:
     * true - если переменная равна нулю
     * false - если переменная не равна нулю
     */
    public static boolean isZero(char n) {
        return n == 0;
    }

    public static boolean isZero(byte n) {
        return n == 0;
    }

    public static boolean isZero(short n) {
        return n == 0;
    }

    public static boolean isZero(int n) {
        return n == 0;
    }

    public static boolean isZero(long n) {
        return n == 0;
    }

    public static boolean isZero(double n) {
        return n == 0;
    }

    /**
     * Проверить равны ли 3 числа нулю (0)
     * Возвращает:
     * true - если равны нулю
     * false - если не равны нулю
     */
    public static boolean isZero(char n1, char n2, char n3) {
        return n1 == 0 && n2 == 0 && n3 == 0;
    }

    public static boolean isZero(byte n1, byte n2, byte n3) {
        return n1 == 0 && n2 == 0 && n3 == 0;
    }

    public static boolean isZero(short n1, short n2, short n3) {
        return n1 == 0 && n2 == 0 && n3 == 0;
    }

    public static boolean isZero(int n1, int n2, int n3) {
        return n1 == 0 && n2 == 0 && n3 == 0;
    }

    public static boolean isZero(long n1, long n2, long n3) {
        return n1 == 0 && n2 == 0 && n3 == 0;
    }

    public static boolean isZero(double n1, double n2, double n3) {
        return n1 == 0 && n2 == 0 && n3 == 0;
    }


    /**
     * Проверить равны ли два числа
     * То есть равно ли число n1 числу n2
     * Возвращает:
     * true - если переменные n1 и n2 равны
     * false - если переменные n1 и n2 не равны
     */
    public static boolean compareTwoNumbers(char n1, char n2) {
        return n1 == n2;
    }

    public static boolean compareTwoNumbers(byte n1, byte n2) {
        return n1 == n2;
    }

    public static boolean compareTwoNumbers(short n1, short n2) {
        return n1 == n2;
    }

    public static boolean compareTwoNumbers(int n1, int n2) {
        return n1 == n2;
    }

    public static boolean compareTwoNumbers(long n1, long n2) {
        return n1 == n2;
    }

    public static boolean compareTwoNumbers(double n1, double n2) {
        return n1 == n2;
    }


    /**
     * Проверить равны ли три числа
     * То есть равно ли число n1 числу n2 и числу n3
     * Возвращает:
     * true - если переменные n1, n2 и n3 равны
     * false - если переменные n1, n2 и n3 не равны
     */
    public static boolean compareThreeNumbers(char n1, char n2, char n3) {
        return n1 == n2 && n1 == n3;
    }

    public static boolean compareThreeNumbers(byte n1, byte n2, byte n3) {
        return n1 == n2 && n1 == n3;
    }

    public static boolean compareThreeNumbers(short n1, short n2, short n3) {
        return n1 == n2 && n1 == n3;
    }

    public static boolean compareThreeNumbers(int n1, int n2, int n3) {
        return n1 == n2 && n1 == n3;
    }

    public static boolean compareThreeNumbers(long n1, long n2, long n3) {
        return n1 == n2 && n1 == n3;
    }

    public static boolean compareThreeNumbers(double n1, double n2, double n3) {
        return n1 == n2 && n1 == n3;
    }


    /**
     * Проверить отрицательное ли число
     * true - отрицательное
     * false - нет
     */
    public static boolean isNegative(byte n) {
        return n < 0;
    }

    public static boolean isNegative(short n) {
        return n < 0;
    }

    public static boolean isNegative(int n) {
        return n < 0;
    }

    public static boolean isNegative(long n) {
        return n < 0;
    }

    public static boolean isNegative(float n) {
        return n < 0;
    }

    public static boolean isNegative(double n) {
        return n < 0;
    }


    /**
     * Проверить положительное число ли число
     * true - положительное
     * false - нет
     */

    public static boolean isPositive(byte n) {
        return n > 0; // если n = 0, вернуть true
    } // end method isPositive(double n)

    public static boolean isPositive(short n) {
        return n > 0; // если n = 0, вернуть true
    } // end method isPositive(double n)

    public static boolean isPositive(int n) {
        return n > 0; // если n = 0, вернуть true
    } // end method isPositive(double n)

    public static boolean isPositive(long n) {
        return n > 0; // если n = 0, вернуть true
    } // end method isPositive(double n)

    public static boolean isPositive(double n) {
        return n > 0; // если n = 0, вернуть true
    } // end method isPositive(double n)


    /**
     * Проверить тип переменной
     */
    public static boolean isByte(Byte n) {
        return n instanceof Byte;
    }

    public static boolean isShort(Short n) {
        return n instanceof Short;
    }

    public static boolean isInt(Integer n) {
        return n instanceof Integer;
    }

    public static boolean isLong(Long n) {
        return n instanceof Long;
    }

    public static boolean isFloat(Float n) {
        return n instanceof Float;
    }

    public static boolean isDouble(Double n) {
        return n instanceof Double;
    }

    /**
     * Проверить можно ли конвертировать тип double в тип int
     */
    public static boolean possibleDoubleToInt(double n) {
        return isIntegerNumber(n);
    }

    /**
     * Проверить число, целое или нет
     */
    public static boolean isIntegerNumber(double n) {
        return n % 1 == 0;
    }

} //end class
