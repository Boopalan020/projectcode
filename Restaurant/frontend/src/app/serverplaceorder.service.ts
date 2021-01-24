import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Jsonmodel } from './jsonmodel';


@Injectable({
  providedIn: 'root'
})
export class ServerplaceorderService {

  private url = "http://localhost:2022/customer/placeorder";
  constructor(private http : HttpClient) { }

  sendOrder(orders : Jsonmodel)
  {
    return this.http.post<any>(this.url, orders);
  }

}
