package ir.dotin.service;

import ir.dotin.repository.OffRequestDA;
import ir.dotin.entity.OffRequest;
import ir.dotin.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffRequestService {
    @Autowired
    private PersonService personService;
    @Autowired
    private OffRequestDA offRequestDA;

    public List<OffRequest> getOffRequestListByPersonId(Long personId) {
        List<OffRequest> offRequestList = offRequestDA.findOffRequestByPersonId(personId);
        return offRequestList;

    }

    public void saveOffRequest(OffRequest offRequest) {
        offRequestDA.saveOffRequest(offRequest);

    }
}
