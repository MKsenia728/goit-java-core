package hw13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hw13.dto.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

public class HTTPClientService {
    private final String url = "https://jsonplaceholder.typicode.com/users";
    private final HttpClient client;
    private final Gson gson;

    public HTTPClientService() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public List<UserDTO> getAllUsers() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(
                response.body(),
                new TypeToken<List<UserDTO>>() {
                }.getType()
        );
    }

    public UserDTO getUserById(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/" + id))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), UserDTO.class);
    }

    public UserDTO getUserByUsername(String userName) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "?username=" + userName))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        List<UserDTO> users = gson.fromJson(
                response.body(),
                new TypeToken<List<UserDTO>>() {}.getType()
        );

        return users.isEmpty() ? null : users.getFirst();
    }

    public Response createUser(UserCreateDTO user) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(user)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        UserDTO createdUser = gson.fromJson(response.body(), UserDTO.class);
        return new Response(createdUser, response.statusCode());
    }

    public Response updateUser(int id, UserCreateDTO user) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/" + id))
                .header("Content-type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(user)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        UserDTO createdUser = gson.fromJson(response.body(), UserDTO.class);
        return new Response(createdUser, response.statusCode());
    }

    public int deleteUser(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/" + id))
                .DELETE()
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString()).statusCode();
    }

//    ====Task 2=================================================================================

    private int searchLastUsersPost(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/" + userId + "/posts"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        List<PostDTO> posts = gson.fromJson(
                response.body(),
                new TypeToken<List<PostDTO>>() {
                }.getType()
        );
        return posts.stream()
                .mapToInt(PostDTO::getId)
                .max()
                .orElseThrow();
    }

    private HttpResponse<String> getCommentsByPostId(int postId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/" + postId + "/comments"))
                .GET()
                .build();
         return client.send(request, HttpResponse.BodyHandlers.ofString());

    }

    private void saveCommentsToFile(int userId, int postId, String body) {
        String file = "user-" + userId + "-post-" + postId + "-comments.json";
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(body);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CommentDTO> getCommentsByPostIdAndSaveToFile(int userId) throws IOException, InterruptedException {
        int postId = searchLastUsersPost(userId);
        HttpResponse<String> responseComments = getCommentsByPostId(postId);
        saveCommentsToFile(userId, postId, responseComments.body());
        return gson.fromJson(
                responseComments.body(),
                new TypeToken<List<CommentDTO>>() {
                }.getType());
    }

    //    ====Task 3=================================================================================
    public List<TodoDTO> getAllOpenedTasksByUser(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/" + id + "/todos"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        List<TodoDTO> todos = gson.fromJson(
                response.body(),
                new TypeToken<List<TodoDTO>>() {
                }.getType()
        );
        return todos.stream()
                .filter(e -> !e.isCompleted())
                .collect(Collectors.toList());
    }
}
