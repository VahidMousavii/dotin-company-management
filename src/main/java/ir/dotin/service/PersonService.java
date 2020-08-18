package ir.dotin.service;

import ir.dotin.entity.OffRequest;
import ir.dotin.repository.OffRequestDA;
import ir.dotin.repository.PersonDA;
import ir.dotin.entity.Person;
import ir.dotin.to.OffRequestDTO;
import ir.dotin.to.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonDA personDA;
    @Autowired
    private OffRequestDA offRequestDA;

    public PersonDTO loadPerson(Long id) {
        PersonDTO loadedPerson = personDA.loadPerson(id);
        return loadedPerson;
    }

    public List<PersonDTO> loadAllPerson(PersonDTO personDTO) {
        if (personDTO.getActive() == null) {
            personDTO.setActive(false);
        }
        List<PersonDTO> personList = personDA.findAll(personDTO);
        return personList;
    }

    public List<Person> loadManagers() {
        List<Person> managers = personDA.findAllActiveManagers();
        return managers;
    }

    public void deactivate(Person person) {
        personDA.deactivate(person);
    }

    public void active(Person person) {
        personDA.active(person);
    }

    public void save(Person person) {
        if (person.getActive() == null) {
            person.setActive(false);
        }
        personDA.save(person);
    }

    public Person update(Person person) {
        personDA.update(person);
        return person;
    }



    public Person loadPersonWithSentEmails(Long id) {
        Person loadedPerson = personDA.loadPersonWithSentEmails(id);
        return loadedPerson;
    }

    public List<OffRequestDTO> findPendingOffRequestsOfManager(PersonDTO person) {
//        if (person.getRoleSubCategory().equals("manager")) {
        List<OffRequestDTO> pendingOffRequests = offRequestDA.findPendingOffRequestsOfManager(person.getID());
        return pendingOffRequests;
//        }
//        return pendingOffRequests;
    }
}
