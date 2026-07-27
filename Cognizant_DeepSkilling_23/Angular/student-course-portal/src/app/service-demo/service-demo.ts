import { Component } from '@angular/core';
import { CourseService } from '../course.service';
import { NgFor } from '@angular/common';


@Component({
  selector: 'app-service-demo',
  imports: [
    NgFor
  ],
  templateUrl: './service-demo.html',
  styleUrl: './service-demo.css'
})
export class ServiceDemo {

  courses: any[] = [];


  constructor(private courseService: CourseService) {


    this.courseService.getCourses()
      .subscribe(data => {

        this.courses = data;

      });


  }

}