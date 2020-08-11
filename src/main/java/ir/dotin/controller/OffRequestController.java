package ir.dotin.controller;

import ir.dotin.da.OffRequestDA;
import ir.dotin.entity.Category;
import ir.dotin.entity.OffRequest;
import ir.dotin.entity.Person;
import ir.dotin.service.CategoryService;
import ir.dotin.service.OffRequestService;
import ir.dotin.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("request")
@RequestMapping("/offRequest")

public class OffRequestController {

    @Autowired
    private OffRequestDA offRequestDA;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PersonService personService;
    @Autowired
    private OffRequestService offRequestService;

    @RequestMapping("/offRequest.do")
    public ModelAndView showOffRequest(@ModelAttribute Person person) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/offRequest.jsp");
        Person loadPerson = personService.loadPerson(person.getC_ID());
        Category category = categoryService.loadCategoryById(1L);
        modelAndView.addObject("person", loadPerson);
        modelAndView.addObject("offCategory", category);
        return modelAndView;

    }

    @RequestMapping(value = "/saveOffRequest.do",method = RequestMethod.POST)
    public ModelAndView saveOffRequest(@ModelAttribute OffRequest offRequest) {
        ModelAndView modelAndView = new ModelAndView("/offRequest/offRequest.do?c_ID=" + offRequest.getRequesterPerson().getC_ID());
        offRequestService.saveOffRequest(offRequest);

        return modelAndView;
    }
}
