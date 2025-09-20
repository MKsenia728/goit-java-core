package hw13;

import hw13.DTO.*;

import java.io.IOException;
import java.util.List;

public class HTTPClientServiceTest {
    HTTPClientService cs;

    public HTTPClientServiceTest() {
        this.cs = new HTTPClientService();
    }

    public void start() {
        try {
//        створення нового об'єкта в https://jsonplaceholder.typicode.com/users.
            UserCreateDTO user = new UserCreateDTO("Ivan Petrov", "Developer", "bobr@gmail.com");
            Response res = cs.createUser(user);
            System.out.println("Status for CREATE: " + res.getStatus());
            System.out.println("Added user : " + res.getBody());

//        оновлення об'єкт в https://jsonplaceholder.typicode.com/users.

            UserCreateDTO updatedUser = new UserCreateDTO("NewUserName");
            res = cs.updateUser(1, updatedUser);
            System.out.println("Status for PUT: " + res.getStatus());
            System.out.println("Updated user : " + res.getBody());

//        видалення об'єкта з https://jsonplaceholder.typicode.com/users.

            int status = cs.deleteUser(1);
            System.out.println("Status for DELETE: " + status);

//        отримання інформації про всіх користувачів


            List<UserDTO> users = cs.getAllUsers();
            for (UserDTO us : users) {
                System.out.println(us);
            }

//        отримання інформації про користувача за id https://jsonplaceholder.typicode.com/users/{id}

            System.out.println("User with id 2 : " + cs.getUserById(2));

//        отримання інформації про користувача за username - https://jsonplaceholder.typicode.com/users?username={username}

            System.out.println("User with username Antonette : " + cs.getUserByUsername("Antonette"));

//        Доповніть програму методом, що буде виводити всі коментарі до останнього поста певного користувача і записувати їх у файл.

            List<CommentDTO> comments = cs.getCommentsByPostIdAndSaveToFile(1);
            System.out.println("Comments for user with id 1 :");
            for (CommentDTO comment : comments) {
                System.out.println(comment);
            }

//            Доповніть програму методом, що буде виводити всі відкриті задачі для користувача з ідентифікатором X.

            List<TodoDTO> todos = cs.getAllOpenedTasksByUser(2);
            System.out.println("Uncompleted tasks for user with id 2 :");
            for (TodoDTO todo : todos) {
                System.out.println(todo);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
