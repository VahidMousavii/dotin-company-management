package ir.dotin.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("request")
@RequestMapping()
public class MainController {

    @RequestMapping("/")
    public ModelAndView firstPage() {
        ModelAndView modelAndView = new ModelAndView("/person/findAll.do?active=1");
        return modelAndView;
    }

}
