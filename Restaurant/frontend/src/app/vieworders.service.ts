import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Jsonmodel } from './jsonmodel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ViewordersService {

  public url = "http://localhost:2022/dashboard/vieworders";
  constructor(private _http : HttpClient) { }

  public filename = "orders.json";
  receivefile() : Observable<Jsonmodel[]>
  {
    return this._http.get<Jsonmodel[]>(this.url);
  }
}
