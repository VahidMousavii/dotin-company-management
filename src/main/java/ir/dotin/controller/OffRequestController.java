package ir.dotin.controller;

import ir.dotin.entity.SubCategory;
import ir.dotin.repository.OffRequestDA;
import ir.dotin.entity.Category;
import ir.dotin.entity.OffRequest;
import ir.dotin.entity.Person;
import ir.dotin.service.CategoryService;
import ir.dotin.service.OffRequestService;
import ir.dotin.service.PersonService;
import ir.dotin.to.OffRequestDTO;
import ir.dotin.to.PersonDTO;
import ir.dotin.to.SubCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
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
    public ModelAndView showOffRequest(@ModelAttribute PersonDTO person) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/offRequest.jsp");
        List<OffRequestDTO> offRequestList = offRequestService.getOffRequestListByPersonId(person.getID());
        List<SubCategoryDTO> offRequestType = categoryService.loadSubCategoriesByName("typeOfRequest");
        PersonDTO loadedPerson = personService.loadPerson(person.getID());
        List<OffRequestDTO> pendingOffRequestsOfManager = personService.findPendingOffRequestsOfManager(loadedPerson);
        modelAndView.addObject("offRequests", offRequestList);
        modelAndView.addObject("offRequestType", offRequestType);
        modelAndView.addObject("person", loadedPerson);
        modelAndView.addObject("pendingOffRequestsOfManager", pendingOffRequestsOfManager);
        return modelAndView;

    }

    @RequestMapping(value = "/saveOffRequest.do", method = RequestMethod.POST)
    public ModelAndView saveOffRequest(@ModelAttribute OffRequestDTO offRequestDTO) {
        ModelAndView modelAndView = new ModelAndView("/offRequest/offRequest.do?ID=" + offRequestDTO.getRequesterPerson().getID());
        offRequestService.saveOffRequest(offRequestDTO);
        return modelAndView;
    }

    @RequestMapping(value = "/confirmOffRequest.do", method = RequestMethod.GET)
    public ModelAndView confirmOffRequest(@ModelAttribute OffRequestDTO offRequestDTO) {
        ModelAndView modelAndView = new ModelAndView("/person/findAll.do?active=1");
        offRequestService.confirmStatus(offRequestDTO);
        return modelAndView;
    }
    @RequestMapping(value = "/rejectOffRequest.do", method = RequestMethod.GET)
    public ModelAndView rejectOffRequest(@ModelAttribute OffRequestDTO offRequestDTO) {
        ModelAndView modelAndView = new ModelAndView("/person/findAll.do?active=1");
        offRequestService.rejectStatus(offRequestDTO);
        return modelAndView;
    }
}
