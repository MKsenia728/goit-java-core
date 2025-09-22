package hw13.dto;

import lombok.Data;

@Data
public class Response {

    private DTO body;
    private int status;

    public Response(DTO body, int status) {
        this.body = body;
        this.status = status;
    }
}
