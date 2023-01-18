import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Contact } from '../models/contact';
import { ContactService } from '../services/contact.service';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent {

  contact:Contact;
  dobStr:string;

  constructor(private cs:ContactService,private router:Router){
    this.contact={contactId:0,firstName:'',lastName:'',mobile:'',mailId:'',dateOfBirth:new Date(),age:0};
    this.dobStr=this.contact.dateOfBirth.toISOString().substring(0,10);
  }

  updateDob(){
    this.contact.dateOfBirth=new Date(this.dobStr);
  }
  
  formSubmited(){
    this.cs.add(this.contact);
    this.router.navigateByUrl("/list");
  }
}
