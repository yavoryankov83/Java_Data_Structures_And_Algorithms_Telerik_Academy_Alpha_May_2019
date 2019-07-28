package read_file_by_line;

import java.io.*;

public class Main {
  public static void main(String[] args) {
    File file = new File("file.txt");

    try(FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader)){
    String line = bufferedReader.readLine();

    while (line != null){
      System.out.println(line);
      line = bufferedReader.readLine();
    }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
