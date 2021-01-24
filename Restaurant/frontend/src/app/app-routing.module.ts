import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { CustomerComponent } from './customer/customer.component';
import { AdminComponent } from './admin/admin.component';

const routes: Routes = [
  { path : '', component :  HomeComponent },
  { path : 'customer', component : CustomerComponent },
  { path : 'admin', component : AdminComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponent = [ HomeComponent, CustomerComponent, AdminComponent ];
