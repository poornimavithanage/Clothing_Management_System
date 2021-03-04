import { Component, OnInit } from '@angular/core';
import {Customer} from "../customer";
import {CustomerService} from "../_services/customer.service";
import {ActivatedRoute} from "@angular/router";
import {TokenStorageService} from "../_services/token-storage.service";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  customer: Customer=new Customer("","","","");
  id: any;
  customers: any;
  message: any;
  customerForm: FormGroup;
  currentUser: any;
  constructor(private service:CustomerService,private route: ActivatedRoute,private token: TokenStorageService) { }

  ngOnInit(): void {
    this.service.getAllCustomers().subscribe((data)=>this.customers=data);
  }

  public registerCustomer(){
    //console.log(this.customer);
    this.service.registerCustomer(this.customer).subscribe((data:any)=>this.message=data);
  }

  findCustomerById() {
    this.service.viewByCustomerId(this.id).subscribe((data)=>this.customers=data);
  }

}
