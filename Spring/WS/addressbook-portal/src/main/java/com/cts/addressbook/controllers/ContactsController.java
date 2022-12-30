package com.cts.addressbook.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.addressbook.entity.Contact;
import com.cts.addressbook.services.ContactService;

@Controller
public class ContactsController {
	
	@Autowired
	private ContactService contactService;

	@GetMapping({"","/","/list"})
	public ModelAndView showContactsListAction() {
		return new ModelAndView("list-page","contacts",contactService.findAll());
	}
	
	@GetMapping("/addContact")
	public ModelAndView addContactPageAction() {
		return new ModelAndView("contact-form-page","contact",new Contact());
	}

	@PostMapping("/addContact")
	public ModelAndView doAddContactAction(@ModelAttribute("contact") @Valid Contact contact,BindingResult results) {
		ModelAndView mv=null;
		
		if(results.hasErrors()) {
			mv =new ModelAndView("contact-form-page","contact",contact);
		}else {
			contactService.save(contact);
			mv = new ModelAndView("list-page","contacts",contactService.findAll());
		}
		
		return mv;
	}

}
