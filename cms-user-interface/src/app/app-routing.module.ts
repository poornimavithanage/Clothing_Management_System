import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddCustomerComponent} from "./add-customer/add-customer.component";
import {HomePageComponent} from "./home-page/home-page.component";
import {ProductComponent} from "./product/product.component";
import {OrderComponent} from "./order/order.component";
import {PaymentComponent} from "./payment/payment.component";
import {HomeComponent} from "./home/home.component";
import {RegisterComponent} from "./register/register.component";
import {ProfileComponent} from "./profile/profile.component";
import {BoardUserComponent} from "./board-user/board-user.component";
import {BoardModeratorComponent} from "./board-moderator/board-moderator.component";
import {BoardAdminComponent} from "./board-admin/board-admin.component";




const routes: Routes = [

  {path:'login', component:HomePageComponent},
  {path:'customer', component:AddCustomerComponent},
  {path:'product', component:ProductComponent},
  {path:'order', component:OrderComponent},
  {path:'payment', component:PaymentComponent},

  { path: 'home', component: HomeComponent },
  // { path: 'login', component: HomePageComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
