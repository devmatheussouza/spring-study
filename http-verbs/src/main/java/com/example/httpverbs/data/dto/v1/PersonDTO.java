package com.example.httpverbs.data.dto.v1;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class PersonDTO implements Serializable {


    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public PersonDTO() {
    }
}
