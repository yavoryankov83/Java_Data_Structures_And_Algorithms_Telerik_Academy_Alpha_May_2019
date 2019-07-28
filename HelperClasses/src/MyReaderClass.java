import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyReaderClass {
  private static BufferedReader reader;
  private static StringTokenizer tokenizer;

  /**
   * call this method to initialize reader for InputStream
   */
  static void init(InputStream input) {
    reader = new BufferedReader(new InputStreamReader(input));
    tokenizer = new StringTokenizer("");
  }

  static StringTokenizer readLine() throws IOException {
    return tokenizer = new StringTokenizer(reader.readLine());
  }

  static String read() throws IOException {
    while (!tokenizer.hasMoreTokens()) {
      tokenizer = new StringTokenizer(reader.readLine());
    }
    return tokenizer.nextToken();
  }

  static int readInt() throws IOException {
    return Integer.parseInt(read());
  }

  static double readDouble() throws IOException {
    return Double.parseDouble(read());
  }

  static double readLong() throws IOException {
    return Long.parseLong(read());
  }
}
