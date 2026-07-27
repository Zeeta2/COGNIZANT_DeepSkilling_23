import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { vi } from 'vitest';

import { CourseCard } from './course-card';


describe('CourseCard', () => {

  let component: CourseCard;
  let fixture: ComponentFixture<CourseCard>;


  beforeEach(async () => {

    await TestBed.configureTestingModule({

      imports: [
        CourseCard
      ]

    }).compileComponents();


    fixture = TestBed.createComponent(CourseCard);

    component = fixture.componentInstance;

  });



  it('should create', () => {

    expect(component).toBeTruthy();

  });



  it('should display course name', () => {


    component.courseName = 'Angular';


    fixture.detectChanges();


    const heading =
      fixture.debugElement.query(By.css('h3'));


    expect(heading.nativeElement.textContent)
      .toContain('Angular');


  });



  it('should emit selected course', () => {


    component.courseName = 'Angular';


    const emitSpy =
      vi.spyOn(component.courseSelected, 'emit');


    fixture.detectChanges();


    const button =
      fixture.debugElement.query(By.css('button'));


    button.nativeElement.click();


    expect(emitSpy)
      .toHaveBeenCalledWith('Angular');


  });



  it('should call selectCourse method', () => {


    const methodSpy =
      vi.spyOn(component, 'selectCourse');


    fixture.detectChanges();


    const button =
      fixture.debugElement.query(By.css('button'));


    button.nativeElement.click();


    expect(methodSpy)
      .toHaveBeenCalled();


  });



  it('should have Select Course button', () => {


    fixture.detectChanges();


    const button =
      fixture.debugElement.query(By.css('button'));


    expect(button.nativeElement.textContent)
      .toContain('Select Course');


  });



});