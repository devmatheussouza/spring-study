package com.example.httpverbs.mapper.custom;

import com.example.httpverbs.data.dto.v2.PersonDTOv2;
import com.example.httpverbs.models.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOv2 convertEntityToDTO(Person person){
        PersonDTOv2 dtOv2 = new PersonDTOv2();
        dtOv2.setId(person.getId());
        dtOv2.setFirstName(person.getFirstName());
        dtOv2.setLastName(person.getLastName());
        dtOv2.setGender(person.getGender());
        dtOv2.setAddress(person.getAddress());
        dtOv2.setBirthDay(new Date());
        return dtOv2;
    }

    public Person convertDTOToPerson(PersonDTOv2 dtOv2){
        Person person = new Person();
        person.setId(dtOv2.getId());
        person.setFirstName(dtOv2.getFirstName());
        person.setLastName(dtOv2.getLastName());
        person.setGender(dtOv2.getGender());
        person.setAddress(dtOv2.getAddress());
        return person;
    }
}
