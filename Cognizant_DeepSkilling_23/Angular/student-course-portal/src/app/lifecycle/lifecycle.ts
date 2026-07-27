import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lifecycle',
  imports: [],
  templateUrl: './lifecycle.html',
  styleUrl: './lifecycle.css'
})
export class Lifecycle implements OnInit {

  message = "Component Initialized Successfully";

  ngOnInit() {

    console.log("Lifecycle component created");

  }

}