
/* 
Разделение файла
*/

import java.io.*;

public class Solution {
  public static void main(String[] args) {

    BufferedReader cbr = new BufferedReader(new InputStreamReader(System.in));

    try {
      String file1 = "";
      String file2 = "";
      String file3 = "";

      file1 = cbr.readLine();
      file2 = cbr.readLine();
      file3 = cbr.readLine();

//      file1 = "C:\\Temp\\JavaRush_test_files\\task1808.txt";
//      file2 = "C:\\Temp\\JavaRush_test_files\\task1808-n2.txt";
//      file3 = "C:\\Temp\\JavaRush_test_files\\task1808-n3.txt";

//      cbr.close();

      if (file1.length() == 0 || file2.length() == 0 || file3.length() == 0) {
        System.out.println("Error");
        return;
      }

      FileInputStream fis = new FileInputStream(file1);
      FileOutputStream fos1 = new FileOutputStream(file2);
      FileOutputStream fos2 = new FileOutputStream(file3);

      int half = fis.available() / 2;
      int available = 0;
      while ((available = fis.available()) > 0) {
        if (available > half)
          fos1.write(fis.read());
        else
          fos2.write(fis.read());
      }

      fis.close();
      fos1.close();
      fos2.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
