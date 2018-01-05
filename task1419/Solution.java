import java.util.ArrayList;
import java.util.List;

/*
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

        try {
            int[] x = new int[10];
            x[11] = 1;
        } catch (Exception e) {
            exceptions.add(e);
        }

        exceptions.add(new InterruptedException());
        exceptions.add(new NoSuchFieldException());
        exceptions.add(new CloneNotSupportedException());
        exceptions.add(new ClassNotFoundException());
        exceptions.add(new NumberFormatException());
        exceptions.add(new NullPointerException());
        exceptions.add(new StringIndexOutOfBoundsException());

        //exceptions.add(new UserNotFoundException());

        try {
            throw new UserNotFoundException("Отошёл на 5 минут");
        } catch (UserNotFoundException e) {
            //System.out.println(e.getMessage());
            exceptions.add(e);
        }

    }

    public static class UserNotFoundException extends Exception {
        public UserNotFoundException() {
            super();
        }
        public UserNotFoundException(String message) {
            super(message);
        }
    }
}
