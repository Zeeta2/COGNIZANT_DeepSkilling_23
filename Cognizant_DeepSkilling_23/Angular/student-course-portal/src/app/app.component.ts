import { Component } from '@angular/core';
import { Header } from './header/header';
import { Home } from './home/home';
import { CourseList } from './course-list/course-list';
import { StudentProfile } from './student-profile/student-profile';

@Component({
  selector: 'app-root',
  imports: [
    Header,
    Home,
    CourseList,
    StudentProfile
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

}