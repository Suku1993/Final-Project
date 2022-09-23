import { Customer } from './../model/customer';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private addCustURL : string;
  private getAllCustURL : string;
  private updateCustomerURL : string;
  private deleteCustomerURL : string;
  private fetchByIdURL : string;
  private url1 : string = "http://localhost:8080/";
  constructor(private http: HttpClient) {

    this.addCustURL =  this.url1 + 'createCustomer';
    this.getAllCustURL = this.url1 + 'fetchAllCustomer';
    this.updateCustomerURL = this.url1 + 'updateCustomerDetail';
    this.deleteCustomerURL = this.url1 + 'deleteCustomer';
    this.fetchByIdURL = this.url1 + 'fetchCustomerById';

  }

  public addCustomer(cust : Customer):Observable<Customer>  {
      return this.http.post<Customer>(this.addCustURL, cust);
  }

  public getAllCustomer(): Observable<Customer[]>{
    return this.http.post<Customer[]>(this.getAllCustURL, Customer);
  }

  public updateCustomer(cust : Customer) : Observable<Customer>{
    return this.http.put<Customer>(this.updateCustomerURL, cust);
  }

  public deleteCustomer(cust : Customer){
    return this.http.delete<Customer>(this.deleteCustomerURL+'/'+cust.customerId);
  }

  public fetchById(customerId : number): Observable<Customer>{
    return this.http.post<Customer>(this.fetchByIdURL, customerId)
  }
}
