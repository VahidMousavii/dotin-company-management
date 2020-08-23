package ir.dotin.controller;

import ir.dotin.entity.Person;
import ir.dotin.exception.DotinException;
import ir.dotin.repository.PersonDA;
import ir.dotin.service.CategoryService;
import ir.dotin.service.PersonService;
import ir.dotin.to.PersonDTO;
import ir.dotin.to.SubCategoryDTO;
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
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/savePage.do")
    public ModelAndView savePage() {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/addPerson.jsp");
        List<PersonDTO> managers = personService.loadManagers();
        List<SubCategoryDTO> subCategories = categoryService.loadSubCategoriesByName("role");
        modelAndView.addObject("managers", managers);
        modelAndView.addObject("roles", subCategories);
        return modelAndView;
    }

    @RequestMapping(value = "/save.do", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute PersonDTO personDTO) throws DotinException {
        ModelAndView modelAndView = new ModelAndView();
        String message = "ثبت کاربر جدید";
        modelAndView.addObject("message", message);
        personService.save(personDTO);
        modelAndView.setViewName("/WEB-INF/successful.jsp");
        return modelAndView;
    }

    @RequestMapping("/update.do")
    public ModelAndView update(@ModelAttribute Person person) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/updatePerson.jsp");
        PersonDTO loadedPerson = personService.loadPerson(person.getID());
        List<SubCategoryDTO> subCategories = categoryService.loadSubCategoriesByName("role");
        List<PersonDTO> managers = personService.loadManagers();
        modelAndView.addObject("managers", managers);
        modelAndView.addObject("roles", subCategories);
        modelAndView.addObject("loadedPerson", loadedPerson);
        return modelAndView;
    }

    @RequestMapping("/saveUpdate.do")
    public ModelAndView saveUpdate(@ModelAttribute PersonDTO personDTO) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/successful.jsp");
        String message = "بروزرسانی کاربر";
        modelAndView.addObject("message", message);
        personService.update(personDTO);
        modelAndView.addObject(personDTO);
        return modelAndView;
    }

    @RequestMapping("/active.do")
    public ModelAndView active(PersonDTO personDTO) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/successful.jsp");
        String message = "بازیابی کاربر";
        modelAndView.addObject("message", message);
        personService.active(personDTO);
        return modelAndView;
    }

    @RequestMapping("/deactivate.do")
    public ModelAndView deactivate(@ModelAttribute PersonDTO personDTO) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/successful.jsp");
        String message = "حذف کاربر";
        modelAndView.addObject("message", message);
        personService.deactivate(personDTO);
        return modelAndView;
    }

    @RequestMapping("/enable.do")
    public ModelAndView enable(@ModelAttribute PersonDTO personDTO) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/successful.jsp");
        String message = "فعال سازی کاربر";
        modelAndView.addObject("message", message);
        personService.enable(personDTO);
        return modelAndView;
    }

    @RequestMapping("/disable.do")
    public ModelAndView disable(@ModelAttribute PersonDTO personDTO) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/successful.jsp");
        String message = "غیر فعال سازی کاربر";
        modelAndView.addObject("message", message);
        personService.disable(personDTO);
        return modelAndView;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@ModelAttribute PersonDTO personDTO) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/index.jsp");
        List<PersonDTO> personList = personService.loadAllPerson(personDTO);
        modelAndView.addObject("persons", personList);
        return modelAndView;
    }
}
