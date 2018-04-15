import { Component, OnInit } from '@angular/core';
import { ContactService } from '../../service/contact.service';

@Component({
  selector: 'app-list-contact',
  templateUrl: './list-contact.component.html',
  styleUrls: ['./list-contact.component.css']
})
export class ListContactComponent implements OnInit {
  private contacts = [];
  constructor(private contactService_:ContactService) { }

  ngOnInit() {
    this.contactService_.getContacts().subscribe(
      data => this.contacts = data
    );
  }

}
