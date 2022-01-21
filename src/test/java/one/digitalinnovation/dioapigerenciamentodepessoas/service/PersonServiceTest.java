package one.digitalinnovation.dioapigerenciamentodepessoas.service;

import one.digitalinnovation.dioapigerenciamentodepessoas.dto.request.PersonDTO;
import one.digitalinnovation.dioapigerenciamentodepessoas.dto.response.MessageResponseDTO;
import one.digitalinnovation.dioapigerenciamentodepessoas.entity.Person;
import one.digitalinnovation.dioapigerenciamentodepessoas.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.dioapigerenciamentodepessoas.utils.PersonUtils.createFakeDTO;
import static one.digitalinnovation.dioapigerenciamentodepessoas.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDTO succesMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, succesMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("created person with ID " + id)
                .build();
    }
}
