import { Component, OnInit } from '@angular/core';
import { Contact } from '../models/contact';
import { ContactService } from '../services/contact.service';

@Component({
  selector: 'app-contacts-list',
  templateUrl: './contacts-list.component.html',
  styleUrls: ['./contacts-list.component.css']
})
export class ContactsListComponent implements OnInit{

  contactsList!:Contact[];

  constructor(private cs:ContactService){

  }

  loadData(){
    this.contactsList=this.cs.getAll();
  }

  ngOnInit(): void {
      this.loadData();
  }

  remove(cid:number){
    this.cs.deleteById(cid);
    this.loadData();
  }
}
