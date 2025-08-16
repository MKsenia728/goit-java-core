package hw10.task1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/java/hw10/task1/file.txt";
        printValidPhoneFromFile(path);
    }

    public static void printValidPhoneFromFile(String filePath) {
        String phoneRegex = "^(\\(\\d{3}\\)\\s|\\d{3}-)\\d{3}-\\d{4}$";
        try (Scanner reader = new Scanner(new FileReader(filePath))) {
            String line;
            while (reader.hasNext()) {
                line = reader.nextLine();
                if (line.matches(phoneRegex))
                    System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
