

/* 
Пробелы
*/

import java.io.*;

public class Solution {
  public static void main(String[] args) {

    if (args.length < 1) {
      System.out.println("Error (1)");
      return;
    }

    //String fileName = "C:\\Temp\\JavaRush_test_files\\task1817.txt";
    String fileName = args[0];

    try {
      InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName));
      double charCount = 0;
      double spaceCount = 0;
      int n;
      char[] buff = new char[100];
      
      // Метод read возвращает или количество символов прочитанных
      // в buff или -1 в случае если достигнут конец файла.
      while ((n = isr.read(buff)) != -1) {
        for (int i = 0; i < n; i++) {
          // Если символ - пробел увеличиваем счётчик пробелов.
          if (buff[i] == ' ') {
            spaceCount++;
          }
          // Увеличиваем счётчик символов.
          charCount++;
        }
      }

      //System.out.println("Chars: " + charCount);
      //System.out.println("Spaces: " + spaceCount);

      // На всякий случай надо убедиться, что не будет деления на ноль.
      if (charCount > 0) {
        System.out.printf("%.2f", ((spaceCount / charCount) * 100));
      } else {
        System.out.println("Division by zero.");
      }

      // Закрываем поток. Так аздано в условии.
      isr.close();

    } catch (FileNotFoundException e) {
      System.out.println("Error: file not found.");
      System.out.println("(" + fileName + ")");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
