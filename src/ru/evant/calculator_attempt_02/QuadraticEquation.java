package ru.evant.calculator_attempt_02;

/*
 * Автор: Евсеев Антон
 * Создано:27 мая 2021 года
 */

/*
 * Класс создан для решения квадратных уравнений, типа
 * Ax² + Bx + C = 0
 *
 *
 * Ход выполнения задачи:
 * 1. Получить данные от пользователя, значения переменных - A, B и С
 * 2. Вычислить Дискриминант -> D = b² − 4ac
 * 3. Решить уравнение
 * 3.1. если D < 0 -> Уравнение не имеет решений
 * 3.2. если D = 0 -> Уравнение имеет один корень ->  x = -b / 2a
 * 3.3. если D > 0 -> Уравнение имеет  два кореня -> x1 = (-b - √D) / (2a)
 * -> x2 = (-b - √D) / (2a)
 * 4. Вывести результат
 */

// Ошибки:
//  Реализовать проверку ввода пользователя (если пользователь ввел не число)

import jdk.jshell.SourceCodeAnalysis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import static ru.evant.calculator_attempt_02.Check.*;

public class QuadraticEquation extends JFrame implements WindowListener, ActionListener, KeyListener {

    private final TextField textTitle = new TextField();     // Текстовое поле ввода данных
    private final TextField outputTextField = new TextField();       // Текстовое поле вывода результата

    private final JButton b0 = new JButton("0");          // 0
    private final JButton point = new JButton(".");       // запятая
    private final JButton b1 = new JButton("1");          // 1
    private final JButton b2 = new JButton("2");          // 2
    private final JButton b3 = new JButton("3");          // 3
    private final JButton b4 = new JButton("4");          // 4
    private final JButton b5 = new JButton("5");          // 5
    private final JButton b6 = new JButton("6");          // 6
    private final JButton b7 = new JButton("7");          // 7
    private final JButton b8 = new JButton("8");          // 8
    private final JButton b9 = new JButton("9");          // 9
    private final JButton clear = new JButton("C");       // очистить поле ввода
    private final JButton mul = new JButton("X");         // mul - multiplication - умножение
    private final JButton div = new JButton("/");         // div - division       - деление
    private final JButton bac = new JButton("<<");        // bac - backspace      - удалить последний символ
    private final JButton sub = new JButton("-");         // sub - subtraction    - вычитание
    private final JButton add = new JButton("+");         // add - addition       - сложение
    private final JButton res = new JButton("=");         // res - result         - результат


    /*
     * Объявить ссылочные перменные строкового типа, тип - String.
     * Которые будут инициализированы в процессе выполнения программы.
     * Необходимые для вывода данных
     */

    private String equation; // уравнение
    private String sectionA, sectionB, section3; // математический оператор (+ или -)
    private String dD; // дискриминант


/* конструктор */
    QuadraticEquation(){
        /* + Шрифты */
        Font font = new Font("Impact", Font.BOLD, 40); // шрифт, жирный, размер
        Font font2 = new Font("Impact", Font.BOLD, 35);// шрифт, жирный, размер
        Font font3 = new Font("Impact", Font.BOLD, 15);// шрифт, жирный, размер

        /* + Окно программы */
        setLayout(null);
        setSize(305, 600);         // размер окна
        setVisible(true);                        // отобразить на экране
        setResizable(false);                     // запретить игменять размер окна
        setLocation(300, 150);             // Расположение окна
        setDefaultCloseOperation(QuadraticEquation.DISPOSE_ON_CLOSE); // Нажатие на крестик окно

        /* Текстовые поля */
        configTextField(textTitle, 265, 60, 10, 10, font, true, true);
        configTextField(outputTextField, 265, 60, 10, 70, font3, true, true);

        /* Кнопки */
        configButton(b0, 60, 60, 80, 490, font, true);
        configButton(point, 60, 60, 150, 490, font, true);
        configButton(b1, 60, 60, 10, 420, font, true);
        configButton(b2, 60, 60, 80, 420, font, true);
        configButton(b3, 60, 60, 150, 420, font, true);
        configButton(b4, 60, 60, 10, 350, font, true);
        configButton(b5, 60, 60, 80, 350, font, true);
        configButton(b6, 60, 60, 150, 350, font, true);
        configButton(b7, 60, 60, 10, 280, font, true);
        configButton(b8, 60, 60, 80, 280, font, true);
        configButton(b9, 60, 60, 150, 280, font, true);
        configButton(clear, 60, 60, 10, 210, font, true);
        configButton(mul, 60, 60, 80, 210, font, true);
        configButton(div, 60, 60, 150, 210, font, true);
        configButton(bac, 60, 60, 220, 210, font3, true);
        configButton(sub, 60, 60, 220, 280, font, true);
        configButton(add, 60, 60, 220, 350, font, true);
        configButton(res, 60, 130, 220, 420, font, true);
    }

    /* + настройка текстового поля */
    public void configTextField(TextField name, int width, int height, int xPosition, int yPosition, Font font, boolean visible, boolean editable) {
        name.setSize(width, height);            // размер текстового поля
        name.setLocation(xPosition, yPosition); // позиция текстового поля в окне
        name.setFont(font);                     // установить шрифт
        name.setVisible(visible);               // видимость (да/нет)
        name.setEditable(editable);             // редактируемое поле (да/нет)
        add(name);                              // добавить в окно
    }

    /* + настройка кнопки */
    public void configButton(JButton name, int width, int height, int xPosition, int yPosition, Font font, boolean visible) {
        name.setSize(width, height);            // размер кнопки
        name.setLocation(xPosition, yPosition); // позиция кнопки в окне
        name.setFont(font);                     // шрифт
        name.setVisible(visible);               // видимость (да/нет)
        add(name);                              // добавить в окно
        name.addActionListener(this);        // подключить к обработчику событий
    }

    /* Ход выполнения программы */
    public void start() {






        /*
          Объявить переменные для хранения вещественных чисел, тип переменных - double.
          Необходимые для вычислений
         */
        double a, b, c, D, x, x1, x2;

        /*
          Объявить и инициализировать ссылочные перменные строкового типа, тип - String.
          Которые ссылаются на строки указанные в "".
          Необходимые для ввода и вывода данных
         */
        final String formula = "Решение квадратных уравнений, типа:\n    Ax² + Bx + C = 0";
        final String enterValueA = "Введите число, значение переменной А:\n>: ";
        final String enterValueB = "Введите число, значение переменной B:\n>: ";
        final String enterValueC = "Введите число, значение переменной C:\n>: ";
        final String dNegative = "Уравнение не имеет корней!";
        final String dZeroX = "Уравнение имеет один корень.\nx = ";
        final String dPositiveX1 = "Уравнение имеет два кореня.\nx1 = ";
        final String dPositiveX2 = "x2 = ";

        System.out.println(formula);      // вывод в консоль. формула

        /* 1. Получить данные от пользователя */

        /* A */
        System.out.print(enterValueA);  // вывод в консоль. запрос данных
        a = getUserInput(); // получить данные введенные пользователем и присвоить их переменной a
        // Проверить поле ввода, если не пустое выполняем код далее, иначе присваиваем переменной значение 1
        int aInt = (int) a;
        if (isNotEmpty(a)) {
            //  if (Check.possibleDoubleToInt(a)) a = (int) a;
            /* проверка на знак оператора + или -, или равенство нулю */
            if (isPositive(a)) {
                sectionA = "" + a + "x²";
            }
            if (possibleDoubleToInt(a)) {
                sectionA = "" + aInt + "x²";
            } // если переменная "a" - целое число, привести переменную "а" к типу int
            if (isPositive(a) && compareTwoNumbers(a, 1)) {
                sectionA = "x²";
            }
            if (isZero(a)) {
                sectionA = "";
            }
            if (isNegative(a)) {
                sectionA = "" + a + "x²";
                if (possibleDoubleToInt(a)) {
                    sectionA = "" + aInt + "x²";
                } // если переменная "a" - целое число, привести переменную "а" к типу int
            }
        } else {
            a = 1;
            sectionA = "x² ";
        }

        /* B */
        System.out.print(enterValueB);  // вывод в консоль. запрос данных
        b = getUserInput(); // получить данные введенные пользователем и присвоить их переменной b
        int bInt = (int) b;
        if (isNotEmpty(b)) {
            if (isPositive(b)) {
                sectionB = "+" + b + "x";
            }
            if (possibleDoubleToInt(b)) {
                sectionB = "+" + bInt + "x";
            } // к int
            if (isPositive(b) && compareTwoNumbers(b, 1)) {
                sectionB = "+x";
            }
            if (isZero(b)) {
                sectionB = "";
            }
            if (isNegative(b)) {
                sectionB = "" + b + "x";
                if (possibleDoubleToInt(b)) {
                    sectionB = "" + bInt + "x";
                } // к int
            }
        } else {
            b = 1;
            sectionB = "+x";
        }

        /* C */
        System.out.print(enterValueC);  // вывод в консоль. запрос данных
        c = getUserInput(); // получить данные введенные пользователем и присвоить их переменной c
        int cInt = (int) c;
        if (isNotEmpty(c)) {
            if (isPositive(c)) {
                section3 = "+" + c + "=0";
            }
            if (possibleDoubleToInt(c)) {
                section3 = "+" + cInt + "=0";
            }
            if (isZero(c)) {
                section3 = "=0";
            }
            if (isNegative(c)) {
                section3 = "" + c + "=0";
                if (possibleDoubleToInt(c)) {
                    section3 = "" + cInt + "=0";
                }
            }
        } else {
            c = 0;
            section3 = "=0";
        }

        if (isZero(a, b, c)) equation = "0 = 0";
        else equation = sectionA + sectionB + section3;

        /* 2. Вычислить Дискриминант */
        if (isZero(a, b, c)) System.out.println(equation);

        if (isZero(a)) {
            /* решить простое уравнение */
            x = -c / b;
            System.out.println(equation);
            System.out.println("x=" + x);
        } else {
            D = Math.pow(b, 2) - 4 * a * c; // Math.pow(b,2) -> использовать метод pow(x, n) класса Math -> pow - возвести число в степень, x - число, n - степень
            int DInt = (int) D;
            if (possibleDoubleToInt(D)) {
                dD = "D = " + DInt;
            } else dD = "D = " + D;

            /* 3. Решить уравнение и 4. Вывести результат*/

            if (isNegative(D)) { /* 3.1. если (if) D < 0 */
                printEquationAndD();
                System.out.println(dNegative);
            } else if (isZero(D)) { /* 3.2. иначе (else) если (if) D = 0 */
                x = ((-1) * b) / (2 * a);
                int xInt = (int) x;
                printEquationAndD();
                if (possibleDoubleToInt(x)) {
                    System.out.println(dZeroX + xInt);
                } else {
                    System.out.println(dZeroX + x);
                }
            } else { /* 3.3. иначе (else) */
                x1 = ((-1) * b - Math.sqrt(D)) / (2 * a); // sqrt(n) -> Корень квадратный из n
                x2 = ((-1) * b + Math.sqrt(D)) / (2 * a);
                int x1Int = (int) x1;
                int x2Int = (int) x2;
                printEquationAndD();
                if (possibleDoubleToInt(x1)){
                    System.out.println(dPositiveX1 + x1Int);
                } else {
                    System.out.println(dPositiveX1 + x1);
                }
                if (possibleDoubleToInt(x2)){
                    System.out.println(dPositiveX2 + x2Int);
                } else {
                    System.out.println(dPositiveX2 + x2);
                }
            }
        }
    } // end method solveQuadraticEquation()

    /* Вывести уравнение и дискриминант */
    public void printEquationAndD() {
        System.out.println(equation);
        System.out.println(dD);
    } // end method printEquationAndD()


    /* Получить данные от пользователя */
    public double getUserInput() {
        Scanner userInput = new Scanner(System.in);
        double num = 0;
        if (userInput.hasNextDouble()) {
            num = userInput.nextDouble();
        } else {
            getUserInput();
        }
        return num;
    }






    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
