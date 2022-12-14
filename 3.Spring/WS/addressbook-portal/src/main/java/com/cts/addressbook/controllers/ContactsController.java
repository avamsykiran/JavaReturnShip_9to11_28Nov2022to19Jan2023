package com.cts.addressbook.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.addressbook.entity.Contact;
import com.cts.addressbook.services.ContactService;

@Controller
public class ContactsController {

	@Autowired
	private ContactService contactService;

	@GetMapping({ "", "/", "/list" })
	public ModelAndView showContactsListAction() {
		return new ModelAndView("list-page", "contacts", contactService.findAll());
	}

	@GetMapping("/delContact")
	public ModelAndView delContactAction(@RequestParam("cid") Integer contactId) {
		contactService.deleteById(contactId);
		return new ModelAndView("redirect:/list");
	}

	@GetMapping("/addContact")
	public ModelAndView addContactPageAction() {
		return new ModelAndView("contact-form-page", "contact", new Contact());
	}

	@GetMapping("/editContact")
	public ModelAndView editContactAction(@RequestParam("cid") Integer contactId) {
		return new ModelAndView("contact-form-page", "contact", contactService.findById(contactId));
	}

	@PostMapping({"/addContact","/editContact"})
	public ModelAndView doSaveContactAction(@ModelAttribute("contact") @Valid Contact contact, BindingResult results) {
		ModelAndView mv = null;

		if (results.hasErrors()) {
			mv = new ModelAndView("contact-form-page", "contact", contact);
		} else {
			contactService.save(contact);
			mv = new ModelAndView("redirect:/list");
		}

		return mv;
	}

}
