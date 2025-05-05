package se.yitingchang.personlabb1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public Person AddPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable int id) {
        return personService.getPersonById(id)
                .orElseThrow(()->new RuntimeException("Person not found"));
    }

    @GetMapping("/lastName/{lastName}")
    public List<Person> getPersonsByLastName(@PathVariable String lastName) {
        return personService.getPersonByLastName(lastName);
    }

    @GetMapping("/olderThan/{age}")
    public List<Person> getPersonsByOlderThan(@PathVariable int age) {
        return personService.getPersonsOlderThan(age);
    }

    @PutMapping("/{id}")
    public Optional<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {
        return personService.updatePerson(id,person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
    }



}
