import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-student-form',
  imports: [
    FormsModule,
    NgIf
  ],
  templateUrl: './student-form.html',
  styleUrl: './student-form.css'
})
export class StudentForm {

  student = {
    name: '',
    email: '',
    course: ''
  };

  submitted = false;


  submitForm() {

    this.submitted = true;

    console.log(this.student);

  }

}