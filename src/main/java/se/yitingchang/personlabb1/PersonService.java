package se.yitingchang.personlabb1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(int id) {
        return personRepository.findById(id);
    }

    public List<Person> getPersonByLastName(String lastName) {
        return personRepository.findByLastName(lastName);

    }
    public List<Person> getPersonsOlderThan(int age) {
        return personRepository.findByAgeGreaterThan(age);
    }

    public List<Person> getPersonsYoungerThan(int age) {
        return personRepository.findByAgeLessThan(age);
    }

    public Person savePerson(Person person) {
        personRepository.save(person);
        return person;
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    public Optional<Person> updatePerson(int id, Person updatePerson) {
        return Optional.ofNullable(personRepository.findById(id)
                .map(person -> {
                    person.setFirstName(updatePerson.getFirstName());
                    person.setLastName(updatePerson.getLastName());
                    person.setAge(updatePerson.getAge());
                    person.setEmail(updatePerson.getEmail());
                    person.setPhoneNumber(updatePerson.getPhoneNumber());
                    return personRepository.save(person);
                })
                .orElseThrow(() -> new RuntimeException("Person not Found")));

    }
}
