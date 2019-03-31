import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        // Считать с клавиатуры?
        //firstFileName = "C:\\Temp\\JavaRush_test_files\\task1630-1.txt";
        //secondFileName = "C:\\Temp\\JavaRush_test_files\\task1630-2.txt";

        BufferedReader cbr = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = cbr.readLine();
            secondFileName = cbr.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут

    public static class ReadFileThread extends Thread implements ReadFileInterface {

        protected String fileName;
        protected String fileContents;

        public ReadFileThread() {
            fileContents = "";
        }

        public void setFileName(String fullFileName) {
            fileName = fullFileName;
        }

        public void run() {
            if (fileName != null) {
                StringBuilder sb = new StringBuilder();
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    int i = 0;
                    while (br.ready()) {
                        if (i > 0) {
                            sb.append(" ");
                        }
                        sb.append(br.readLine());
                        i++;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                fileContents = sb.toString();
            }
        }

        public String getFileContent() {
            return fileContents;
        }

    }

}
