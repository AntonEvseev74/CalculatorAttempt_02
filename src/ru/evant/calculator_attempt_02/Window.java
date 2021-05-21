package ru.evant.calculator_attempt_02;

/* Окно программы */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Window extends JFrame implements WindowListener, ActionListener {

    private final TextField textField = new TextField();       // текстовое поле
    private final TextField resultText = new TextField(); ////////////////////////////////////////////
    private final StringBuilder textInResultText = new StringBuilder();
    private String text = "";                                  // пустая строка
    private final JButton percent = new JButton("%");     // процент
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
    private final JButton change = new JButton("+/-");    // изменить знак числа - => + или + -> -

    private double A = 0;       // вещественное число
    // private double B = 0;    // вещественное число
    private double dResult = 0; // результат - вещественное число
    private int iResult = 0;    // результат - целое число
    private char op;            // оператор (+, -, *, / ...)

    public Window() {
        Font font = new Font("Impact", Font.BOLD, 40); // шрифт
        Font font2 = new Font("Impact", Font.BOLD, 35); // шрифт
        Font font3 = new Font("Impact", Font.BOLD, 15); // шрифт

        // Окно программы
        setLayout(null);
        setSize(305, 600);         // размер окна
        setVisible(true);                        // отобразить на экране
        setResizable(false);                     // запретить игменять размер окна
        setLocation(300, 150);             // Расположение окна
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Нажатие на крестик закрывает программу

        //////////////////////
        resultText.setSize(265, 60); // размер текстового поля
        resultText.setLocation(10, 70);      // размер текстового поля
        resultText.setFont(font3);                  // установить шрифт
        resultText.setVisible(true);               // отобразить на экране
        resultText.setEditable(false);
        add(resultText);                           // добавить в окно программы

        // Текстовое поле
        textField.setSize(265, 60); // размер текстового поля
        textField.setLocation(10, 10);      // размер текстового поля
        textField.setFont(font);                  // установить шрифт
        textField.setVisible(true);               // отобразить на экране
        add(textField);                           // добавить в окно программы

        // Кнопки
        settingUpButton(percent, 60, 60 , 10, 490, font2, true);
        settingUpButton(b0, 60, 60 , 80, 490, font, true);
        settingUpButton(point, 60, 60 , 150, 490, font, true);
        settingUpButton(b1, 60, 60 , 10, 420, font, true);
        settingUpButton(b2, 60, 60 , 80, 420, font, true);
        settingUpButton(b3, 60, 60 , 150, 420, font, true);
        settingUpButton(b4, 60, 60 , 10, 350, font, true);
        settingUpButton(b5, 60, 60 , 80, 350, font, true);
        settingUpButton(b6, 60, 60 , 150, 350, font, true);
        settingUpButton(b7, 60, 60 , 10, 280, font, true);
        settingUpButton(b8, 60, 60 , 80, 280, font, true);
        settingUpButton(b9, 60, 60 , 150, 280, font, true);
        settingUpButton(clear, 60, 60 , 10, 210, font, true);
        settingUpButton(mul, 60, 60 , 80, 210, font, true);
        settingUpButton(div, 60, 60 , 150, 210, font, true);
        settingUpButton(bac, 60, 60 , 220, 210, font3, true);
        settingUpButton(sub, 60, 60 , 220, 280, font, true);
        settingUpButton(add, 60, 60 , 220, 350, font, true);
        settingUpButton(res, 60, 130 , 220, 420, font, true);
        settingUpButton(change, 60, 60 , 10, 140, font3, true);
    }

    /* настройки кнопки */
    public void settingUpButton(JButton name, int width, int height, int xPosition, int yPosition, Font font, boolean visible) {
        name.setSize(width, height);            // размер кнопки
        name.setLocation(xPosition, yPosition); // позиция кнопки в окне
        name.setFont(font);                     // шрифт
        name.setVisible(visible);               // видимость (да/нет)
        add(name);                              // добавить в окно
        name.addActionListener(this);        // подключить к обработчику событий
    }

    // обработчик событий
    @Override
    public void actionPerformed(ActionEvent e) {

        // Цифры
        if (e.getSource() == b0) {
            text = text + b0.getText();
            textField.setText(text);
            textInResultText.append(text);
            resultText.setText(textInResultText.toString());
        }
        if (e.getSource() == b1) {
            text = text + b1.getText();
            textField.setText(text);
            textInResultText.append(text);
            resultText.setText(textInResultText.toString());
        }
        if (e.getSource() == b2) {
            text = text + b2.getText();
            textField.setText(text);
            textInResultText.append(text);
            resultText.setText(textInResultText.toString());
        }
        if (e.getSource() == b3) {
            text = text + b3.getText();
            textField.setText(text);
            textInResultText.append(text);
            resultText.setText(textInResultText.toString());
        }
        if (e.getSource() == b4) {
            text = text + b4.getText();
            textField.setText(text);
            textInResultText.append(text);
            resultText.setText(textInResultText.toString());
        }
        if (e.getSource() == b5) {
            text = text + b5.getText();
            textField.setText(text);
            textInResultText.append(text);
            resultText.setText(textInResultText.toString());
        }
        if (e.getSource() == b6) {
            text = text + b6.getText();
            textField.setText(text);
            textInResultText.append(text);
            resultText.setText(textInResultText.toString());
        }
        if (e.getSource() == b7) {
            text = text + b7.getText();
            textField.setText(text);
            textInResultText.append(text);
            resultText.setText(textInResultText.toString());
        }
        if (e.getSource() == b8) {
            text = text + b8.getText();
            textField.setText(text);
        }
        if (e.getSource() == b9) {
            text = text + b9.getText();
            textField.setText(text);
            textInResultText.append(text);
            resultText.setText(textInResultText.toString());
        }
        if (e.getSource() == clear) {
            text = "";
            textField.setText(text);
            textInResultText.setLength(0);//append(text);
            resultText.setText(textInResultText.toString());
        }

        // операции
        if (e.getSource() == change) {
            textInResultText.append(text);
            resultText.setText(textInResultText.toString());
            A = Double.parseDouble(text);
            A *= -1;
            if (A % 1 == 0) {
                iResult = (int) A;
                textField.setText(String.valueOf(iResult));
                text = String.valueOf(iResult);
            } else {
                dResult = A;
                textField.setText(String.valueOf(dResult)); // перевести число в строку и установить строку в текстовое поле
                text = String.valueOf(dResult);
            }
            textInResultText.setLength(0); // доработать
            textInResultText.append(text);
            resultText.setText(textInResultText.toString());
        } // изменить + на - и наоборот
        if (e.getSource() == percent) {
            // написать код
            A = Double.parseDouble(text); // перевести строку в число и присвоить полученное значение переменной A
            textField.setText(text + percent.getText());
            text = "";
            op = '%';
        } // процент ( 10% от 100 = 10)
        if (e.getSource() == point) {
            text = text + point.getText();
            textField.setText(text);
        } // точка
        if (e.getSource() == bac) {
            text = deleteLastSymbol(text);
            textField.setText(text);
        } // bac - backspace - удалить последний символ
        if (e.getSource() == add) {
            A = Double.parseDouble(text); // перевести строку в число и присвоить полученное значение переменной A
            textField.setText(text + add.getText());
            text = "";
            op = '+';
            textInResultText.append("+");
            resultText.setText(textInResultText.toString());
        } // add - сложение
        if (e.getSource() == sub) {
            A = Double.parseDouble(text); // перевести строку в число и присвоить полученное значение переменной A
            textField.setText(text + sub.getText());
            text = "";
            op = '-';
            textInResultText.append("-");
            resultText.setText(textInResultText.toString());
        } // sub - вычитание
        if (e.getSource() == mul) {
            A = Double.parseDouble(text); // перевести строку в число и присвоить полученное значение переменной A
            textField.setText(text + mul.getText());
            text = "";
            op = '*';
            textInResultText.append("*");
            resultText.setText(textInResultText.toString());
        } // mul - умножение
        if (e.getSource() == div) {
            A = Double.parseDouble(text); // перевести строку в число и присвоить полученное значение переменной A
            textField.setText(text + div.getText());
            text = "";
            op = '/';
            textInResultText.append("/");
            resultText.setText(textInResultText.toString());
        } // div - деление


        calculate(e);
    }

    // метод реализущий работу знака равно
    private void calculate(ActionEvent e) {

        if (e.getSource() == res) {
            double B;
            // + сложение
            if (op == '+') {
                B = Double.parseDouble(text);
                dResult = A + B;
                if (dResult % 1 == 0) { // если остаток от деления равен 0
                    iResult = (int) dResult;
                    textField.setText(String.valueOf(iResult)); // перевести число в строку и установить строку в текстовое поле
                    text = String.valueOf(iResult);
                } else {
                    textField.setText(String.valueOf(dResult)); // перевести число в строку и установить строку в текстовое поле
                    text = String.valueOf(dResult);
                }
                textInResultText.append("=");
                textInResultText.append(text);
                resultText.setText(textInResultText.toString());
            }
            // - вычитание
            if (op == '-') {
                B = Double.parseDouble(text);
                dResult = A - B;
                if (dResult % 1 == 0) { // если остаток от деления равен 0
                    iResult = (int) dResult;
                    textField.setText(String.valueOf(iResult)); // перевести число в строку и установить строку в текстовое поле
                    text = String.valueOf(iResult);
                } else {
                    textField.setText(String.valueOf(dResult)); // перевести число в строку и установить строку в текстовое поле
                    text = String.valueOf(dResult);
                }
                textInResultText.append("=");
                textInResultText.append(text);
                resultText.setText(textInResultText.toString());
            }
            // * умножение
            if (op == '*') {
                B = Double.parseDouble(text);
                dResult = A * B;
                if (dResult % 1 == 0) { // если остаток от деления равен 0
                    iResult = (int) dResult;
                    textField.setText(String.valueOf(iResult)); // перевести число в строку и установить строку в текстовое поле
                    text = String.valueOf(iResult);
                } else {
                    textField.setText(String.valueOf(dResult)); // перевести число в строку и установить строку в текстовое поле
                    text = String.valueOf(dResult);
                }
                textInResultText.append("=");
                textInResultText.append(text);
                resultText.setText(textInResultText.toString());
            }
            // / деление
            if (op == '/') {
                B = Double.parseDouble(text);
                dResult = A / B;
                if (dResult % 1 == 0) { // если остаток от деления равен 0
                    iResult = (int) dResult;
                    textField.setText(String.valueOf(iResult)); // перевести число в строку и установить строку в текстовое поле
                    text = String.valueOf(iResult);
                } else {
                    textField.setText(String.valueOf(dResult)); // перевести число в строку и установить строку в текстовое поле
                    text = String.valueOf(dResult);
                }
                textInResultText.append("=");
                textInResultText.append(text);
                resultText.setText(textInResultText.toString());
            }
            // % процент
            if (op == '%') {
                B = Double.parseDouble(text);
                dResult = B / 100 * A; // 10 % от 100 = 10
                if (dResult % 1 == 0) { // если остаток от деления равен 0
                    iResult = (int) dResult;
                    textField.setText(String.valueOf(iResult)); // перевести число в строку и установить строку в текстовое поле
                    text = String.valueOf(iResult);
                } else {
                    textField.setText(String.valueOf(dResult)); // перевести число в строку и установить строку в текстовое поле
                    text = String.valueOf(dResult);
                }
                textInResultText.append("=");
                textInResultText.append(text);
                resultText.setText(textInResultText.toString());
            }
        }
    }

    // метод удалить последний символ в строке
    private String deleteLastSymbol(String str) {
        return str.substring(0, str.length() - 1);
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
} // end Window
