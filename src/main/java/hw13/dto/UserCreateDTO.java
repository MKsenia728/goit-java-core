package hw13.dto;

import hw13.entity.Address;
import hw13.entity.Company;
import lombok.Data;

@Data
public class UserCreateDTO implements DTO{

    private int id;

    private String name;

    private String username;

    private String email;

    private Address address;

    private String phone;

    private String website;

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
