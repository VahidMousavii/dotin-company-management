package ir.dotin.service;

import ir.dotin.entity.OffRequest;
import ir.dotin.repository.OffRequestDA;
import ir.dotin.repository.PersonDA;
import ir.dotin.entity.Person;
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

    public Person loadPerson(Long id) {
        Person loadedPerson = personDA.loadPerson(id);
        return loadedPerson;
    }

    public List<Person> loadAllPerson(Person person) {
        if (person.getActive() == null) {
            person.setActive(false);
        }
        List<Person> personList = personDA.findAll(person);
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

    public List<OffRequest> findPendingOffRequestsOfManager(Person person) {
//        if (person.getRoleSubCategory().equals("manager")) {
        List<OffRequest> pendingOffRequests = offRequestDA.findPendingOffRequestsOfManager(person.getID());
        return pendingOffRequests;
//        }
//        return pendingOffRequests;
    }
}
