import { Component } from '@angular/core';
import { NgIf, NgFor, NgClass, NgStyle } from '@angular/common';

@Component({
  selector: 'app-directives-demo',
  imports: [
    NgIf,
    NgFor,
    NgClass,
    NgStyle
  ],
  templateUrl: './directives-demo.html',
  styleUrl: './directives-demo.css'
})
export class DirectivesDemo {

  showCourses = true;

  courses = [
    'Angular',
    'Java',
    'Python',
    'Machine Learning'
  ];

  active = true;

}