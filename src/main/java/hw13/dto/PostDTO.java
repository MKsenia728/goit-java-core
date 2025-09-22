package hw13.dto;

import lombok.Data;

@Data
public class PostDTO implements DTO{

    private int userId;

    private int id;

    private String title;

    private String body;
}
