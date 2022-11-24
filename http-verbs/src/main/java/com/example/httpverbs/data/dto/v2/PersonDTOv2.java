package com.example.httpverbs.data.dto.v2;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class PersonDTOv2 implements Serializable {


    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Date birthDay;

    public PersonDTOv2() {
    }
}
