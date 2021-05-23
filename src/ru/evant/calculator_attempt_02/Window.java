package ru.evant.calculator_attempt_02;

/*
    Ошибка(Операции): 2две операции подряд
    Ошибка(Операции): 1+1-1=0
 */

/* Окно программы */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Window extends JFrame implements WindowListener, ActionListener {

    private final TextField inputTextField = new TextField();        // Текстовое поле ввода данных
    private final TextField outputTextField = new TextField();       // Текстовое поле вывода результата

    private final StringBuilder textResult = new StringBuilder();   // Конструктор строки
    private String text = "";                                       // пустая строка
    private String tmp = "";                                        // временная строка

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
    private double B = 0;
    private double dResult = 0; // результат - вещественное число
    private long iResult = 0;    // результат - целое число
    private char op;            // оператор (+, -, *, / ...)

    /* + Главное окно программы */
    public Window() {
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
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Нажатие на крестик закрывает программу

        /* + Текстовые поля */
        configTextField(inputTextField, 265, 60, 10, 10, font, true, true);
        configTextField(outputTextField, 265, 60, 10, 70, font3, true, true);

        /* + Кнопки */
        configButton(percent, 60, 60, 10, 490, font2, true);
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
        configButton(change, 60, 60, 10, 140, font3, true);
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

    /* + обработчик событий */
    @Override
    public void actionPerformed(ActionEvent e) {
        /* +  Цифры */
        numberButtonListener(e);

        /* + Операции */
        operationButtonListener(e);

        /* + Равно */
        calculateButtonListener(e);
    }

    /* + Слушатель кнопок математических операций (Обработка нажатия кнопок: +, -, *, /, ., % и т.д.) */
    private void operationButtonListener(ActionEvent e) {
        /* + C - Clear - Очистить все поля */
        if (e.getSource() == clear) {
            textResult.setLength(0);    // Очистка строки
            text = "";                  // Очистка строки
            addInString(text, textResult.toString());
        }

        /* + Изменить знак числа (+/-) (5 = -5, и наоборот -5 = 5) */
        if (e.getSource() == change) {
            /* если строка не пустая, то выполняем операцию, иначе ничеги ни делаем */
            if(textResult.length() != 0) {
                A = Double.parseDouble(text);
                A *= -1;
                textResult.setLength(0);
                text = String.valueOf(A);
                addInString(text, text);
            }
        }

        /* + Процент (%) (100% = 1 (100/100=1)) */
        if (e.getSource() == percent) {
            if(textResult.length() != 0) {
                A = Double.parseDouble(text);
                A /= 100;
                textResult.setLength(0);
                text = String.valueOf(A);
                addInString(text, text);
            }
        } // процент ( 10% от 100 = 10)

        /* + Точка */
        if (e.getSource() == point) {
            /* еслив строке нет символа точка (.) мы добавляем точку в строку, иначе ничего ни делаем */
            if(text.indexOf('.') == -1) {
                text = text + point.getText();
                addInString(text, point.getText());
            }
        }

        /* + Backspace - удалить последний введенный символ */
        if (e.getSource() == bac) {
            if(textResult.length() != 0) {
                text = deleteLastSymbol(text);
                int lastChar = textResult.length() - 1;
                textResult.deleteCharAt(lastChar);          // удалить последний символ в строке
                addInString(text, "");
            }
        }

        /* + Сложение */
        if (e.getSource() == add) {
            if(textResult.length() != 0) {
                tmp = textResult.toString();
                if (tmp.indexOf('+') != -1) {
                    B = Double.parseDouble(text); // Преобразовать тект в число B
                    dResult = A + B;
                    printResult();
                }
                A = Double.parseDouble(text); // перевести строку в число и присвоить полученное значение переменной A
                inputTextField.setText(text + add.getText());
                text = "";
                op = '+';
                textResult.append("+");
                outputTextField.setText(textResult.toString());
            }
        }

        /* + Вычитание */
        if (e.getSource() == sub) {
            if(textResult.length() != 0) {
                tmp = textResult.toString();
                if (tmp.indexOf('-') != -1) {
                    B = Double.parseDouble(text);
                    dResult = A - B;
                    printResult();
                }
                A = Double.parseDouble(text); // перевести строку в число и присвоить полученное значение переменной A
                inputTextField.setText(text + sub.getText());
                text = "";
                op = '-';
                textResult.append("-");
                outputTextField.setText(textResult.toString());
            }
        }

        /* + Умножение */
        if (e.getSource() == mul) {
            if(textResult.length() != 0) {
                tmp = textResult.toString();
                if (tmp.indexOf('*') != -1) {
                    B = Double.parseDouble(text);
                    dResult = A * B;
                    printResult();
                }
                A = Double.parseDouble(text); // перевести строку в число и присвоить полученное значение переменной A
                inputTextField.setText(text + mul.getText());
                text = "";
                op = '*';
                textResult.append("*");
                outputTextField.setText(textResult.toString());
            }
        }

        /* + Деление */
        if (e.getSource() == div) {
            if(textResult.length() != 0) {
                tmp = textResult.toString();
                if (tmp.indexOf('/') != -1) {
                    B = Double.parseDouble(text);
                    if (B != 0) {
                        dResult = A / B;
                        printResult();
                    }
                }
                A = Double.parseDouble(text); // перевести строку в число и присвоить полученное значение переменной A
                inputTextField.setText(text + div.getText());
                text = "";
                op = '/';
                textResult.append("/");
                outputTextField.setText(textResult.toString());
            }
        }
    }

    /* + Слушатель кнопок цифр (Обработка нажатия кнопок цифр) */
    private void numberButtonListener(ActionEvent e) {
        if (e.getSource() == b0) {
            text = text + b0.getText();
            addInString(text, b0.getText());
        }
        if (e.getSource() == b1) {
            text = text + b1.getText();
            addInString(text, b1.getText());
        }
        if (e.getSource() == b2) {
            text = text + b2.getText();
            addInString(text, b2.getText());
        }
        if (e.getSource() == b3) {
            text = text + b3.getText();
            addInString(text, b3.getText());
        }
        if (e.getSource() == b4) {
            text = text + b4.getText();
            addInString(text, b4.getText());
        }
        if (e.getSource() == b5) {
            text = text + b5.getText();
            addInString(text, b5.getText());
        }
        if (e.getSource() == b6) {
            text = text + b6.getText();
            addInString(text, b6.getText());
        }
        if (e.getSource() == b7) {
            text = text + b7.getText();
            addInString(text, b7.getText());
        }
        if (e.getSource() == b8) {
            text = text + b8.getText();
            addInString(text, b8.getText());
        }
        if (e.getSource() == b9) {
            text = text + b9.getText();
            addInString(text, b9.getText());
        }
    }

    /* + Слушатель кнопки вычислить (это знак равно (=)) */
    private void calculateButtonListener(ActionEvent e) {
        if (e.getSource() == res) {
            //double B; // Число B
            // + сложение
            if (op == '+') {
                B = Double.parseDouble(text); // Преобразовать тект в число B
                dResult = A + B;
                printResult();
            }
            // - вычитание
            if (op == '-') {
                B = Double.parseDouble(text);
                dResult = A - B;
                printResult();
            }
            // * умножение
            if (op == '*') {
                B = Double.parseDouble(text);
                dResult = A * B;
                printResult();
            }
            // / деление
            if (op == '/') {
                B = Double.parseDouble(text);
                if (B != 0) {
                    dResult = A / B;
                    printResult();
                }
            }
            // % процент
            if (op == '%') {
                B = Double.parseDouble(text);
                dResult = B / 100 * A; // 10 % от 100 = 10
                printResult();
            }
        }
    }

    /* Вывести результат */
    private void printResult () {
        checkingForAnInteger();
        setTextToResultField();
    }

    /*
    * Блок
    * если целое число - вывод целого числа (без точки и знаков после точки)
    * иначе - вывод вещественного числа (с точкой и знаками после точки)
    */
    private void checkingForAnInteger (){
        if (dResult % 1 == 0) { // если остаток от деления равен 0
            setTextToTextFieldIfInteger();
        } else {
            setTextToTextFieldIfDouble();
        }
    }


    private void addInString(String text, String builder) {
        textResult.append(builder);         // Добавить в строку новый элемент
        addInInputTextField(text);          // Вывести строку в поле ввода
        addInOutputTextField(textResult);   // Вывести строку в поле вывода
    }

    /* Вывести строку в поле ввода */
    private void addInInputTextField(String text) {
        inputTextField.setText(text);
    }

    /* Вывести строку в поле вывода */
    private void addInOutputTextField(StringBuilder textResult) {
        outputTextField.setText(textResult.toString());
    }

    /* установить текст в текстовое поле (resultText) */
    private void setTextToResultField () {
        textResult.append("=");
        textResult.append(text);
        outputTextField.setText(textResult.toString());
    }

    /* Установить текст в текстовое поле (textField), если результат - это целое число */
    private void setTextToTextFieldIfInteger () {
        iResult = (long) dResult;
        inputTextField.setText(String.valueOf(iResult)); // перевести число в строку и установить строку в текстовое поле
        text = String.valueOf(iResult);
    }

    /* Установить текст в текстовое поле (textField), если результат - это вещественное число */
    private void setTextToTextFieldIfDouble () {
        inputTextField.setText(String.valueOf(dResult)); // перевести число в строку и установить строку в текстовое поле
        text = String.valueOf(dResult);
    }

    /* Удалить последний символ в строке типа String */
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
