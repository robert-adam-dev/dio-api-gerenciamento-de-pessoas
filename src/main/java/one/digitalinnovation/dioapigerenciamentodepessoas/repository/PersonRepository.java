package one.digitalinnovation.dioapigerenciamentodepessoas.repository;

import one.digitalinnovation.dioapigerenciamentodepessoas.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
