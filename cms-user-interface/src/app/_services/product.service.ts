import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) {}

  public addProduct(product):Observable<any>{
    console.log(product)
    return this.http.post("http://localhost:9191/services/product-management/products",product)
  }

  public getAllProduct(){
    return this.http.get("http://localhost:9191/services/product-management/products")
  }

  public viewProductByCode(code){
    return this.http.get("http://localhost:9191/services/product-management/products?code="+code)
  }
}
