package ir.dotin.to;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class EmailDTO extends ParentEntityDTO implements Serializable {


    private PersonDTO senderPerson;

    private List<PersonDTO> receiverPersons;


    private MultipartFile emailAttachment;

    private String emailContent;

    private String emailSubject;

}