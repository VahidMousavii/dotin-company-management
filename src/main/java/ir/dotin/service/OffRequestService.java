package ir.dotin.service;

import ir.dotin.entity.SubCategory;
import ir.dotin.repository.OffRequestDA;
import ir.dotin.entity.OffRequest;
import ir.dotin.entity.Person;
import ir.dotin.to.OffRequestDTO;
import ir.dotin.to.SubCategoryDTO;
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

    public List<OffRequestDTO> getOffRequestListByPersonId(Long personId) {
        List<OffRequestDTO> offRequestList = offRequestDA.findOffRequestByPersonId(personId);
        return offRequestList;

    }

    public void saveOffRequest(OffRequestDTO offRequestDTO) {
        SubCategoryDTO subCategoryDTO = categoryService.loadSubCategoryBySubCategoryName("pending");
        offRequestDTO.setStatusOfRequest(subCategoryDTO);
        offRequestDA.saveOffRequest(offRequestDTO);
    }

    public void confirmStatus(OffRequestDTO offRequestDTO) {
        offRequestDA.confirm(offRequestDTO);
    }

    public void rejectStatus(OffRequestDTO offRequestDTO) {
        offRequestDA.reject(offRequestDTO);
    }
}
