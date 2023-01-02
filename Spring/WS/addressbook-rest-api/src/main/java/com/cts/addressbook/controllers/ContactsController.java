package com.cts.addressbook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.addressbook.entity.Contact;
import com.cts.addressbook.exceptions.InvalidDataException;
import com.cts.addressbook.exceptions.NotFoundException;
import com.cts.addressbook.services.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping
	public ResponseEntity<List<Contact>> sendAllContactsAction(){
		return new ResponseEntity<List<Contact>>(contactService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{cid}")
	public ResponseEntity<Contact> sendAContactByIdAction(@PathVariable("cid") int contactId) throws NotFoundException{
		Contact contact = contactService.findById(contactId);
		
		if(contact==null) {
			throw new NotFoundException("Contact for the given contactId is not found");
		}
		
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}
	
	@DeleteMapping("/{cid}")
	public ResponseEntity<Void> deleteAContactByIdAction(@PathVariable("cid") int contactId) throws NotFoundException{
		Contact contact = contactService.findById(contactId);
		
		if(contact==null) {
			throw new NotFoundException("Contact for the given contactId is not found");
		}
		
		contactService.deleteById(contactId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public ResponseEntity<Contact> addContactAction(@RequestBody @Valid Contact contact,
			BindingResult results) throws InvalidDataException{
		
		if(results.hasErrors()) {
			String errMsgs= results.getAllErrors().stream().
						map(ObjectError::getDefaultMessage).
						reduce((m1,m2) -> m1+","+m2).orElse("");
			throw new InvalidDataException(errMsgs);
		}
		
		contact = contactService.save(contact);
		return new ResponseEntity<Contact>(contact,HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Contact> updateContactAction(@RequestBody @Valid Contact contact,
			BindingResult results) throws InvalidDataException{
		
		if(results.hasErrors()) {
			String errMsgs= results.getAllErrors().stream().
						map(ObjectError::getDefaultMessage).
						reduce((m1,m2) -> m1+","+m2).orElse("");
			throw new InvalidDataException(errMsgs);
		}
		
		contact = contactService.save(contact);
		return new ResponseEntity<Contact>(contact,HttpStatus.CREATED);
	}
}
