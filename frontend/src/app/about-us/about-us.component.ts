import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-about-us',
  templateUrl: './about-us.component.html',
  styleUrls: ['./about-us.component.css']
})
export class AboutUsComponent implements OnInit {
  emailId!:any;
  constructor(private auth:AuthenticationService) { 
    this.emailId=sessionStorage.getItem('email');
  }

  ngOnInit(): void {
  }
  logoutbutton()
      {
        this.auth.logout();
      }
}
