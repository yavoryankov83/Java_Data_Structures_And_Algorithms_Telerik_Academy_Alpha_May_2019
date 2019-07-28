import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class BenchmarkClass {
  private static void benchmarkMethod_1() throws InterruptedException {
    long startTime = System.nanoTime();
    /**
     * start of code to benchmark
     */
    TimeUnit.SECONDS.sleep(5);
    /**
     * end of code to benchmark
     */
    long endTime = System.nanoTime();
    long timeElapsed = endTime - startTime;

    System.out.println("Execution time in nanoseconds : " + timeElapsed);

    System.out.println("Execution time in milliseconds: " +
            timeElapsed / 1_000_000);
  }

  private static void benchmarkMethod_2() {
    Instant startTime = Instant.now();
    /**
     * code to benchmark
     */
    Instant endTime = Instant.now();
    long timeElapsed = Duration.between(startTime, endTime).toMillis();

    System.out.println("Execution time in milliseconds: " + timeElapsed);
  }
}
