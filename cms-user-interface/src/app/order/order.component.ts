import { Component, OnInit } from '@angular/core';
import {Order} from "../order";
import {OrderService} from "../order.service";
import {ProductService} from "../product.service";
import {Router} from "@angular/router";
import {OrderDetail} from "../orderDetail";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

   order: Order= new Order(0,"");
   orderDetail: OrderDetail = new OrderDetail("",0,0,0);
   message: any
   products: any
   productPrice: any

  constructor(private service:OrderService,private productService:ProductService,private router:Router) { }

  ngOnInit(): void {
  this.getProductList();
  }

  public addOrderDetails(){
     this.service.addOrderDetail(this.orderDetail).subscribe((data)=>this.message=data);
  }

  private getProductList() {
    this.productService.getAllProduct().subscribe((data)=>this.products=data);
  }

  public getProductDetail(){
     this.service.getProductDetail(this.orderDetail.productCode).subscribe((data)=>this.productPrice=data);
  }

  public savePayment(){
     console.log("saved");
     this.service.savePayment().subscribe();
  }

  goToPage(payment):void{
     console.log("payment");
     this.router.navigate([payment]);
  }


  placeOrder() {
     console.log("place order");
    this.service.placeOrder().subscribe();
  }
}
