import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../model-classes/User';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent  {
  constructor(private router:Router, private authService:AuthenticationService,private http:HttpClient) {  this.createRegisterForm();}
  ngOnInit(): void {
  }
  registerForm!:FormGroup
  detail:User={
    username: '',
    email: '',
    phoneno: '',
    password: '',
    token: ''
  }
  createRegisterForm() :void{
    this.registerForm=new FormGroup({
      "username":new FormControl(this.detail.username,[Validators.required]),
      "email":new FormControl(this.detail.email,[Validators.required,Validators.email]),
      "phoneno":new FormControl(this.detail.phoneno,[Validators.required]),
      "password":new FormControl(this.detail.password,[Validators.required,Validators.minLength(8)]),
      
    });
  }
  onSubmit(){
    const Observable= this.authService.register(this.registerForm.value);
    console.log(Observable)
    Observable.subscribe((data:{}) =>{
   alert("Registered Successfully")
      this.router.navigate(['']);
    });
  }
  get username() {
    return this.registerForm.get('username') as FormControl;
  }
  get email() {
    return this.registerForm.get('email') as FormControl;
  }
  get phoneno() {
    return this.registerForm.get('phoneno') as FormControl;
  }
  get password() {
    return this.registerForm.get('password') as FormControl;
  }
  }