import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ContactService } from '../services/contact.service';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent {

  contactForm:FormGroup;

  constructor(private cs:ContactService,private router:Router){
    this.contactForm=new FormGroup({
      contactId:new FormControl(0,[Validators.required]),
      firstName:new FormControl('',[Validators.required]),
      lastName:new FormControl('',[Validators.required]),
      mobile:new FormControl('',[Validators.required]),
      mailId:new FormControl('',[Validators.required]),
      dateOfBirth:new FormControl(new Date().toISOString().substring(0,10),[Validators.required])
    });
  }

  formSubmited(){
    let contact = {...this.contactForm.value,dateOfBirth:new Date(this.contactForm.value.dateOfBirth)};
    this.cs.add(contact);
    this.router.navigateByUrl("/list");
  }
}
