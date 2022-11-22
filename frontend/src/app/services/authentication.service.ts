import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import { Observable } from 'rxjs';
import { url } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  login(value: any) {
    throw new Error('Method not implemented.');
  }
  urlPrefix!: string
  constructor(private httpClient:HttpClient,private router:Router) { }
  apiURL='http://localhost:8080';

  
  public register(data:any): Observable<any> {
    const headers = { 'content-type': 'application/json'}  
    const body=JSON.stringify(data);
   console.log(body)
    return this.httpClient.post<any>(this.apiURL + '/authentication/api/v1/register', body,{'headers':headers})
  }
  loginf(data:any):Observable<any>
  {
    console.log("I am service");
    return this.httpClient.post(`${url}/login`,data);
  }
  loggedIn(){
    return !!sessionStorage.getItem('token')
  }
  logout(){
     sessionStorage.removeItem('token');
     this.router.navigate(['/login']);

  }
}