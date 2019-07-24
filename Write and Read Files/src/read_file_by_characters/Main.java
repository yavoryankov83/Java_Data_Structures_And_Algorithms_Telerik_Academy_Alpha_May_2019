package read_file_by_characters;

import java.io.*;

public class Main {
  public static void main(String[] args) {
    File file = new File("file.txt");

    try (FileReader fileReader = new FileReader(file);
         BufferedReader bufferedReader = new BufferedReader(fileReader)) {

      int num = 0;
      char charToRead;

      while ((num = bufferedReader.read()) != -1) {
        charToRead = (char) num;
        System.out.print(charToRead);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
