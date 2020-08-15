package ir.dotin.controller;

import ir.dotin.repository.OffRequestDA;
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

import java.util.List;

@Controller
@Scope("request")
@RequestMapping("/offRequest")

public class OffRequestController {


    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PersonService personService;
    @Autowired
    private OffRequestService offRequestService;

    @RequestMapping("/offRequest.do")
    public ModelAndView showOffRequest(@ModelAttribute Person person) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/offRequest.jsp");
        List<OffRequest> offRequestList = offRequestService.getOffRequestListByPersonId(person.getID());
        Category category = categoryService.loadCategoryById(1L);
        Person loadedPerson = personService.loadPerson(person.getID());
        modelAndView.addObject("offRequests", offRequestList);
        modelAndView.addObject("offCategory", category);
        modelAndView.addObject("person", loadedPerson);
        return modelAndView;

    }

    @RequestMapping(value = "/saveOffRequest.do", method = RequestMethod.POST)
    public ModelAndView saveOffRequest(@ModelAttribute OffRequest offRequest) {
        ModelAndView modelAndView = new ModelAndView("/offRequest/offRequest.do?ID=" + offRequest.getRequesterPerson().getID());
        offRequestService.saveOffRequest(offRequest);

        return modelAndView;
    }
}
