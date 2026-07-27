import { Component } from '@angular/core';
import { UserService } from '../user.service';
import { NgFor } from '@angular/common';


@Component({
  selector: 'app-http-demo',
  imports: [
    NgFor
  ],
  templateUrl: './http-demo.html',
  styleUrl: './http-demo.css'
})
export class HttpDemo {

  users: any[] = [];


  constructor(private userService: UserService) {

    this.userService.getUsers()
      .subscribe(data => {

        this.users = data;

      });

  }

}