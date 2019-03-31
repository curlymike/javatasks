import java.text.StringCharacterIterator;
import java.util.ArrayList;

/*
Проверка номера телефона
*/
public class Solution {

  public static boolean checkTelNumber(String telNumber) {
    // Check for the usual pitholes.
    // Проверяем обычные ловушки.
    if (telNumber == null || telNumber.length() == 0) {
      return false;
    }
    // Make sure dashes are ok.
    // Проверяем что тире не нарушают условий.
    if (telNumber.matches("--") || countChar('-', telNumber) > 2) {
      return false;
    }
    int numbers = (telNumber.charAt(0) == '+') ? 12 : 10;
    // Replace everything that is not a number, check the length.
    // In other words - check number of digits.
    // Удаляем все что не является цифрой и проверяем длинну строки (в которой остались только цифры).
    // Другими словами - проверяем что количество цифр соответствует условию.
    if (telNumber.replaceAll("\\D+", "").length() != numbers) {
      return false;
    }
    // At this point we know if there are dashes they are ok
    // and the number of digits is correct.
    // На этом этапе мы знаем что чёрточки если есть то не нарушают усливия
    // а так же количество цифр в порядке.
    return telNumber.matches("(^\\+\\d{1}[0-9-]{10,12}\\d+$)|(^\\d{1}[0-9-]{8,10}\\d+$)|(^\\(\\d{3}\\)\\d{1}[0-9-]{5,7}\\d+$)|(^\\+\\d+\\(\\d{3}\\)\\d{1}[0-9-]{5,7}\\d+$)");
  }

  public static void main(String[] args) {
    //test();
  }

  /****
   *
   */

  public static void test() {
    ArrayList<TestVar> samples = new ArrayList<TestVar>();

    samples.add(new TestVar("+380501234567", true));
    samples.add(new TestVar("1234567890", true));
    samples.add(new TestVar("123-4567890", true));
    samples.add(new TestVar("123-456-7890", true));
    samples.add(new TestVar("123-4567890-", false));
    samples.add(new TestVar("-123-4567890", false));
    samples.add(new TestVar("12345678901", false));
    samples.add(new TestVar("+38(050)1234567", true));
    samples.add(new TestVar("+38(50)1234567", false));
    samples.add(new TestVar("+38(50)12345678", false));
    samples.add(new TestVar("(050)1234567", true));
    samples.add(new TestVar("(050)123-4567", true));
    samples.add(new TestVar("(050)123-45-67", true));
    samples.add(new TestVar("(050)12-34-56-7", false));
    samples.add(new TestVar("+38050123-45-67", true));
    samples.add(new TestVar("050123-4567", true));
    samples.add(new TestVar("+38)050(1234567", false));
    samples.add(new TestVar("+38(050)1-23-45-6-7", false));
    samples.add(new TestVar("050ххх4567", false));
    samples.add(new TestVar("050123456", false));
    samples.add(new TestVar("(0)501234567", false));

    int longest = 0;
    for (TestVar test : samples) {
      if (test.str().length() > longest)
        longest = test.str().length();
    }

    for (TestVar test : samples) {
      boolean result = checkTelNumber(test.str());
      System.out.printf("%" + longest + "s %5s %s %n", test.str(), result, (result == test.test() ? "pass" : "error"));
    }

  }

  /****
   * Helper function
   */

  public static int countChar(char chr, String str) {
    StringCharacterIterator sci = new StringCharacterIterator(str);
    int count = 0;
    char c = sci.current();
    while (c != StringCharacterIterator.DONE) {
      c = sci.next();
      if (c == chr) {
        count++;
      }
    }
    return count;
  }

  /****
   *
   */

  public static class TestVar {
    protected String str;
    protected boolean test;
    public TestVar(String str, boolean test) {
      this.str = str;
      this.test = test;
    }
    public String str() {
      return this.str;
    }
    public boolean test() {
      return this.test;
    }
  }

}
