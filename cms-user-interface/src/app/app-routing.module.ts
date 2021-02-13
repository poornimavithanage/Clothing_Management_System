import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddCustomerComponent} from "./add-customer/add-customer.component";
import {ViewCustomerComponent} from "./view-customer/view-customer.component";



const routes: Routes = [

  {path:'register',
    component:AddCustomerComponent
  },
  {path:'search',
    component:ViewCustomerComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
