import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

    custDetail !: FormGroup;
    custObj : Customer = new Customer();
    submitted = false;
    custList : Customer[] = [];


  constructor(private formBuilder : FormBuilder, private custService : CustomerService) { }

  ngOnInit(): void {

    this.custDetail = new FormGroup({
      'emailId' : new FormControl(null, [Validators.required, Validators.email]),
      'mobileNo' : new FormControl(
        null,
        [
          Validators.required,
          Validators.pattern('^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$')
        ]
        )
    });

    this.getAllCustomer();
    this.custDetail = this.formBuilder.group({
      customerId : [''],
      customerName : [''],
      dateOfBirth : [''],
      mobileNo : [''],
      emailId : ['']
    });

  }

  addCustomer(){
    console.log(this.custDetail);
    this.custObj.customerId = this.custDetail.value.customerId;
    this.custObj.customerName = this.custDetail.value.customerName;
    this.custObj.dateOfBirth= this.custDetail.value.dateOfBirth;
    this.custObj.mobileNo = this.custDetail.value.mobileNo;
    this.custObj.emailId = this.custDetail.value.emailId;

    this.custService.addCustomer(this.custObj).subscribe(res => {
      console.log(res);
      alert("Customer detail added successfully...");
      this.getAllCustomer();
    },err=>{
      console.log(err);
    });
  }

  getAllCustomer(){

    this.custService.getAllCustomer().subscribe(res=>{
      this.custList = res;
    },err=>{
      console.log("error while fetching data.");
    });

  }

  newCustomer(){
    this.custObj = new Customer();
    this.submitted = false;
  }

  fetchById(){
    this.custService.fetchById(this.custObj.customerId).subscribe(res =>{
      this.custObj = res;
      console.log(res);
    }, err =>{
      console.log(err);
    })
  }

  onSubmit(){
    this.submitted = true;
    this.fetchById();
  }

  editCustomer(cust : Customer){
    this.custDetail.controls['customerId'].setValue(cust.customerId);
    this.custDetail.controls['customerName'].setValue(cust.customerName);
    this.custDetail.controls['dateOfBirth'].setValue(cust.dateOfBirth);
    this.custDetail.controls['mobileNo'].setValue(cust.mobileNo);
    this.custDetail.controls['emailId'].setValue(cust.emailId);
  }

  updateCustomer(){
    this.custObj.customerId = this.custDetail.value.customerId;
    this.custObj.customerName = this.custDetail.value.customerName;
    this.custObj.dateOfBirth= this.custDetail.value.dateOfBirth;
    this.custObj.mobileNo = this.custDetail.value.mobileNo;
    this.custObj.emailId = this.custDetail.value.emailId;

    this.custService.updateCustomer(this.custObj).subscribe(res=>{
      console.log(res);
      this.getAllCustomer();
    }, err=>{
      console.log(err);
    });
  }

  deleteCustomer(cust : Customer){

    this.custService.deleteCustomer(cust).subscribe(res=>{
      console.log(res);
      alert("Customer detail deleted successfully...");
      this.getAllCustomer();
    }, err=>{
      console.log(err);
    })

  }

}
