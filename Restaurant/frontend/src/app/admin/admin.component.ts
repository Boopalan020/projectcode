import { Component, OnInit } from '@angular/core';

// classes for the forms
import { UserReg } from '../registerDetail';
import { UserLogin } from '../user-login';

// services
import { RegserverService } from '../regserver.service';
import { LoginserverService } from '../loginserver.service';

// Receiveing format of server response
import { registerResp } from '../serverResponses/registerResponse';
import { from } from 'rxjs';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  user = new UserReg("", "", "", "", "", "");
  userLog = new UserLogin("", "");

  public loginDiv = true;
  public dashboardDiv = false;
  public loginError = false;
  public UserName = "";

  public serverresponse: registerResp = {
    ok: false,
    success: ""
  };

  constructor(private _register: RegserverService, private _login : LoginserverService) { }

  ngOnInit(): void {
  }

  public onresetclose()
  { 
    this.loginError = false;
  }

  // for toggling between the register oage and login page
  public adminChoice = 'login';
  toggleLogin() {
    this.adminChoice = 'register';
  }
  toggleRegister() {
    this.adminChoice = 'login';
  }
  // toggleing btw the register page

  // Submitting the data to the server  ---> nodeServer
  public onSubmit() {
    this._register.sendReg(this.user)
      .subscribe(
        data => {
          console.log(" OKS : " + data.ok);
          console.log(" SUCCESSS : " + data.success);
          this.serverresponse = data;
        },
        err => {
          console.log('failed ', err);
          this.serverresponse = {
            ok : true,
            success : "Failed to create your account. Please try again leter."
          }
        }
      );
  }

  // On submitting the user login form
  public loginNow() {
    console.log(this.userLog);
    this._login.sendlogs(this.userLog)
    .subscribe(
      data => {
        this.loginDiv = !data.found;
        this.dashboardDiv = data.found;
        this.UserName = data.result.User_Name;
        this.loginError = false;
        console.log('success', data);
      },
      error => {
        console.log("Failed to login : ", error);
        this.loginError = true;
      }
    );
  }

}
