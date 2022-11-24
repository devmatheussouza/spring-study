package com.example.httpverbs.services;

import com.example.httpverbs.data.dto.v1.PersonDTO;
import com.example.httpverbs.data.dto.v2.PersonDTOv2;
import com.example.httpverbs.exceptions.ResourceNotFoundException;
import com.example.httpverbs.mapper.DozerMapper;
import com.example.httpverbs.mapper.custom.PersonMapper;
import com.example.httpverbs.models.Person;
import com.example.httpverbs.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());
    public List<PersonDTO> findAll(){
        logger.info("Finding all people.");
        return DozerMapper.parseListObjects(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id){
        logger.info("Finding one person.");
        var entity =  personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerMapper.parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person){
        logger.info("Creating new person");
        var entity = DozerMapper.parseObject(person, Person.class);
        return DozerMapper.parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public PersonDTOv2 createV2(PersonDTOv2 personDTOv2) {
        logger.info("Creating new person (v2)");
        var entity = personMapper.convertDTOToPerson(personDTOv2);
        return personMapper.convertEntityToDTO(personRepository.save(entity));
    }

    public PersonDTO update(PersonDTO personDTO){
        logger.info("Updating person");
        var p = personRepository.findById(personDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        p.setFirstName(personDTO.getFirstName());
        p.setLastName(personDTO.getLastName());
        p.setAddress(personDTO.getAddress());
        p.setGender(personDTO.getGender());
        return DozerMapper.parseObject(personRepository.save(p), PersonDTO.class);
    }

    public void delete(Long id){
        personRepository.delete(personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")));
    }


}
