import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../customer.service";
import {Customer} from "../customer";

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  customer: Customer = new Customer("","","","");
  message: any;
  constructor(private service:CustomerService) { }

  ngOnInit(): void {
  }

  public registerCustomer(){
    this.service.registerCustomer(this.customer).subscribe((data:any)=>this.message=data);
  }

}
