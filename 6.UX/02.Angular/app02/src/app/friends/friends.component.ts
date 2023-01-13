import { Component } from '@angular/core';

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})
export class FriendsComponent {

  friends:string[];
  friend:string;

  constructor(){
    this.friend="";
    this.friends=[];
  }

  add(){
    if(this.friend.trim().length>0){
      this.friends.push(this.friend);
      this.friend="";
    }
  }

  remove(){
    if(this.friend.trim().length>0){
      let index = this.friends.findIndex(f => f==this.friend);
      this.friends.splice(index,1);
      this.friend="";
    }
  }
}
