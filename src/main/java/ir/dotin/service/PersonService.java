package ir.dotin.service;

import ir.dotin.entity.OffRequest;
import ir.dotin.entity.Person;
import ir.dotin.exception.DotinException;
import ir.dotin.repository.OffRequestDA;
import ir.dotin.repository.PersonDA;
import ir.dotin.to.OffRequestDTO;
import ir.dotin.to.PersonDTO;
import ir.dotin.validate.PersonValidator;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private ModelMapper modelMapper;

    public PersonDTO loadPerson(Long id) {
        Person person = personDA.loadPerson(id);
        PersonDTO personDTO = modelMapper.map(person, PersonDTO.class);
        return personDTO;
    }

    public List<PersonDTO> loadAllPerson(PersonDTO personDTO) {
        if (personDTO.getActive() == null) {
            personDTO.setActive(false);
        }

        List<Person> persons = personDA.findAll(personDTO.getActive());
        List<PersonDTO> personDTOS = modelMapper.map(persons, new TypeToken<List<PersonDTO>>() {
        }.getType());
        return personDTOS;
    }

    public List<PersonDTO> loadManagers() {
        List<Person> managers = personDA.findAllActiveManagers();
        List<PersonDTO> personDTOS = modelMapper.map(managers, new TypeToken<List<PersonDTO>>() {
        }.getType());
        return personDTOS;
    }

    public void deactivate(PersonDTO personDTO) {
        personDA.deactivate(personDTO.getID());
    }

    public void active(PersonDTO personDTO) {
        personDA.active(personDTO.getID());
    }

    public void save(PersonDTO personDTO) throws DotinException {
        personValidator.checkPerson(personDTO);
        Person person = modelMapper.map(personDTO, Person.class);
        personDA.save(person);
    }

    public void update(PersonDTO personDTO) {
        Person person = modelMapper.map(personDTO, Person.class);
        personDA.update(person);
    }


    public PersonDTO loadPersonWithSentEmails(Long id) {
        Person loadedPerson = personDA.loadPersonWithSentEmails(id);
        PersonDTO personDTO = modelMapper.map(loadedPerson, PersonDTO.class);
        return personDTO;
    }

    public List<OffRequestDTO> findPendingOffRequestsOfManager(PersonDTO person) {
        List<OffRequest> pendingOffRequests = offRequestDA.findPendingOffRequestsOfManager(person.getID());
        List<OffRequestDTO> offRequestDTOS = modelMapper.map(pendingOffRequests, new TypeToken<List<OffRequestDTO>>() {
        }.getType());
        return offRequestDTOS;

    }
}
