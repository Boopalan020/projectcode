import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserLogin } from './user-login';

@Injectable({
  providedIn: 'root'
})
export class LoginserverService {

  private url = "http://localhost:2022/login";
  constructor(private _http : HttpClient) { }

  sendlogs(loginDet : UserLogin)
  {
    return this._http.post<any>(this.url, loginDet);
  }
}
