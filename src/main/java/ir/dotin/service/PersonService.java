package ir.dotin.service;

import ir.dotin.da.PersonDA;
import ir.dotin.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonDA personDA;

    public Person loadPerson(Long id) {
        Person loadedPerson = personDA.loadPerson(id);
        return loadedPerson;
    }

    public List<Person> loadAllPerson(Person person) {
        if (person.getC_active() == null) {
            person.setC_active(false);
        }
        List<Person> personList = personDA.findAll(person);
        return personList;
    }

    public void deactivate(Person person) {
        personDA.deactivate(person);
    }

    public void active(Person person) {
        personDA.active(person);
    }

    public void save(Person person) {
        if (person.getC_active() == null) {
            person.setC_active(false);
        }
        personDA.save(person);
    }

    public Person update(Person person) {
        personDA.update(person);
        return person;
    }

    public Person loadPersonWithReceivedEmails(Long id) {
        Person loadedPerson = personDA.loadPersonWithReceivedEmails(id);
        return loadedPerson;
    }

    public Person loadPersonWithSentEmails(Long id){
        Person loadedPerson = personDA.loadPersonWithSentEmails(id);
        return loadedPerson;
    }
}
