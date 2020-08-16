package ir.dotin.service;

import ir.dotin.entity.SubCategory;
import ir.dotin.repository.OffRequestDA;
import ir.dotin.entity.OffRequest;
import ir.dotin.entity.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffRequestService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private OffRequestDA offRequestDA;

    public List<OffRequest> getOffRequestListByPersonId(Long personId) {
        List<OffRequest> offRequestList = offRequestDA.findOffRequestByPersonId(personId);
        return offRequestList;

    }

    public void saveOffRequest(OffRequest offRequest) {
        SubCategory pendingSub = categoryService.loadSubCategoryBySubCategoryName("pending");
        offRequest.setStatusOfRequest(pendingSub);
        offRequestDA.saveOffRequest(offRequest);
    }

    public void confirmStatus(OffRequest offRequest) {
        offRequestDA.confirm(offRequest);
    }

    public void rejectStatus(OffRequest offRequest) {
        offRequestDA.reject(offRequest);
    }
}
