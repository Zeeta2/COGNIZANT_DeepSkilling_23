import { TestBed } from '@angular/core/testing';
import { provideHttpClient } from '@angular/common/http';
import {
  HttpTestingController,
  provideHttpClientTesting
} from '@angular/common/http/testing';

import { CourseService } from './course.service';

describe('CourseService', () => {

  let service: CourseService;
  let httpMock: HttpTestingController;

  beforeEach(() => {

    TestBed.configureTestingModule({
      providers: [
        CourseService,
        provideHttpClient(),
        provideHttpClientTesting()
      ]
    });

    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);

  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should get courses', () => {

    const mockCourses = [
      {
        id: 1,
        name: 'Angular',
        duration: '6 Weeks'
      },
      {
        id: 2,
        name: 'Java',
        duration: '4 Weeks'
      }
    ];

    service.getCourses().subscribe((courses) => {
      expect(courses.length).toBe(2);
      expect(courses[0].name).toBe('Angular');
    });

    const req = httpMock.expectOne(
      'https://jsonplaceholder.typicode.com/users'
    );

    expect(req.request.method).toBe('GET');

    req.flush(mockCourses);

  });

});