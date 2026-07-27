import { Component } from '@angular/core';
import { ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import { NgIf } from '@angular/common';


@Component({
  selector: 'app-reactive-form',
  imports: [
    ReactiveFormsModule,
    NgIf
  ],
  templateUrl: './reactive-form.html',
  styleUrl: './reactive-form.css'
})
export class ReactiveForm {


  studentForm = new FormGroup({

    name: new FormControl('', [
      Validators.required,
      Validators.minLength(3)
    ]),

    email: new FormControl('', [
      Validators.required,
      Validators.email
    ]),

    course: new FormControl('', [
      Validators.required
    ])

  });


  submitted = false;


  submitForm(){

    this.submitted = true;

    console.log(this.studentForm.value);

  }

}