package ir.dotin.controller;

import ir.dotin.repository.PersonDA;
import ir.dotin.entity.Person;
import ir.dotin.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Scope("request")
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonDA personDA;
    @Autowired
    PersonService personService;

    @RequestMapping(value = "/savePage.do" )
    public ModelAndView savePage() {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/addPerson.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/save.do" , method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Person person) {
        ModelAndView modelAndView = new ModelAndView();
        personService.save(person);
        modelAndView.setViewName("/person/findAll.do");
        return modelAndView;
    }

    @RequestMapping("/update.do")
    public ModelAndView update(@ModelAttribute Person person) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/updatePerson.jsp");
        Person loadedPerson = personService.loadPerson(person.getC_ID());
        modelAndView.addObject("loadedPerson", loadedPerson);
        return modelAndView;
    }

    @RequestMapping("/saveUpdate.do")
    public ModelAndView saveUpdate(@ModelAttribute Person person) {
        ModelAndView modelAndView = new ModelAndView("/person/findAll.do");
        personService.update(person);
        modelAndView.addObject(person);
        return modelAndView;
    }

    /*@RequestMapping("/delete.do")
    public String delete(@ModelAttribute Person person) throws Exception {
        personDA.deleteByID(person.getC_ID());
        return "redirect:/person/findAll.do";
    }*/

    @RequestMapping("/active.do")
    public ModelAndView active(Person person) {
        ModelAndView modelAndView = new ModelAndView("/person/findAll.do");
        personService.active(person);
        return modelAndView;

    }

    @RequestMapping("/deactivate.do")
    public ModelAndView deactivate(@ModelAttribute Person person) {
        ModelAndView modelAndView = new ModelAndView("/person/findAll.do");
        personService.deactivate(person);
        return modelAndView;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@ModelAttribute Person person) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/index.jsp");
        List<Person> personList = personService.loadAllPerson(person);
        modelAndView.addObject("persons", personList);
        return modelAndView;
    }
}
