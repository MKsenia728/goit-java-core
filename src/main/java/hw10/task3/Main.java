package hw10.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/java/hw10/task3/words.txt";
        List<Map.Entry<String, Integer>> wordsWithCount = getCountWords(path);
        for (Map.Entry<String, Integer> entry : wordsWithCount) {
            System.out.println(entry);
        }
    }

    private static List<Map.Entry<String, Integer>> getCountWords(String path) {
        Map<String, Integer> words = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arrayWords = line.trim().split("\\s+");
                for (String word : arrayWords) {
                    if (!words.containsKey(word)) {
                        words.put(word, 1);
                    } else {
                        words.put(word, words.get(word) + 1);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(words.entrySet());
        sortedList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        return sortedList;
    }
}
