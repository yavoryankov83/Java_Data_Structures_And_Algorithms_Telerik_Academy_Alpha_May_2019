import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ReadInputClass {
  private static void readInput_BufferedReader_StringTokenizer() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine(), " ", false);
    List<String> result = new ArrayList<>();

    while (stringTokenizer.hasMoreTokens()) {
      result.add(stringTokenizer.nextToken());
    }
  }
}
