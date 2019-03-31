

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
      String fileName = args[0];
      //String fileName = "C:\\Temp\\JavaRush_test_files\\task1816.txt";
      int count = 0;
      try (InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName))) {
        while (isr.ready()) {
          char ch = (char) isr.read();
          if ("abcdefghijklmnopqrstuvwxyz".indexOf(Character.toLowerCase(ch)) > -1) {
            count++;
          }
        }
        System.out.println(count);

      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
}
