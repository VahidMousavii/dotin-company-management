package ir.dotin.validate;

import ir.dotin.exception.DotinException;
import ir.dotin.to.OffRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class OffRequestValidator {

    public void checkOffRequest(OffRequestDTO offRequestDTO) throws DotinException {
        if (offRequestDTO.getOffStartDate() == null || "".equals(offRequestDTO.getOffStartDate())) {
            throw new DotinException("تاریخ شروع نمیتواند خالی باشد");
        }
        if (offRequestDTO.getOffEndDate() == null || "".equals(offRequestDTO.getOffEndDate())) {
            throw new DotinException("تاریخ پایان نمیتواند خالی باشد");
        }
        if (offRequestDTO.getOffDescription() == null || "".equals(offRequestDTO.getOffDescription())) {
            throw new DotinException("شرح مرخصی نمیتواند خالی باشد");
        }
    }
}
