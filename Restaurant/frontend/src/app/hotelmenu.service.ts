import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Menumodel } from './menumodel';
import { customerviewmodel } from './jsonmodel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HotelmenuService {

  /**
   *    Purpose of this hotelMenu.service.ts
   *      ->  For Adding the Food Item to the MONGODB
   *      ->  For Deleting the Food Item from the MONGODB
   * 
   *      ->  For Fetching the Food Item to dsiplay on the 
   *          customer side
   */

  //  URL for the adding Food Item
  private add_URL : string = "http://localhost:2022/menucard/additem";
  // URL for deleting the food Item
  private del_URL : string = "http://localhost:2022/menucard/deleteItem";
  // URL for getting the Menu from the server
  private fetch_URL : string = "http://localhost:2022/customer/viewmenu";

  constructor(private http : HttpClient) { }

  // Request to add food Item
  addItem(aMenu : Menumodel)
  {
    return this.http.post<any>(this.add_URL, aMenu);
  }

  // Request to DElete the Food Item
  delMenu(dMenu : Menumodel)
  {
    return this.http.post<any>(this.del_URL, dMenu);
  }

  // REquest to Fetch data to display on the Customer side
  showmenu() : Observable<customerviewmodel[]>
  {
    return this.http.get<customerviewmodel[]>(this.fetch_URL)
  }

}
