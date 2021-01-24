import { Component, OnInit } from '@angular/core';
import { HotelmenuService } from '../hotelmenu.service';
import { Jsonmodel, customerviewmodel } from '../jsonmodel';
import { ServerplaceorderService } from '../serverplaceorder.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  constructor(private http: HotelmenuService, private httpOrder: ServerplaceorderService) { }

  public info: boolean = true;
  public menuView: boolean = false;
  public views = [];
  
  public ordering = {
    ok : true,
    success : "",
    classname : ""
  };

  public customerorder: Jsonmodel = {
    _id : "",
    Customer: "",
    Table: "",
    Dishes: [],
    Bill: 0
  }

  private garbage = [];
  private flag: boolean = false;
  private tFlag : boolean = false;
  private ind: number;

  ngOnInit(): void {
  }

  // WHILE CLICKING ON THE 'Order Now ' BUTTON
  public onOrderNow() {
    this.http.showmenu()
      .subscribe(
        data => {

          for (let x = 0; x < data.length; x++) {
            data[x].quant = "0"
          }

          this.views = data;

          console.log(this.views);
        },
        err => console.log('failed ', err)
      );

    this.info = !this.info;
    this.menuView = !this.menuView;
  }

  // WHILE CHECKING A PARTICULAR CHECK BOX FOOD ITEM
  onCheck(id) {
    console.log("Clicked ID : " + id);

    for (let i = 0; i < this.garbage.length; i++) {
      if (this.garbage[i] == id) {
        this.flag = true;
        break;
      }
      else {
        this.flag = false;
      }
    }

    if (this.flag == false) {
      this.garbage.push(id);
      for (let i = 0; i < this.views.length; i++) {
        if (this.views[i]._id == id) {
          this.customerorder.Dishes.push(this.views[i].food_name);
          this.customerorder.Bill += (Number(this.views[i].price) * Number(this.views[i].quant) );
          
          break;
        }
      }
    }
    else if (this.flag == true) {
      for (let i = 0; i < this.views.length; i++) {
        if (this.views[i]._id == id) {
          this.ind = this.customerorder.Dishes.indexOf(this.views[i].food_name);
          this.customerorder.Dishes.splice(this.ind, 1);
          this.customerorder.Bill -= (Number(this.views[i].price) * Number(this.views[i].quant) );
          break;
        }
      }
      this.ind = this.garbage.indexOf(id);
      this.garbage.splice(this.ind, 1);
      this.flag = false;
    }
    console.log(this.garbage);
    console.log(this.customerorder.Dishes);
    console.log(this.customerorder.Bill);
  }

  // On submiting the selected food item
  onPlaceOrder() {
    var inx;
    for (let l = 0; l < this.views.length; l++) {
      var elementL = this.views[l];

      for (let m = 0; m < this.garbage.length; m++) {
        var elementM = this.garbage[m];
        
        if( elementL._id == elementM )
        {
          console.log("Matched");
          inx = this.customerorder.Dishes.indexOf(elementL.food_name)
          this.customerorder.Dishes[inx] = this.customerorder.Dishes[inx] + "(" + elementL.quant + ")";
          break;
        }
      }
    }

    console.log(this.customerorder)
    this.httpOrder.sendOrder(this.customerorder)
    .subscribe(
      data => {
        this.ordering = {
          ok : data.ok,
          success : data.Message,
          classname : "alert-success"
        }
      },
      err => {
        this.ordering = {
          ok : true,
          success : "Failed to Place Order. Try again later",
          classname : "alert-danger"
        }
      }
    );
  }

  quantsChange(changedValue, changedID)
  {
    console.log("ID " + changedID);
    for (let i = 0; i < this.views.length; i++) {
      if (this.views[i]._id == changedID) {
        
        var q;
        // Entering the Quantity for the 1st time
        if(changedValue == "")
        {
          this.customerorder.Bill -= (Number(this.views[i].price) * Number(this.views[i].quant));
          this.views[i].quant = "0";
        }
        
        if(this.views[i].quant == "0")
        {
          this.views[i].quant = changedValue;
          q = changedValue;
          this.customerorder.Bill += (Number(this.views[i].price) * Number(this.views[i].quant));
        }
        else if(Number(changedValue) > Number(this.views[i].quant))
        {
          console.log("Value is greater the quantity");
          q = Number(changedValue) - Number(this.views[i].quant)
          this.customerorder.Bill = this.customerorder.Bill + ( Number(this.views[i].price) * q);
          this.views[i].quant = changedValue;
        }
        else if(Number(changedValue) < Number(this.views[i].quant))
        {
          console.log("Value is less than the quantity");
          q = Number(this.views[i].quant) - Number(changedValue)
          this.customerorder.Bill = this.customerorder.Bill - ( Number(this.views[i].price) * q);
          this.views[i].quant = changedValue;
        }

        // this.customerorder.Bill = this.customerorder.Bill + ( Number(this.views[i].price) * (Number(this.views[i].quant) - Number(changedValue)) )
        console.log(this.customerorder)
        break;
      }
    }
  }

}
