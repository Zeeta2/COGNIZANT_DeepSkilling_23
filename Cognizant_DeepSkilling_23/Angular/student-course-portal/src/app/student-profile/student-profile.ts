import { Component } from '@angular/core';
import { TitlecasePipe } from '../titlecase-pipe';
import { CourseService } from '../course.service';
import { NgFor } from '@angular/common';


@Component({
  selector: 'app-student-profile',
  imports: [
    TitlecasePipe,
    NgFor
  ],
  templateUrl: './student-profile.html',
  styleUrl: './student-profile.css'
})
export class StudentProfile {


  name = "Jannie Zeeta Winslet";

  course = "artificial intelligence and data science";

  year = "4th Year";


  courses: any[] = [];


  constructor(private courseService: CourseService) {


    this.courseService.getCourses()
      .subscribe(data => {

        this.courses = data;

      });


  }

}