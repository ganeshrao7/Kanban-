import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  redirectedUrl:String="";
  constructor() { }
  isAuthenticated:boolean=false;
  login()
  {
    this.isAuthenticated=true;
  }
  register()
  {
    this.isAuthenticated=true;
  }

}