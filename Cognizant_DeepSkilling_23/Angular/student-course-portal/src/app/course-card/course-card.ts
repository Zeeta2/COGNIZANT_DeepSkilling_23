import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-course-card',
  imports: [],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard {

  @Input() courseName: string = '';

  @Output() courseSelected = new EventEmitter<string>();

  selectCourse() {
    this.courseSelected.emit(this.courseName);
  }

}