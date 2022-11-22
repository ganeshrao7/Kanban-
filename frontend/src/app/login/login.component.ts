import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
import { AuthService } from '../services/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  loginForm!:FormGroup
  emailId!:string;
  constructor(private authService:AuthenticationService , private router:Router , private authentication:AuthService){}
   ngOnInit(){
     this.initForm();
   }
  initForm() {
    this.loginForm=new FormGroup({
      email:new FormControl("",[Validators.required,Validators.email]),
      password:new FormControl("",[Validators.required,Validators.minLength(8)])
   })
    }
    loginProcess(){
          this.emailId=this.loginForm.controls.email.value;
          sessionStorage.setItem('email',this.emailId);
          this.authService.loginf(this.loginForm.value).subscribe(result=>{
          
            console.log(result)
            sessionStorage.setItem('token',result.jwtToken)
            this.authentication.login();
            this.router.navigate(['/kanban'])
          },
          err=>console.log(err)
          )
      }
    
  
  
    get email() {
      return this.loginForm.get('email') as FormControl;
    }
  
    get password() {
      return this.loginForm.get('password') as FormControl;
    }
  }