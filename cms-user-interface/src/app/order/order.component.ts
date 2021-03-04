import { Component, OnInit } from '@angular/core';
import {Order} from "../order";
import {OrderService} from "../_services/order.service";
import {ProductService} from "../_services/product.service";
import {Router} from "@angular/router";
import {OrderDetail} from "../orderDetail";
import {Observable} from "rxjs";

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
   orderDetails: any;
   total: any;
   orderDetailList: any;

  constructor(private service: OrderService,private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
  this.getProductList();
  this.getTotal(this.orderDetails);
  }

  public addOrderDetails(){
     this.service.addOrderDetail(this.orderDetail).subscribe((data)=>this.message=data);
  }

  placeOrder() {
    console.log("place order");
    this.service.placeOrder().subscribe();
    // this.service.registerCustomer(this.customer).subscribe((data:any)=>this.message=data);
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




  deleteUser(id) {

  }

  public addDetail(){
    this.service.refreshNeeded$.subscribe(()=>{
     this.service.getAllOrderDetail().subscribe((data)=>this.orderDetails=data)
      this.getTotal(this.orderDetails);
    })

    this.service.getAllOrderDetail().subscribe((data)=>this.orderDetails=data);
    this.getTotal(this.orderDetails);

    console.log(this.orderDetails);

  }

  getTotal(orderDetails) {
    let total = 0;

    orderDetails.map((product) => {
      total += Number(product.price);
    });
    console.log(total);
    this.total=total

    return this.total;
  }
}
