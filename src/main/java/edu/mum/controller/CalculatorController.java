package edu.mum.controller;


import edu.mum.domain.Calculator;
import edu.mum.validator.CalculatorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class CalculatorController {

    @Autowired
    CalculatorValidator calculateValidator;


    @RequestMapping(value = "/calculator/", method = RequestMethod.GET)
    public String calculatorInput() throws Exception {
        ModelAndView mav = new ModelAndView("ProductForm");
        return "calculator";
    }

    @RequestMapping(value = "/result")
    public String handleForm(Calculator calculator, RedirectAttributes redirectAttributes) throws Exception {

        System.out.println("This is test for result");
        List<String> errors = calculateValidator.validate(calculator);
        ModelAndView mav = new ModelAndView("result");

        if (errors.isEmpty() || errors == null) {

            mav.addObject("calculator", calculator);
            mav.addObject("sum", calculator.getSum());
            mav.addObject("product", calculator.getProduct());

            return "result";

        } else {
            mav = new ModelAndView("result");
            mav.addObject("errors", errors);
            mav.addObject("calculator", calculator);
            return "calculator";
        }

    }

}
