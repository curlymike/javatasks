
// Не проходит пункты:
// Первую половину байт из первого файла нужно записать во второй файл.
// Вторую половину байт из первого файла нужно записать в третий файл.

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

      cbr.close();

      if (file1.length() == 0 || file2.length() == 0 || file3.length() == 0) {
        System.out.println("Error");
        return;
      }

      FileInputStream fis1 = new FileInputStream(file1);
      FileOutputStream fos2 = new FileOutputStream(file2);
      FileOutputStream fos3 = new FileOutputStream(file3);

      File fileIn = new File(file1);
      long len = fileIn.length();
      long bytes3 = len / 2;
      long bytes2 = len - bytes3;

      int count = 0;
      while (fis1.available() > 0) {
        if (count < bytes2)
          fos2.write(fis1.read());
        else
          fos3.write(fis1.read());
        count++;
      }

      fis1.close();
      fos2.close();
      fos3.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
