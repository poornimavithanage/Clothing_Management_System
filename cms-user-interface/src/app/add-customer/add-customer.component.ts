import { Component, OnInit } from '@angular/core';
import {Customer} from "../customer";
import {CustomerService} from "../customer.service";

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  customer: Customer=new Customer("","","","");
  message: any;

  constructor(private service:CustomerService) { }

  ngOnInit(): void {
  }

  public registerCustomer(){
    //console.log(this.customer);
    this.service.registerCustomer(this.customer).subscribe((data:any)=>this.message=data);
  }


}
