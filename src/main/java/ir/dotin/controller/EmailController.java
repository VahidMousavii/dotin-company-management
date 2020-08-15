package ir.dotin.controller;

import ir.dotin.entity.Email;
import ir.dotin.entity.Person;
import ir.dotin.service.EmailService;
import ir.dotin.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView sendEmail(@ModelAttribute Person person) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/email/email.jsp");
        modelAndView.addObject("senderPerson", person);
        person.setActive(true);
        List<Person> allActivePersons = personService.loadAllPerson(person);
        modelAndView.addObject("receiverPersons", allActivePersons);
        return modelAndView;

    }

    @RequestMapping("/saveEmail.do")
    public ModelAndView saveEmail(@ModelAttribute Email email) {
        ModelAndView modelAndView = new ModelAndView("/person/findAll.do?active=1");
        emailService.saveEmail(email);
        return modelAndView;
    }

    @RequestMapping("/showSentBox.do")
    public ModelAndView showSentBox(@ModelAttribute Person person) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/email/showEmail.jsp");
        Person loadedPerson = personService.loadPersonWithSentEmails(person.getID());
        modelAndView.addObject("person", loadedPerson);
        modelAndView.addObject("isSent", true);
        return modelAndView;
    }

    @RequestMapping("/showInbox.do")
    public ModelAndView showInbox(@ModelAttribute Person person) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/email/showEmail.jsp");
        Person loadedPerson = personService.loadPersonWithReceivedEmails(person.getID());
        modelAndView.addObject("person", loadedPerson);
        modelAndView.addObject("isSent", false);
        return modelAndView;

    }
}
