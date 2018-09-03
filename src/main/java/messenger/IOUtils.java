package messenger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class IOUtils {

    Scanner scanner;

    public IOUtils() {
        scanner = new Scanner(System.in);
    }

    public void writeMessage(String message) {
        System.out.println(message);
    }

    public boolean fileExist(Path filename) {
        return Files.exists(filename);
    }

    public boolean fileExist(String filename) {
        Path filePath = Paths.get(filename + ".txt");
        return fileExist(filePath);
    }

    public String readNextLine() {
        return scanner.nextLine();
    }

    public int readNextInt() {
        return scanner.nextInt();
    }

}