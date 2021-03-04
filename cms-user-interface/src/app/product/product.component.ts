import { Component, OnInit } from '@angular/core';
import {Product} from "../product";
import {ProductService} from "../_services/product.service";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  product: Product=new Product("","","",0,0);
  message: any;
  products:any;
  code:any;

  constructor(private service:ProductService) { }

  ngOnInit(): void {
    this.service.getAllProduct().subscribe((data)=>this.products=data);
  }

  public addProduct(){
    this.service.addProduct(this.product).subscribe((data)=>this.message=data);
  }

public findProductByCode(){
  this.service.viewProductByCode(this.code).subscribe((data)=>this.products=data);
}

}
