package hw10.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String pathFrom = "src/main/java/hw10/task2/file.txt";
        String pathTo = "src/main/java/hw10/task2/user.json";
        writeJSONtoFile(createUserListFromFile(pathFrom), pathTo);
    }

    public static void writeJSONtoFile(ArrayList<User> users, String to) {
        Gson gs = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(to)) {

            gs.toJson(users, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<User> createUserListFromFile(String from) {
        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(from))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(" ");
                System.out.println(Arrays.toString(userData));
                users.add(new User(userData[0], Integer.parseInt(userData[1])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}

