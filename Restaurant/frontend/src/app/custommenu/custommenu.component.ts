import { Component, OnInit } from '@angular/core';
import { Menumodel } from '../menumodel';
import { HotelmenuService } from '../hotelmenu.service';

@Component({
  selector: 'app-custommenu',
  templateUrl: './custommenu.component.html',
  styleUrls: ['./custommenu.component.css']
})
export class CustommenuComponent implements OnInit {

  constructor(private hotelservice : HotelmenuService) { }

  public adding = {
    ok: false,
    success : "",
    classname : ""
  };

  ngOnInit(): void {
  }

  public menu : Menumodel = 
  {
    categ : "",
    foodname : "",
    price : 0
  };

  public onAdd()
  {
    console.log(this.menu);
    this.hotelservice.addItem(this.menu)
    .subscribe(
      data => {
        console.log('Adding menu success',data);
        this.adding.ok = true;
        this.adding.success = data.success;
        this.adding.classname = "alert-success"
      },
      err => {
        console.log('Failed ', err);
        this.adding.ok = true;
        this.adding.success = "Failed to add Food Item. Try again Later";
        this.adding.classname = "alert-danger"
      }
    );
  }

}
