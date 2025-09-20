package hw13.DTO;

import com.google.gson.annotations.SerializedName;
import hw13.entity.Address;
import hw13.entity.Company;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString

public class UserCreateDTO extends DTO{

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("username")
    private String username;

    @SerializedName("email")
    private String email;

    @SerializedName("address")
    private Address address;

    @SerializedName("phone")
    private String phone;

    @SerializedName("website")
    private String website;

    @SerializedName("company")
    private Company company;

    public UserCreateDTO(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public UserCreateDTO(String username) {
        this.username = username;
    }
}
