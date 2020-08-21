package ir.dotin.validate;

import ir.dotin.exception.DotinException;
import ir.dotin.to.PersonDTO;
import org.springframework.stereotype.Component;

@Component
public class PersonValidator {
    public void checkPerson(PersonDTO personDTO) throws DotinException {
        if (personDTO.getActive() == null) {
            personDTO.setActive(false);
        }
        if (personDTO.getPersonName() == null || "".equals(personDTO.getPersonName())) {
            throw new DotinException("مقدار نام نمیتواند خالی باشد.");
        }
        if(personDTO.getPersonFamily() == null || "".equals(personDTO.getPersonFamily())){
            throw new DotinException(("مقدار نام خانوادگی نمیتواند خالی باشد"));
        }
        if(personDTO.getNationalCode() == null || "".equals(personDTO.getNationalCode())){
            throw new DotinException("کد ملی نمیتواند خالی باشد");
        }
    }
}
