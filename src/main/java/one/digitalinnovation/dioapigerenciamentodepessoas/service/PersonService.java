package one.digitalinnovation.dioapigerenciamentodepessoas.service;

import one.digitalinnovation.dioapigerenciamentodepessoas.dto.MessageResponseDTO;
import one.digitalinnovation.dioapigerenciamentodepessoas.entity.Person;
import one.digitalinnovation.dioapigerenciamentodepessoas.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("created person with ID " + savedPerson.getId())
                .build();
    }
}
