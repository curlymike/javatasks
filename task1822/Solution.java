

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        
        String fileName = null;

        //fileName = "C:\\Temp\\JavaRush_test_files\\task1822.txt";
        //String id = "15";
        
        String id = args[0];

        try (BufferedReader cbr = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = cbr.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            Pattern p = Pattern.compile("^(\\d+)\\s+.*\\s+[^\\s]+\\s+\\d+$");

            while (br.ready()) {
                String line = br.readLine();
                Matcher m = p.matcher(line);
                if (m.matches() && id.equals(m.group(1))) {
                    System.out.println(line);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
