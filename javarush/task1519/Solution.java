import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код

        BufferedReader cbr = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            boolean success = false;
            String line = cbr.readLine();
            if (line.equals("exit")) {
                // Прерываем цикл while.
                break;
            }
            if (line.indexOf('.') > -1) {
                // В строке есть точка, попробуем получить Double.
                try {
                    Double n = Double.parseDouble(line);
                    // Если мы сдесь - это значит, что метод Double.parseDouble()
                    // не выкинул исключение и у нас есть число.
                    success = true;
                    print(n);
                } catch (NumberFormatException e) {
                    // Хоть там и есть точка - это не число.
                }
            }
            if (!success) {
                // Или в строке нет точки или с Double ничего не получилось, попробуем Integer
                try {
                    Integer n = Integer.parseInt(line);
                    // Если мы сдесь - это значит, что метод Integer.parseInt()
                    // не выкинул исключение и у нас есть число типа Integer.
                    success = true;
                    if (n > 0 && n < 128) {
                        // Полученное число больше нуля и меньше 128
                        // по условию задачи мы должны передать это 
                        // число в виде переменной типа short.
                        // Не важно, что тип short может принимать значения
                        // от -32768 до 32767, просто такое условие, главное
                        // что числа от 0 до 128 попадают в этот диапазон.
                        // n - объект типа Integer, метод shortValue()
                        // вернёт значение типа short.
                        print(n.shortValue());
                    } else {
                        // Видимо число меньше либо равно нуля
                        // или больше либо равно 128.
                        print(n);
                    }
                } catch (NumberFormatException e) {
                    // Нет, это не Integer
                }
            }
            if (!success) {
                // Попытки распознать в строке число не привели
                // к успеху передаём параметром саму строку.
                print(line);
            }
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
