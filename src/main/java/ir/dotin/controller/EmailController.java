package ir.dotin.controller;

import ir.dotin.entity.Person;
import ir.dotin.exception.DotinException;
import ir.dotin.service.EmailService;
import ir.dotin.service.PersonService;
import ir.dotin.to.AttachedDTO;
import ir.dotin.to.EmailDTO;
import ir.dotin.to.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@Scope("request")
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private PersonService personService;
    @Autowired
    private EmailService emailService;


    @RequestMapping("/email.do")
    public ModelAndView sendEmail(@ModelAttribute PersonDTO personDTO) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/email/email.jsp");
        modelAndView.addObject("senderPerson", personDTO);
        personDTO.setActive(true);
        List<PersonDTO> allActivePersons = personService.loadAllPerson(personDTO);
        modelAndView.addObject("receiverPersons", allActivePersons);
        return modelAndView;

    }

    @RequestMapping(value = "/saveEmail.do", method = RequestMethod.POST)
    public ModelAndView saveEmail(@ModelAttribute EmailDTO emailDTO) throws IOException, SQLException, DotinException {
        ModelAndView modelAndView = new ModelAndView("/person/findAll.do?active=1");
        emailService.saveEmail(emailDTO);
        return modelAndView;
    }

    @RequestMapping(value = "/downloadAttached.do")
    public void getAttached(@ModelAttribute EmailDTO emailDTO, HttpServletResponse response) throws SQLException, IOException, DotinException {
        AttachedDTO emailAttached = this.emailService.getEmailAttached(emailDTO);
        emailService.getEmailAttached(emailDTO);
        response.setHeader("Content-Disposition", "attachment; filename=" + emailAttached.getFileName());
        org.apache.commons.io.IOUtils.copy(new ByteArrayInputStream(emailAttached.getBytes()), response.getOutputStream());

        response.flushBuffer();
    }

    @RequestMapping("/showSentBox.do")
    public ModelAndView showSentBox(@ModelAttribute PersonDTO personDTO) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/email/showEmail.jsp");
        List<EmailDTO> sentEmails = emailService.loadSentEmailsByPersonId(personDTO.getID());
        modelAndView.addObject("sentEmails", sentEmails);
        modelAndView.addObject("person", personDTO);
        modelAndView.addObject("isSent", true);
        return modelAndView;
    }

    @RequestMapping("/showInbox.do")
    public ModelAndView showInbox(@ModelAttribute PersonDTO personDTO) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/email/showEmail.jsp");
        List<EmailDTO> receivedEmails = emailService.loadReceivedEmailsByPersonID(personDTO.getID());
        modelAndView.addObject("person", personDTO);
        modelAndView.addObject("receivedEmails", receivedEmails);
        modelAndView.addObject("isSent", false);
        return modelAndView;
    }
}