package hw13.dto;

import lombok.Data;

@Data
public class CommentDTO implements DTO{

    private int postId;

    private int id;

    private String name;

    private String email;

    private String body;
}
