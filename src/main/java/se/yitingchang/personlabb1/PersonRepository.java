package se.yitingchang.personlabb1;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findByLastName(String lastName);
    Optional<Person> findById(int id);
    List<Person> findAll();
    List<Person> findByAgeGreaterThan(int age);
    List<Person> findByAgeLessThan(int age);
    List<Person> findByEmail(String email);
    List<Person> findByPhoneNumber(String phone);



  }
