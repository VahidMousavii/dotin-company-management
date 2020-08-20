package ir.dotin.to;

import ir.dotin.entity.Email;
import ir.dotin.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO extends ParentEntityDTO implements Serializable {

    private PersonDTO senderPerson;

    private List<PersonDTO> receiverPersons;

    private MultipartFile multipartFileEmailAttachFile;

    private String emailAttachmentName;

    private String emailContent;

    private String emailSubject;

}