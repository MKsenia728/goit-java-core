package hw13.dto;

import lombok.Data;

@Data
public class TodoDTO implements DTO{

    private int userId;

    private int id;

    private String title;

    private boolean completed;
}
