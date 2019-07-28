import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class ScanInputClass {
  private byte[] buf = new byte[1024];

  private int total;
  private int index;
  private InputStream in;

  public ScanInputClass() {
    in = System.in;
  }

  public int read() throws IOException {
    if (total < 0)
      throw new InputMismatchException();
    if (index >= total) {
      index = 0;
      total = in.read(buf);
      if (total <= 0)
        return -1;
    }

    return buf[index++];
  }

  public int readInt() throws IOException {
    int integer = 0;
    int n = read();

    while (isWhiteSpace(n))   /*  remove starting white spaces   */
      n = read();

    int neg = 1;
    if (n == '-') {
      neg = -1;
      n = read();
    }

    while (!isWhiteSpace(n)) {
      if (n >= '0' && n <= '9') {
        integer *= 10;
        integer += n - '0';
        n = read();
      } else
        throw new InputMismatchException();
    }

    return neg * integer;
  }

  public String readLine() throws IOException {
    StringBuilder sb = new StringBuilder();
    int n = read();

    while (isWhiteSpace(n))
      n = read();
    while (!isWhiteSpace(n)) {
      sb.append((char) n);
      n = read();
    }

    return sb.toString();
  }

  public double readDouble() throws IOException {
    double doub = 0;
    int n = read();
    while (isWhiteSpace(n))
      n = read();
    int neg = 1;
    if (n == '-') {
      neg = -1;
      n = read();
    }
    while (!isWhiteSpace(n) && n != '.') {
      if (n >= '0' && n <= '9') {
        doub *= 10;
        doub += n - '0';
        n = read();
      } else throw new InputMismatchException();
    }
    if (n == '.') {
      n = read();
      double temp = 1;
      while (!isWhiteSpace(n)) {
        if (n >= '0' && n <= '9') {
          temp /= 10;
          doub += (n - '0') * temp;
          n = read();
        } else throw new InputMismatchException();
      }
    }
    return doub * neg;
  }

  public boolean isWhiteSpace(int n) {
    if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
      return true;

    return false;
  }

  public void close() throws IOException {
    in.close();
  }
}
