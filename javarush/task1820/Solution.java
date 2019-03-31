

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
      //String file1 = "C:\\Temp\\JavaRush_test_files\\task1820.txt";
      //String file2 = "C:\\Temp\\JavaRush_test_files\\task1820-out.txt";

      String file1 = null;
      String file2 = null;

      try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
        file1 = br.readLine();
        file2 = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
        return;
      }

      try (
          InputStreamReader isr = new InputStreamReader(new FileInputStream(file1));
          OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file2))
      ) {
        StringBuilder sb = new StringBuilder();
        char[] buff = new char[1024];
        int n;
        while ((n = isr.read(buff)) > 0) {
          sb.append(buff, 0, n);
        }

        int count = 0;
        for (String str : sb.toString().split("\\s+")) {
          osw.write((count > 0 ? " " : "") + Math.round(Float.parseFloat(str)));
          count++;
        }

      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }


    }
}
