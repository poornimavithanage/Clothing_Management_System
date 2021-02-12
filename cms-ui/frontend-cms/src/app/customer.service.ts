import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "./customer";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }

  public registerCustomer(customer):Observable<any>{
    console.log("this service call");
    return this.http.post("http://localhost:8081/services/customer-management/customers",customer,{responseType:'text' as 'json'});
  }

  public viewCustomerById(id){
    return this.http.get("http://localhost:8080/services/customer-management/customers/"+id);
  }

  public getAllCustomer(){
    return this.http.get("http://localhost:8080/services/customer-management/customers");
  }
}
