package hw13.DTO;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CommentDTO {

    @SerializedName("postId")
    private int postId;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("body")
    private String body;
}
