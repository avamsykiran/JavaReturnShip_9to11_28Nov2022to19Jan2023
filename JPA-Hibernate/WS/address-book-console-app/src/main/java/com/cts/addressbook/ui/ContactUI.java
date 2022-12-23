package com.cts.addressbook.ui;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.cts.addressbook.entity.Contact;
import com.cts.addressbook.services.ContactService;
import com.cts.addressbook.services.ContactServiceImpl;

public class ContactUI {

	private static Scanner scan = new Scanner(System.in);
	private static ContactService service = new ContactServiceImpl();
	
	public static void main(String args[]) {
		
		Menu option = null;
		String optionStr = Arrays.stream(Menu.values()).map(m -> m.toString()).reduce((m1,m2) -> (m1 + "/" + m2)).orElse("");
		while(option!=Menu.QUIT) {
			System.out.print(optionStr +"? ");
			option = Menu.valueOf(scan.next().toUpperCase());
			
			switch (option) {
			case SAVE: doSave();break;
			case LIST: doList();break;
			case DELETE: doDelete();break;
			case QUIT: System.out.println("BYE");;break;
			}
		}
	}
	
	private static void doSave() {
		Contact c = new Contact();
		System.out.print("Contact Id? ");	
		c.setContactId(scan.nextInt());
		System.out.print("First Name? ");
		c.setFirstName(scan.next());
		System.out.print("Last Name? ");
		c.setLastName(scan.next());
		System.out.print("Mobile Number? ");
		c.setMobile(scan.next());
		System.out.print("MailId? ");
		c.setMailId(scan.next());
		System.out.print("Date of birth (yyyy-MM-dd)? ");
		c.setDateOfBirth(LocalDate.parse(scan.next()));
		service.save(c);
		System.out.println("Saved Successfully!");
	}

	private static void doDelete() {
		System.out.print("Contact Id? ");
		int cid = scan.nextInt();
		service.deleteById(cid);
	}
	
	private static void doList() {
		List<Contact> contacts =service.findAll();
		if(contacts.isEmpty())
			System.out.println("No Contacts Found");
		else
			contacts.stream().forEach(System.out::println);
	}
}
