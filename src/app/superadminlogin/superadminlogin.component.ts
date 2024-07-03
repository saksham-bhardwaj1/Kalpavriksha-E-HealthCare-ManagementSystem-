import { Component, OnInit } from '@angular/core';
import { AdminauthService } from '../adminauth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './superadminlogin.component.html',
  styleUrls: ['./superadminlogin.component.css'],
})
export class SuperAdminLoginComponent implements OnInit {
  username2 = 'admin';
  password2 = '';
  invalidLogin = false;

  constructor(private router: Router, public loginservice: AdminauthService) {}

  ngOnInit(): void {}

  checkLogin() {
    if (
      this.loginservice.authenticateSuperAdmin(this.username2, this.password2)
    ) {
      this.router.navigate(['medicinelist']);

      this.invalidLogin = false;
    } else {
      this.invalidLogin = true;
      alert('Wrong Credentials');
      this.router.navigate(['home']);
    }
  }
}
