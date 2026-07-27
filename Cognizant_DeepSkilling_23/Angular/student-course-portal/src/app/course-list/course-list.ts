import { Component, OnInit } from '@angular/core';
import { NgFor, NgIf, AsyncPipe } from '@angular/common';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';

import { Course } from '../course/course.model';

import { loadCourses } from '../course/course.actions';
import { selectAllCourses } from '../course/course.selectors';

import {
  enrollInCourse,
  unenrollFromCourse
} from '../enrollment/enrollment.actions';

import { selectEnrolledIds } from '../enrollment/enrollment.selectors';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [
    NgFor,
    NgIf,
    AsyncPipe
  ],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {

  courses$!: Observable<Course[]>;
  enrolledIds$!: Observable<number[]>;

  constructor(private store: Store) {}

  ngOnInit(): void {

    this.courses$ = this.store.select(selectAllCourses);

    this.enrolledIds$ = this.store.select(selectEnrolledIds);

    this.store.dispatch(loadCourses());

  }

  enroll(id: number): void {

    this.store.dispatch(
      enrollInCourse({ courseId: id })
    );

  }

  unenroll(id: number): void {

    this.store.dispatch(
      unenrollFromCourse({ courseId: id })
    );

  }

  isEnrolled(id: number, ids: number[] | null): boolean {

    return ids ? ids.includes(id) : false;

  }

}