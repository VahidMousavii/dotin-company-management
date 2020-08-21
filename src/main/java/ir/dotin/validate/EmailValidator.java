package ir.dotin.validate;

import ir.dotin.exception.DotinException;
import ir.dotin.to.EmailDTO;
import org.springframework.stereotype.Component;

@Component
public class EmailValidator {
    public void checkEmail(EmailDTO emailDTO) throws DotinException {
        if (emailDTO.getEmailContent() == null || "".equals(emailDTO.getEmailContent())) {
            throw new DotinException("متن ایمیل نمیتواند خالی باشد");
        }
        if (emailDTO.getEmailSubject() == null || "".equals(emailDTO.getEmailSubject())) {
            throw new DotinException("موضوع ایمیل نمیتواند خالی باشد");
        }
    }
}
