import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { provideHttpClient } from '@angular/common/http';

import { provideStore, provideState } from '@ngrx/store';
import { provideEffects } from '@ngrx/effects';
import { provideStoreDevtools } from '@ngrx/store-devtools';

import { routes } from './app.routes';

import { courseReducer } from './course/course.reducer';
import { enrollmentReducer } from './enrollment/enrollment.reducer';

import { CourseEffects } from './course/course.effects';

export const appConfig: ApplicationConfig = {

  providers: [

    provideRouter(routes),

    provideHttpClient(),

    provideStore(),

    provideState(
      'course',
      courseReducer
    ),

    provideState(
      'enrollment',
      enrollmentReducer
    ),

    provideEffects([
      CourseEffects
    ]),

    provideStoreDevtools({
      maxAge: 25
    })

  ]

};