import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Contact } from '../models/contact';
import { ContactService } from '../services/contact.service';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  contactForm: FormGroup;

  cid: FormControl;
  fnm: FormControl;
  lnm: FormControl;
  mbn: FormControl;
  mid: FormControl;
  dob: FormControl;

  isNew: boolean;

  errMsg!: string;

  constructor(private cs: ContactService, private router: Router, private activatedRoute: ActivatedRoute) {

    this.isNew = true;

    this.cid = new FormControl(0, [Validators.required]);
    this.fnm = new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]);
    this.lnm = new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(20)])
    this.mbn = new FormControl('', [Validators.required, Validators.pattern('[1-9][0-9]{9}')]);
    this.mid = new FormControl('', [Validators.required, Validators.email]);
    this.dob = new FormControl(new Date().toISOString().substring(0, 10), [Validators.required]);

    this.contactForm = new FormGroup({
      contactId: this.cid,
      firstName: this.fnm,
      lastName: this.lnm,
      mobile: this.mbn,
      mailId: this.mid,
      dateOfBirth: this.dob
    });
  }

  ngOnInit(): void {
    let cid = this.activatedRoute.snapshot.params["id"];

    if (cid) {
      this.isNew = false;
      let ob = this.cs.getById(cid);

      ob.subscribe({
        next: c => { this.contactForm.reset(c); },
        error: err => { console.log(err); this.errMsg = "Unable to laod data! Please retry later!"; }
      })
    }
  }

  formSubmited() {
    let contact = { ...this.contactForm.value, dateOfBirth: new Date(this.contactForm.value.dateOfBirth) };

    let ob = null;

    if (this.isNew) {
      ob = this.cs.add(contact);
    } else {
      ob = this.cs.update(contact);
    }

    ob.subscribe({
      next: c => { this.router.navigateByUrl("/list"); },
      error: err => { console.log(err); this.errMsg = "Unable to save data! Please retry later! "; }
    });
  }
}
