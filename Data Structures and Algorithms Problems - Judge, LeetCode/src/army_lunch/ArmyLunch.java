package army_lunch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ArmyLunch {
  private static StringTokenizer stringTokenizer;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<String> sergeants = new ArrayList<>();
    List<String> corporals = new ArrayList<>();
    List<String> privates = new ArrayList<>();

    int count = Integer.parseInt(reader.readLine());
    stringTokenizer = new StringTokenizer(reader.readLine());
    while (stringTokenizer.hasMoreTokens()) {
      String currentSoldier = stringTokenizer.nextToken();
      if (currentSoldier.startsWith("S")) {
        sergeants.add(currentSoldier);
      } else if (currentSoldier.startsWith("C")) {
        corporals.add(currentSoldier);
      } else if (currentSoldier.startsWith("P")) {
        privates.add(currentSoldier);
      }
    }

    for (String sergeant : sergeants) {
      System.out.print(sergeant + " ");
    }
    for (String corporal : corporals) {
      System.out.print(corporal + " ");
    }
    for (String private1 : privates) {
      System.out.print(private1 + " ");
    }
  }
}
