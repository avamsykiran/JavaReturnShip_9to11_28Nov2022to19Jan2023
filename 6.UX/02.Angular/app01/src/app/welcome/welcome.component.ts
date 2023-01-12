import { Component } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent {

  userName:string;
  logos:string[];
  logoIndex:number;
  logoWidth:number;
  borderFlag:boolean;
  centerFlag:boolean;

  constructor(){
    this.userName="NoBody";
    this.logos=[
      "assets/imgs/w1.jpg",
      "assets/imgs/w2.png",
      "assets/imgs/w3.jpg"
    ];
    this.logoIndex=0;
    this.logoWidth=300;
    this.borderFlag=true;
    this.centerFlag=true;
  }

  toggle(){
    this.logoIndex++;
    if(this.logoIndex==this.logos.length){
      this.logoIndex=0;
    }
  }
}
