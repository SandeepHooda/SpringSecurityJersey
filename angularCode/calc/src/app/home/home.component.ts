import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public items:string[];
  constructor() {
    this.items = ["App Admin", "Corp Admin"];
  }

  ngOnInit(): void {
  }

}
