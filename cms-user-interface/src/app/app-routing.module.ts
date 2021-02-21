import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddCustomerComponent} from "./add-customer/add-customer.component";
import {HomePageComponent} from "./home-page/home-page.component";
import {ProductComponent} from "./product/product.component";
import {OrderComponent} from "./order/order.component";
import {PaymentComponent} from "./payment/payment.component";




const routes: Routes = [

  {
    path:'',
    component:HomePageComponent
  },
  {
    path:'register',
    component:AddCustomerComponent
  },

  {
    path:'product',
    component:ProductComponent
  },
  {
    path:'order',
    component:OrderComponent
  },
  {
    path:'payment',
    component:PaymentComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
