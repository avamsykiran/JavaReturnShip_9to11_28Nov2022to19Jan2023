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
  errMsg!:string;

  constructor(private cs:ContactService){

  }

  loadData(){
    let ob = this.cs.getAll();
    ob.subscribe({
      next: data => { this.contactsList=data; },
      error: err => { console.log(err); this.errMsg="Unable to load data! Please retry later!";}
    });
  }

  ngOnInit(): void {
      this.loadData();
  }

  remove(cid:number){
    let ob = this.cs.deleteById(cid);
    ob.subscribe({
      next: () => { this.loadData(); },
      error: err => { console.log(err); this.errMsg="Unable to delete data! Please retry later!";}
    });    
  }
}
