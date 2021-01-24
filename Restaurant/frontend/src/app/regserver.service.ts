import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserReg } from './registerDetail';
import { registerResp as rsp } from './serverResponses/registerResponse'

@Injectable({
  providedIn: 'root'
})
export class RegserverService {

  private __url = "http://localhost:2022/register";
  constructor(private __http : HttpClient) { }

  sendReg(user : UserReg)
  {
    return this.__http.post<rsp>(this.__url, user);
  }
}
