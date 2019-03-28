package stepik.lesson43283;

import org.junit.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests {

  @Test
  public void test001() throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(baos));

    bw.write("3\n");
    bw.write("apple - malum, pomum, popula\n");
    bw.write("fruit - baca, bacca, popum\n");
    bw.write("punishment - malum, multa\n");

    bw.close();
    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

    Solution.readFlipAndPrint(bais);
  }

  @Test
  public void test002() throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(baos));

    bw.write("3\n");
    bw.write("apple - malum, pomum, popula\n");
    bw.write("fruit - baca, bacca, popum\n");
    bw.write("punishment - malum, multa\n");

    bw.close();
    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

    PrintStream sysOut = System.out;
    baos = new ByteArrayOutputStream();
    PrintStream myOut = new PrintStream(baos);
    System.setOut(myOut);
    Solution.readFlipAndPrint(bais);
    System.setOut(sysOut);

    bais = new ByteArrayInputStream(baos.toByteArray());

    BufferedReader br = new BufferedReader(new InputStreamReader(bais));

    String[] expected = {
        "7",
        "baca - fruit",
        "bacca - fruit",
        "malum - apple, punishment",
        "multa - punishment",
        "pomum - apple",
        "popula - apple",
        "popum - fruit",
    };

    int i = 0;
    String str;
    while ((str = br.readLine()) != null) {
      assertThat(str).isEqualTo(expected[i]);
      i++;
    }

  }

}
