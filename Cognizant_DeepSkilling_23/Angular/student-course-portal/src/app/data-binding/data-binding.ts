import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-data-binding',
  imports: [
    FormsModule
  ],
  templateUrl: './data-binding.html',
  styleUrl: './data-binding.css'
})
export class DataBinding {

  title = "Student Course Portal";

  studentName = "Jannie";

  imageUrl = "https://angular.io/assets/images/logos/angular/angular.svg";

  message = "";

  showMessage() {
    this.message = "Button Click Event Worked!";
  }

}