import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { Customer } from '../customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }

  public registerCustomer(customer: Customer):Observable<any>{
    console.log("service calling....");
    return this.http.post("http://localhost:8083/services/customer-management/customers",customer,{responseType:'text' as 'json'});

  }

  public viewByCustomerId(id): Observable<Customer>{
    return this.http.get<Customer>("http://localhost:8083/services/customer-management/customers/"+id);
  }

  public getAllCustomers(){
    return this.http.get("http://localhost:8083/services/customer-management/customers");
  }
}
