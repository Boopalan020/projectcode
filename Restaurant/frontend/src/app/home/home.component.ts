import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public hotelName = 'KEC Restaurant';
  public slogan ="Deliciousness jumping into the mouth";
  public slogansize = "h4";

  constructor() { }

  ngOnInit(): void {
    
  }

}
