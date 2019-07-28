package write_file_with_append;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    File file = new File("file.txt");

    try(FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){

      if (!file.exists()){
        file.createNewFile();
      }

      bufferedWriter.write("Yavor" + System.lineSeparator());
      bufferedWriter.write("Todorov"+ System.lineSeparator());
      bufferedWriter.write("Yankov"+ System.lineSeparator());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
