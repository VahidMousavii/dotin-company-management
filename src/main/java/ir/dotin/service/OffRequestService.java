package ir.dotin.service;

import ir.dotin.entity.OffRequest;
import ir.dotin.entity.SubCategory;
import ir.dotin.repository.OffRequestDA;
import ir.dotin.to.EmailDTO;
import ir.dotin.to.OffRequestDTO;
import ir.dotin.to.SubCategoryDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OffRequestService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private OffRequestDA offRequestDA;
    @Autowired
    ModelMapper modelMapper;

    public List<OffRequestDTO> getOffRequestListByPersonId(Long personId) {
        List<OffRequest> offRequestList = offRequestDA.findOffRequestByPersonId(personId);
        List<OffRequestDTO> offRequestDTOS = modelMapper.map(offRequestList, new TypeToken<List<OffRequestDTO>>() {
        }.getType());
        return offRequestDTOS;

    }

    public void saveOffRequest(OffRequestDTO offRequestDTO) {
        SubCategoryDTO subCategoryDTO = categoryService.loadSubCategoryBySubCategoryName("pending");
        offRequestDTO.setStatusOfRequest(subCategoryDTO);
        OffRequest offRequest = modelMapper.map(offRequestDTO, OffRequest.class);
        offRequestDA.saveOffRequest(offRequest);
    }

    public void confirmStatus(OffRequestDTO offRequestDTO) {
        offRequestDA.confirm(offRequestDTO);
    }

    public void rejectStatus(OffRequestDTO offRequestDTO) {
        offRequestDA.reject(offRequestDTO);
    }
}
