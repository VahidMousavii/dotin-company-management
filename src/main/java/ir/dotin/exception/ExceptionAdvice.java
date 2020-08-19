package ir.dotin.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class ExceptionAdvice {


    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleException(Exception e) {
        e.printStackTrace();
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/error/error.jsp");
        modelAndView.addObject("message", e);
        return modelAndView;
    }

}