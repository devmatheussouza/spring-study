package com.example.httpverbs.services;

import com.example.httpverbs.exceptions.ResourceNotFoundException;
import com.example.httpverbs.models.Person;
import com.example.httpverbs.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PersonServices {

    @Autowired
    private PersonRepository personRepository;
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());
    public List<Person> findAll(){
        logger.info("Finding all people.");
        return personRepository.findAll();
    }

    public Person findById(Long id){
        logger.info("Finding one person.");
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Person create(Person person){
        logger.info("Creating new person");
        return personRepository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating person");
        var p = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        p.setFirstName(person.getFirstName());
        p.setLastName(person.getLastName());
        p.setAddress(person.getAddress());
        p.setGender(person.getGender());
        return personRepository.save(p);
    }

    public void delete(Long id){
        personRepository.delete(personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")));
    }
}
