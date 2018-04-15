import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Contact } from '../model/contact';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ContactService {
  private baseurl_:String = "http://localhost:8080";
  private httpheader_={headers: new HttpHeaders({'Content-type':'application/json'})};
  constructor(private _http:HttpClient) { }

  getContacts(): Observable<Contact[]>{
    return this._http.get<Contact[]>(this.baseurl_+'/contacts',this.httpheader_)
  }

  /*getContacts(): Observable<Contact[]>{
   return this._http.get<Contact[]>(this.baseUrl+'/contacts',this.httpheader);
   }*/

}
