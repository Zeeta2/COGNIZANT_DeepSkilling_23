import { Routes } from '@angular/router';

import { Home } from './home/home';
import { CourseList } from './course-list/course-list';
import { StudentProfile } from './student-profile/student-profile';
import { About } from './about/about';
import { Contact } from './contact/contact';

import { authGuard } from './auth-guard';

export const routes: Routes = [

  {
    path: '',
    component: Home
  },

  {
    path: 'courses',
    component: CourseList
  },

  {
    path: 'profile',
    component: StudentProfile,
    canActivate: [authGuard]
  },

  {
    path: 'about',
    loadComponent: () =>
      import('./about/about')
        .then(m => m.About)
  },

  {
    path: 'contact',
    component: Contact
  },

  {
    path: '**',
    redirectTo: ''
  }

];