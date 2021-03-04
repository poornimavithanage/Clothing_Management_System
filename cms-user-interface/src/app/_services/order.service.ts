import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private _refreshNeeded$ = new Subject<void>();

  get refreshNeeded$() {
    return this._refreshNeeded$;
  }
  constructor(private http: HttpClient) { }

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

  public getAllOrderDetail() {
    return this.http.get("http://localhost:9193/services/orderDetail").pipe(tap(() => {
      this._refreshNeeded$.next();
    }));
  }
}
