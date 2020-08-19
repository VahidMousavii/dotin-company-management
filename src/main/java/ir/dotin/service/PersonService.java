package ir.dotin.service;

import ir.dotin.entity.Person;
import ir.dotin.exception.DotinException;
import ir.dotin.repository.OffRequestDA;
import ir.dotin.repository.PersonDA;
import ir.dotin.to.OffRequestDTO;
import ir.dotin.to.PersonDTO;
import ir.dotin.validate.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonDA personDA;
    @Autowired
    private OffRequestDA offRequestDA;
    @Autowired
    private PersonValidator personValidator;

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

    public List<PersonDTO> loadManagers() {
        List<PersonDTO> managers = personDA.findAllActiveManagers();
        return managers;
    }

    public void deactivate(PersonDTO personDTO) {
        personDA.deactivate(personDTO);
    }

    public void active(PersonDTO personDTO) {
        personDA.active(personDTO);
    }

    public void save(PersonDTO personDTO) throws DotinException {
        personValidator.checkPerson(personDTO);
        personDA.save(new Person(personDTO));
    }

    public PersonDTO update(PersonDTO personDTO) {
        personDA.update(new Person(personDTO));
        return personDTO;
    }



    public PersonDTO loadPersonWithSentEmails(Long id) {
        PersonDTO loadedPerson = personDA.loadPersonWithSentEmails(id);
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
