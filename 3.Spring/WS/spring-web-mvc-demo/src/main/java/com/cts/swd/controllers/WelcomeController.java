package com.cts.swd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.swd.models.Loan;
import com.cts.swd.service.LoanService;

@Controller
public class WelcomeController {
	
	@Autowired
	private LoanService loanService;

	//@RequestMapping(value= {"","/","/home"},method=RequestMethod.GET)
	@GetMapping({"","/","/home"})
	public String defaultRequestAction() {
		return "home";
	}
	
	@GetMapping("/greet")
	public ModelAndView greetRequestAction(@RequestParam(name="unm",required=false) String userName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("greet");
		mv.addObject("greeting",userName==null?"Hello Everybody":("Hello "+userName));
		return mv;
	}
	
	@GetMapping("/loan")
	public String showLoanPageAction() {
		return "loan-page";
	}
	
	@PostMapping("/loan")
	public ModelAndView computeLoanAction(@ModelAttribute Loan loan) {
		loanService.compute(loan);
		//return new ModelAndView("loan-page","si",loan.getSimpleInterest());
		return new ModelAndView("loan-page","loan",loan);
	}
}
