package hw13.dto;

import hw13.entity.Address;
import hw13.entity.Company;
import lombok.Data;

@Data
public class UserDTO implements DTO{

    private int id;

    private String name;

    private String username;

    private String email;

    private Address address;

    private String phone;

    private String website;

    private Company company;
}
