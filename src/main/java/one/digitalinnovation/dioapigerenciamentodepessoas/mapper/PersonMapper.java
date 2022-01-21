package one.digitalinnovation.dioapigerenciamentodepessoas.mapper;

import one.digitalinnovation.dioapigerenciamentodepessoas.dto.request.PersonDTO;
import one.digitalinnovation.dioapigerenciamentodepessoas.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
