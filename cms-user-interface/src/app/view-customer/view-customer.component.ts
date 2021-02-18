import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../customer.service";

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {
  id: any;
  customers: any;

  constructor(private service:CustomerService) { }

  ngOnInit(): void {
    this.service.getAllCustomers().subscribe((data)=>this.customers=data);
  }

  findCustomerById() {
    this.service.viewByCustomerId(this.id).subscribe((data)=>this.customers=data);
  }


}
