import java.io.ByteArrayInputStream;

public class TestInputClass {
  private static void testInput() {
    String input = "4\n" +
            "h1\n" +
            "r5\n" +
            "d2\n" +
            "a0";

    System.setIn(new ByteArrayInputStream(input.getBytes()));
  }
}
