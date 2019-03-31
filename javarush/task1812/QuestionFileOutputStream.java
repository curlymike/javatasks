import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

  AmigoOutputStream amigo;

  public QuestionFileOutputStream(AmigoOutputStream amigo) {
    this.amigo = amigo;
  }

  //------------

  @Override
  public void flush() throws IOException {
    amigo.flush();
  }

  @Override
  public void write(int b) throws IOException {
    amigo.write(b);
  }

  @Override
  public void write(byte[] b) throws IOException {
    amigo.write(b);
  }

  @Override
  public void write(byte[] b, int off, int len) throws IOException {
    amigo.write(b, off, len);
  }

  @Override
  public void close() throws IOException {
    System.out.println("Вы действительно хотите закрыть поток? Д/Н");
    BufferedReader cbr = new BufferedReader(new InputStreamReader(System.in));
    if (cbr.readLine().equals("Д")) {
      amigo.close();
    }
  }
}

