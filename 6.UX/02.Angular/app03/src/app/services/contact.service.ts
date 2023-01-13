import { Injectable } from '@angular/core';
import { Contact } from '../models/contact';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  contacts:Contact[];

  constructor() { 
    this.contacts=[
      {contactId:1,firstName:"Vamsy",lastName:'Aripaka',
      mobile:'9052224755',mailId:'a.v@gmail.com',dateOfBirth:new Date("1985-06-11"),age:37},
      {contactId:2,firstName:"Sagar",lastName:'Aripaka',
      mobile:'9052224733',mailId:'a.s@gmail.com',dateOfBirth:new Date("1988-06-11"),age:34}
    ];
  }

  
}
