package ir.dotin.service;

import ir.dotin.entity.OffRequest;
import ir.dotin.exception.DotinException;
import ir.dotin.repository.OffRequestDA;
import ir.dotin.to.OffRequestDTO;
import ir.dotin.to.SubCategoryDTO;
import ir.dotin.validate.OffRequestValidator;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffRequestService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    OffRequestValidator offRequestValidator;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private OffRequestDA offRequestDA;

    public List<OffRequestDTO> getOffRequestListByPersonId(Long personId) {
        List<OffRequest> offRequestList = offRequestDA.findOffRequestByPersonId(personId);
        List<OffRequestDTO> offRequestDTOS = modelMapper.map(offRequestList, new TypeToken<List<OffRequestDTO>>() {
        }.getType());
        return offRequestDTOS;

    }

    public void saveOffRequest(OffRequestDTO offRequestDTO) throws DotinException {
        SubCategoryDTO subCategoryDTO = categoryService.loadSubCategoryBySubCategoryName("pending");
        offRequestDTO.setStatusOfRequest(subCategoryDTO);
        OffRequest offRequest = modelMapper.map(offRequestDTO, OffRequest.class);
        offRequestValidator.checkOffRequest(offRequestDTO);
        offRequestDA.saveOffRequest(offRequest);
    }

    public void confirmStatus(OffRequestDTO offRequestDTO) {
        offRequestDA.confirm(offRequestDTO);
    }

    public void rejectStatus(OffRequestDTO offRequestDTO) {
        offRequestDA.reject(offRequestDTO);
    }
}
