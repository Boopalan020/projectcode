import { Component, OnInit } from '@angular/core';
import { Input, Output } from '@angular/core';

// importing the service
import { ViewordersService } from '../vieworders.service';
import { Jsonmodel } from '../jsonmodel';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  public showBill : Jsonmodel = {
    _id : "",
    Customer : "",
    Table : "",
    Dishes : [],
    Bill : 0
  };

  public enable = false;

  constructor(private vieworders : ViewordersService) { }

  ngOnInit(): void {
  }

  @Input() public name;
  public incomingorders = [];

  public decideView = "viewOrder";
 
  // Toggling between the pages
  public onView()
  {
    this.decideView = "viewOrder";
    this.vieworders.receivefile()
    .subscribe(
      data => 
      {
        this.incomingorders = data;
      },
      error => console.log('failed ', error)
    );
  }
  public onAddMenu()
  {
    this.decideView = "customizeMenu";
  }
  public onDeleteMenu()
  {
    this.decideView = "deleteMenu";
  }
  /************/

  // ON clicking the view button
  public onViewBill(c_order)
  {
    this.showBill = c_order;
    this.enable = true;
  }

  onPrintOrder()
  {
    console.log(this.showBill);
  }

}
