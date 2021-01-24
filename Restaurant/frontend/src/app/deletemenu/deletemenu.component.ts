import { Component, OnInit } from '@angular/core';
import { Menumodel } from '../menumodel';
import { HotelmenuService } from '../hotelmenu.service';

@Component({
  selector: 'app-deletemenu',
  templateUrl: './deletemenu.component.html',
  styleUrls: ['./deletemenu.component.css']
})
export class DeletemenuComponent implements OnInit {

  constructor(private hotelservice: HotelmenuService) { }

  ngOnInit(): void {
  }

  public deleting = {
    ok: false,
    success: "",
    classname: ""
  }

  public Dmenu: Menumodel =
    {
      categ: "",
      foodname: "",
      price: 0
    };

  public onDelete() {
    console.log(this.Dmenu);
    this.hotelservice.delMenu(this.Dmenu)
      .subscribe(
        data => { 
          console.log('success', data) 
          this.deleting = {
            ok : true,
            success : data.success,
            classname : "alert-success"
          }
        },
        err => {
          this.deleting = {
            ok : true,
            success : "Failed to Delete Food Item from Menu Card or Food item not found",
            classname : "alert-danger"
          }
        }
      );
  }
}
