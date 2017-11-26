import java.io.*;
import java.nio.charset.Charset;

/*
Смена кодировки
*/
public class Solution {
  public static void main(String[] args) throws IOException {

    String fileIn = args[0];
    String fileOut = args[1];

    Charset windows1251 = Charset.forName("Windows-1251");
    Charset UTF8 = Charset.forName("UTF-8");

    try (
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileIn), windows1251);
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(fileOut), UTF8);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw)) {

      while (br.ready()) {
        bw.write(br.readLine());
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
