import { Component } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';

import { Header } from './header/header';
import { HttpDemo } from './http-demo/http-demo';


@Component({
  selector: 'app-root',
  imports: [
    Header,
    RouterOutlet,
    RouterLink,
    HttpDemo
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

}