package ir.dotin.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleException(Exception e) {
        Random rand = new Random();
        Integer random = rand.nextInt() & Integer.MAX_VALUE;
        ;
        System.out.print(random);
        e.printStackTrace();
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/error/error.jsp");
        String message = "خطا رخ داده لظفا با پشتیبانی تماس یگیرید شماره پیگیری " + random;
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @ExceptionHandler(value = DotinException.class)
    public ModelAndView handleDotinException(DotinException dotinException) {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/error/error.jsp");
        String message = dotinException.content;
        modelAndView.addObject("message", message);
        return modelAndView;
    }



}