import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Contact } from '../models/contact';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  apiUrl:string;

  constructor(private httpClient:HttpClient) { 
    this.apiUrl="http://localhost:8888/contacts";
  }

  getAll():Observable<Contact[]>{
    return this.httpClient.get<Contact[]>(this.apiUrl);
  }

  getById(cid:number):Observable<Contact>{
    return this.httpClient.get<Contact>(this.apiUrl + "/" + cid);
  }

  add(c:Contact):Observable<Contact>{
    return this.httpClient.post<Contact>(this.apiUrl,c);
  }

  update(c:Contact):Observable<Contact>{
    return this.httpClient.put<Contact>(this.apiUrl,c);
  }

  deleteById(cid:number):Observable<void>{
    return this.httpClient.delete<void>(this.apiUrl + "/" + cid);
  }
}
