import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../customer.service";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers:any;
  id:any;
  constructor(private service:CustomerService) { }

  ngOnInit(): void {
    this.service.getAllCustomer().subscribe((data)=>this.customers=data);
  }

  public findCustomerById(){
    this.service.viewCustomerById(this.id).subscribe((data)=>this.customers=data);
  }
}
