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
                break;
            }
            if (line.indexOf('.') > -1) {
                try {
                    Double n = Double.parseDouble(line);
                    success = true;
                    print(n);
                } catch (NumberFormatException e) {}
            }
            if (!success) {
                try {
                    Integer n = Integer.parseInt(line);
                    success = true;
                    if (n > 0 && n < 128) {
                        print(n.shortValue());
                    } else {
                        print(n);
                    }
                } catch (NumberFormatException e) {}
            }
            if (!success) {
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
