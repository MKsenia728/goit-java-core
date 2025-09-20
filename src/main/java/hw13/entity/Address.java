package hw13.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Address {

    private String street;

    private String suite;

    private String city;

    private String zipcode;

    private Geo geo;
}
