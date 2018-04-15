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
  private contactError:Contact;
  private isCreated:boolean=false;


  constructor(private contactService_:ContactService) { }

  ngOnInit() {
  }

  createContact(){
    this.contactService_.createContact(this.contact).subscribe(
        data=>{
        console.log(data);
          this.isCreated = true;
          this.contact = new Contact();
      },error=>{
        this.contactError = error.error;
        this.isCreated = false;
        if(error.status==409){
          this.isCreated = false;
        }
        console.log(error);
      }
    )
  }

}
