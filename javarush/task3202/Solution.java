

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();
        if (is != null) {
            InputStreamReader isr = new InputStreamReader(is);
            char[] buff = new char[1024];
            int n;
            while ((n = isr.read(buff)) > 0) {
                sw.write(buff, 0, n);
            }
        }
        return sw;
    }
}