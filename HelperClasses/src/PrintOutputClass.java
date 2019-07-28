import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class PrintOutputClass {
  private BufferedWriter bufferedWriter;

  public PrintOutputClass() {
    this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public void print(Object object) throws IOException {
    bufferedWriter.append("" + object);
  }

  public void println(Object object) throws IOException {
    print(object);
    bufferedWriter.append("\n");
  }

  public void close() throws IOException {
    bufferedWriter.close();
  }
}
