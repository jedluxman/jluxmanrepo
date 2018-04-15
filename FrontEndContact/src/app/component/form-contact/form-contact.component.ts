import { Component, OnInit } from '@angular/core';
import { Contact } from '../../model/contact';
import { ContactService } from '../../service/contact.service';

@Component({
  selector: 'app-form-contact',
  templateUrl: './form-contact.component.html',
  styleUrls: ['./form-contact.component.css']
})
export class FormContactComponent implements OnInit {

  private contact = new Contact();
  constructor(private contactService_:ContactService) { }

  ngOnInit() {
  }

  createContact(){
    this.contactService_.createContact(this.contact).subscribe(
        data=>{
        console.log(data);
      },error=>{
        console.log(error);
      }
    )
  }

}
