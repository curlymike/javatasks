import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new One());
        threads.add(new Two());
        threads.add(new Three());
        threads.add(new Four());
        threads.add(new Five());
    }

    public static void main(String[] args) {

    }
    //------------
    public static class One extends Thread {
        public void run() {
            while (!isInterrupted()) {
            }
        }
    }
    //------------
    public static class Two extends Thread {
        public void run() {
            while (true) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                    break;
                }
            }
        }
    }
    //------------
    public static class Three extends Thread {
        public void run() {
            try {
                while (!isInterrupted()) {
                    System.out.println("Ура");
                    sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }
    }
    //------------
    public static class Four extends Thread implements Message {
        // Без volatile у меня нить не останавливалась
        protected volatile boolean keepGoing;
        public Four () {
            keepGoing = true;
        }
        public void run() {
            while (keepGoing) {

            }
        }
        public void showWarning() {
            keepGoing = false;
        }
    }
    //------------
    public static class Five extends Thread {
        public void run() {
            BufferedReader cbr = new BufferedReader(new InputStreamReader(System.in));
            try {
                int sum = 0;
                // По какой-то причине while (cbr.ready()) { ... } не работает.
                while (!isInterrupted()) { // throws IOException
                    String line = cbr.readLine();
                    if (line.equals("N")) {
                        break;
                    }
                    try {
                       Integer n = Integer.parseInt(line);
                       sum += n;
                    } catch (NumberFormatException e) {
                        // Ну и фиг с ним, не число и ладно, пропустим.
                    }
                }
                System.out.println(sum);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}