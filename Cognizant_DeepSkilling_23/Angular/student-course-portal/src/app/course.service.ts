import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Course } from './course/course.model';


@Injectable({
  providedIn: 'root'
})
export class CourseService {


  private apiUrl =
  'https://jsonplaceholder.typicode.com/users';


  constructor(
    private http: HttpClient
  ){}


  getCourses(){

    return this.http.get<Course[]>(this.apiUrl);

  }

}