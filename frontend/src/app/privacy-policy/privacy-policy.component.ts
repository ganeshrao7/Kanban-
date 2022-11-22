import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-privacy-policy',
  templateUrl: './privacy-policy.component.html',
  styleUrls: ['./privacy-policy.component.css']
})
export class PrivacyPolicyComponent implements OnInit {
  email!:any;

  constructor(private auth:AuthenticationService) { 
    this.email=sessionStorage.getItem('email');
  }

  ngOnInit(): void {
  }

  log()
  {
    this.auth.logout();
  }

}
