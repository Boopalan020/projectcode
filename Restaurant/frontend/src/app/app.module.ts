import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// imported by me
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule, routingComponent } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CustommenuComponent } from './custommenu/custommenu.component';
import { DeletemenuComponent } from './deletemenu/deletemenu.component';

@NgModule({
  declarations: [
    AppComponent,
    routingComponent,
    HomeComponent,
    DashboardComponent,
    CustommenuComponent,
    DeletemenuComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
