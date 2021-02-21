import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }

  public placeOrder():Observable<any>{
    return this.http.post("http://localhost:9193/services/orders","");
  }

  public viewOrderDetails(){
    return this.http.get("http://localhost:9193/services/orders");
  }

  public addOrderDetail(orderDetail):Observable<any>{
    return this.http.post("http://localhost:9193/services/orderDetails",orderDetail);
  }

  public getProductDetail(code){
    return this.http.get("http://localhost:9191/services/product-management/products"+code);
  }

  public savePayment(){
    return this.http.post("http://localhost:8081/services/payments","");
  }
}
