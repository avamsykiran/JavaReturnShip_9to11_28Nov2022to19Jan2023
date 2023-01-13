import { Component } from '@angular/core';

@Component({
  selector: 'app-pipes-demo',
  templateUrl: './pipes-demo.component.html',
  styleUrls: ['./pipes-demo.component.css']
})
export class PipesDemoComponent {

  str:string;
  num:number;
  dt:Date;

  constructor(){
    this.str="hello! How are you?";
    this.num=1234.5678;
    this.dt=new Date();
  }

}
