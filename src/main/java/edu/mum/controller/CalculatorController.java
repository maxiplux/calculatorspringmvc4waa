package edu.mum.controller;


import edu.mum.domain.Calculator;
import edu.mum.validator.CalculatorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
public class CalculatorController {

    @Autowired
    CalculatorValidator calculateValidator;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String calculatorInput(Model model) throws Exception {
        ModelAndView mav = new ModelAndView("ProductForm");
        return "calculator";
    }


    @RequestMapping(value = "/result/result-pgr", method = RequestMethod.GET)
    public String doLogin(HttpServletRequest request, Model model) {
        String msg = request.getParameter("msg");

        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        Calculator calculator = (Calculator) flashMap.get("calculator");
        model.addAttribute("calculator", calculator);

        model.addAttribute("msg", msg);

        return "result-pgr";
    }

    //@RequestMapping(value="/result/result-pgr", method=RequestMethod.GET)
    public String result(@RequestParam("msg") String msg, @RequestParam("sum") String sum, @RequestParam("product") String product, Model model) {
        model.addAttribute("msg", msg);
        model.addAttribute("sum", sum);
        model.addAttribute("product", product);
        return "result-pgr";
    }


    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String handleForm(Calculator calculator, RedirectAttributes redirectAttributes) throws Exception {

        System.out.println("This is test for result");
        List<String> errors = calculateValidator.validate(calculator);
        ModelAndView mav = new ModelAndView("result-pgr");

        if (errors.isEmpty() || errors == null) {


            redirectAttributes.addFlashAttribute("calculator", calculator);

            redirectAttributes.addAttribute("sum", "" + calculator.getSum());
            redirectAttributes.addAttribute("product", "" + calculator.getProduct());
            redirectAttributes.addAttribute("msg", "Hi! this calculation was performed  using prg ");


            redirectAttributes.addAttribute("msg", "this calculation was performed using flash attributes and PRG PATTERNS");


            return "redirect:result-pgr";

        } else {
            mav = new ModelAndView("calculator");
            mav.addObject("errors", errors);
            mav.addObject("newcalculator", calculator);
            return "calculator";
        }

    }

}
